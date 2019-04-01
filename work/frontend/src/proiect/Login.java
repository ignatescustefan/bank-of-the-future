package proiect;

import proiect.Manager;
import proiect.Account;

import java.io.IOException;
import javax.ws.rs.core.*;

import org.json.JSONArray;
import org.json.JSONObject;
import DTO.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String u=request.getParameter("user");
		String p=request.getParameter("pass");

		System.out.println("Mesaj test 1");
				
		UserDTO user=new UserDTO();
		user.setEmail(u);
		user.setPassword(p);
		
		//send request
		Manager m=new Manager();
		//get answer
		Response myResponse = m.createJsonUtilizator(user);
		
		System.out.println("Mesaj test 2");
		System.out.println(myResponse);
        
		//create json
		String responseAsString = myResponse.readEntity(String.class);
		JSONObject jsonObject = new JSONObject(responseAsString);
		
		System.out.println(responseAsString);
		
		int loginOk=(int) jsonObject.get("LoginOk");
		System.out.println(loginOk);
		
		if(loginOk==1) {
			String nume=(String) jsonObject.get("Nume");
			String prenume=(String) jsonObject.get("Prenume");
			String cnp=(String) jsonObject.get("CNP");
			String email=(String) jsonObject.get("Email");
			String telefon=(String) jsonObject.get("Telefon");
			
			HttpSession s=request.getSession(true);
			s.setAttribute("nume",nume);
			s.setAttribute("prenume",prenume);
			s.setAttribute("cnp",cnp);
			s.setAttribute("email",email);
			s.setAttribute("telefon",telefon);
			
			//send request
			Account a=new Account(cnp);
			//get answer
			Response responseInformation = a.extractAccountInformation();
			
			System.out.println("Mesaj test 3");
			System.out.println(responseInformation);
	        
			//create json
			String informationAsString = responseInformation.readEntity(String.class);
			JSONObject jsonInformation = new JSONObject(informationAsString);
			JSONArray jsonAccount = (JSONArray) jsonInformation.get("account");
			
			System.out.println("Mesaj test 4");
			System.out.println(jsonAccount);
			
			int contor=0;
			for(int i=0;i<jsonAccount.length();i++) {
				JSONObject item=(JSONObject) jsonAccount.get(i);			
				//System.out.println(item);
				++contor;
				
				String iban=item.getString("iban");
				String tipCont=item.getString("tipCont");
				double sold= item.getDouble("sold");
								
				s.setAttribute("iban"+i,iban);
				s.setAttribute("tipCont"+i,tipCont);
				s.setAttribute("sold"+i,sold);
			}
					
			System.out.println(contor);
			s.setAttribute("contor", contor);
			
			response.sendRedirect(request.getContextPath()+"/login/second_step.jsp");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/login/try_again.jsp");			
		}
				
	}

}
