package proiect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import DTO.TransactionReportInformationDTO;

/**
 * Servlet implementation class TransactionReport
 */
@WebServlet("/TransactionReport")
public class TransactionReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionReport() {
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
			
			SendReportInformation sendReport = new SendReportInformation();
			Response myResponse = sendReport.getAnswer(reportInformation);			
			System.out.println(myResponse);
			
			String informationAsString = myResponse.readEntity(String.class);					
			JSONObject jsonObject = new JSONObject(informationAsString); 			
			System.out.println(informationAsString);
			
			HttpSession s=request.getSession(true);
			s.setAttribute("contor_RT",jsonObject.length());
			System.out.println(jsonObject.length());
			
			for(int i=0;i<jsonObject.length();++i) {
				
				JSONObject jsonTransaction = (JSONObject) jsonObject.get(""+i);				
				System.out.println(jsonTransaction);
				
				String ibanDest = jsonTransaction.getString("ibanDest");
				String ibanSource = jsonTransaction.getString("ibanSource");
				double amount = jsonTransaction.getDouble("amount");
				String tipTranzactie = jsonTransaction.getString("tipTranzactie");
				String operatorTranzactie = jsonTransaction.getString("operatorTranzactie");
				int idTranzactie = jsonTransaction.getInt("idTranzactie");
				String dataTranzactie = jsonTransaction.getString("dataTranzactie");
				String oraTranzactie = jsonTransaction.getString("oraTranzactie");	
				
				s.setAttribute("ibanDest_RT"+i,ibanDest);
				s.setAttribute("ibanSource_RT"+i,ibanSource);
				s.setAttribute("amount_RT"+i,amount);
				s.setAttribute("tipTranzactie_RT"+i,tipTranzactie);
				s.setAttribute("operatorTranzactie_RT"+i,operatorTranzactie);
				s.setAttribute("idTranzactie_RT"+i,idTranzactie);
				s.setAttribute("dataTranzactie_RT"+i,dataTranzactie);
				s.setAttribute("oraTranzactie_RT"+i,oraTranzactie);
								
			}
			
			response.sendRedirect(request.getContextPath()+"/pages/tabel_raport_tranzactii.jsp");
						
			
		} catch (Exception e) {
			System.out.println("Eroare in servlet-ul de raport tranzactii!");
		}
	}

}
