package proiect;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
				//System.out.println(byteArray);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
				LocalDateTime now = LocalDateTime.now();
				String result_file_name="rep_" + dtf.format(now) + ".pdf";
				String result_file_path = System.getProperty("user.home") + "\\" + result_file_name;
				System.out.println(result_file_path);
				new StringPDFDecoder(result_file_path,byteArray).RecreatePDF_File();
				System.out.println("PDF nou creat!");
				
				HttpSession s=request.getSession(true);
				s.setAttribute("extrasPDF",result_file_path);
						
				response.sendRedirect(request.getContextPath()+"/pages/extras_reusit.jsp");
			}
			else {
				response.sendRedirect(request.getContextPath()+"/pages/extras_nereusit.jsp");
			}
			
		} catch (Exception e) {
			System.out.println("Eroare in servlet-ul de extras de cont!");
			response.sendRedirect(request.getContextPath()+"/pages/extras_nereusit.jsp");
		}
	}

}
