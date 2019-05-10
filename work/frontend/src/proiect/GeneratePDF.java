package proiect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import proiect.StringPDFDecoder;

import DTO.TransactionReportInformationDTO;
import proiect.SendGeneratePDF;

/**
 * Servlet implementation class GeneratePDF
 */
@WebServlet("/GeneratePDF")
public class GeneratePDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneratePDF() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cnp = (String) request.getSession().getAttribute("cnp");
		String startDate = request.getParameter("data_start");
		String finalDate = request.getParameter("data_stop");
		
		System.out.println("Servlet raport tranzactii: " + cnp + " " + startDate + " " + finalDate);
		
		try {
			
			TransactionReportInformationDTO reportInformation = new TransactionReportInformationDTO();
			reportInformation.setCnp(cnp);
			reportInformation.setStartDate(startDate);
			reportInformation.setFinalDate(finalDate);
			
			SendGeneratePDF sendReport = new SendGeneratePDF();
			Response myResponse = sendReport.getAnswer(reportInformation);			
			System.out.println(myResponse);
			
			String informationAsString = myResponse.readEntity(String.class);					
			JSONObject jsonObject = new JSONObject(informationAsString); 			
			System.out.println(informationAsString);
			
			Boolean error = jsonObject.getBoolean("Error");
			
			if (error == false) {
				String byteArray = jsonObject.getString("EncodedByteArrayOfPDF");
				System.out.println(byteArray);
				new StringPDFDecoder("D:\\extras_de_cont.pdf",byteArray).RecreatePDF_File();
				System.out.println("pdf nou creat!");
			}
			
		} catch (Exception e) {
			System.out.println("Eroare in servlet-ul de extras de cont!");
		}
	}

}
