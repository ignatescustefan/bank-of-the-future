package proiect;

import proiect.Manager;

import java.io.IOException;
import javax.ws.rs.core.*;

import org.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import DTO.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.json.JSONObject;

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
		
		Manager m=new Manager();
		Response myResponse = m.createJsonUtilizator(user);
		
		System.out.println("Mesaj test 2");
		System.out.println(myResponse);
        
		//primesc un json			
		//deserializare json
		
		//String jsonString = EntityUtils.toString(myResponse.getEntity());
		String responseAsString = myResponse.readEntity(String.class);
		JSONObject jsonObject = new JSONObject(responseAsString);
		
		System.out.println(responseAsString);
		
		String loginOk=(String) jsonObject.get("LoginOk");
		System.out.println(loginOk);
		
		//setare atribute sesiune

		/*
		if(UserDAO.instance().verifica(u, p)) {
			HttpSession s=request.getSession(true);
			s.setAttribute("username",u);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/second_step.jsp");
		}
		 */
	}


}
