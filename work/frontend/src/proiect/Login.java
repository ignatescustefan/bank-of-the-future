package proiect;

import proiect.Utilizator;
import proiect.Manager;

import java.io.IOException;
import javax.ws.rs.core.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

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

		//redirectare la /api/login cu username=user & pass=pass -> gresit
		//response.sendRedirect("/RIPBankServiciiWeb/api"+"/login");
		//System.out.println("/RIPBankServiciiWeb/api"+"/login");
		
		System.out.println("Mesaj 1");
		log("your debug message");
		
		Utilizator user=new Utilizator();
		user.setEmail(u);
		user.setPassword(p);
		
		/*
	    Client client = ClientBuilder.newClient();
	    WebTarget webTarget = client.target("http://localhost:8080/RIPBankServiciiWeb/api/login");
	    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	    Response myResponse = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
	     */    
	    
		
		Manager m=new Manager();
		Response myResponse = m.createJsonUtilizator(user);
		
		System.out.println("Mesaj 2");
		System.out.println(myResponse);
        //primesc un json			
		//deserializare json
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
