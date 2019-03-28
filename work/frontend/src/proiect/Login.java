package proiect;

import proiect.Manager;

import java.io.IOException;
import javax.ws.rs.core.*;

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
			String username=(String) jsonObject.get("Prenume");
			HttpSession s=request.getSession(true);
			s.setAttribute("username",username);
			response.sendRedirect(request.getContextPath()+"/login/second_step.jsp");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/login/try_again.jsp");			
		}
				
	}

}
