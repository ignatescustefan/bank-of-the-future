package proiect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import DTO.TransactionDTO;

/**
 * Servlet implementation class Transaction
 */
@WebServlet("/Transaction")
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operator_tranzactie = request.getParameter("operator_tranzactie");
		String nr_cont = request.getParameter("selectare_cont");
		String tip_cont = (String) request.getSession().getAttribute("tipCont"+nr_cont);
		String iban_sursa = (String) request.getSession().getAttribute("iban"+nr_cont);
		String iban_destinatie = request.getParameter("iban_destinatie");
		Double suma_introdusa = Double.parseDouble(request.getParameter("suma"));
		Double suma_disponibila = Double.parseDouble((request.getSession().getAttribute("sold"+nr_cont)).toString());
		
		System.out.println("Servlet tranzactii: " + operator_tranzactie + " " + nr_cont + " " + tip_cont + " " + iban_sursa + " " + iban_destinatie + " " + suma_disponibila + " " + suma_introdusa);
		
		if(suma_introdusa<=suma_disponibila) {
			
			try {

				TransactionDTO transaction=new TransactionDTO();
				transaction.setOperatorTranzactie(operator_tranzactie);
				transaction.setIbanSource(iban_sursa);
				transaction.setIbanDest(iban_destinatie);
				transaction.setAmount(suma_introdusa);	
				
				TipTranzactie tip_tranzactie = TipTranzactie.depunere;			
				transaction.setTipTranzactie(tip_tranzactie);
				
				SendTransaction myTransaction=new SendTransaction();
				Response myResponse = myTransaction.getAnswer(transaction);
				
				System.out.println(myResponse);
				
				String informationAsString = myResponse.readEntity(String.class);					
				JSONObject jsonObject = new JSONObject(informationAsString); 
				
				System.out.println(informationAsString);
				
				Boolean transactionResult = (Boolean) jsonObject.get("TransactionResult");
				System.out.println(transactionResult);
				
				if(transactionResult==true) {
					
					JSONObject jsonAccountFirst = (JSONObject) jsonObject.get("Accounts");
					JSONArray jsonAccount = (JSONArray) jsonAccountFirst.get("account");
					
					System.out.println("Mesaj transaction true");
					System.out.println(jsonAccount);
					
					HttpSession s=request.getSession(true);
					
					for(int i=0;i<jsonAccount.length();i++) {
						JSONObject item=(JSONObject) jsonAccount.get(i);			
						System.out.println(item);
											
						String iban=item.getString("iban");
						String tipCont=item.getString("tipCont");
						double sold= item.getDouble("sold");
						
						s.setAttribute("iban"+i,iban);
						s.setAttribute("tipCont"+i,tipCont);
						s.setAttribute("sold"+i,sold);
					}
									
					response.sendRedirect(request.getContextPath()+"/pages/tranzactie_reusita.jsp");
				}
				else {
					response.sendRedirect(request.getContextPath()+"/pages/tranzactie_nereusita.jsp");
				}
			
			} catch (Exception e) {
				System.out.println("Eroare in servlet-ul de tranzactie!");
			}
		}
		else {
			response.sendRedirect(request.getContextPath()+"/pages/tranzactie_nereusita.jsp");
		}
	}

}
