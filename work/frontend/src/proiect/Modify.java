package proiect;

import java.io.IOException;
import java.net.URI;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;
import org.json.JSONObject;

import DTO.PersonDTO;


/**
 * Servlet implementation class Modify
 */

@WebServlet("/Modify")
public class Modify extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//private static Logger log = LoggerFactory.getLogger(Modify.class);
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Modify() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	 private static URI getBaseURI() {
	        return UriBuilder.fromUri("http://localhost:8080/RIPBankServiciiWeb/api/update/userInfo/").build();
	    }
	 	 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nume=request.getParameter("nume");
		String prenume=request.getParameter("prenume");
		String telefon=request.getParameter("telefon");

		String cnp=(String) request.getSession().getAttribute("cnp");

		try {
					
			ClientConfig config = new ClientConfig();
			Client client = ClientBuilder.newClient(config);
			client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
		       
		    WebTarget service = client.target(getBaseURI());
		    
		    Response resp;
		    
		    PersonDTO person = new PersonDTO();
		    person.setNume(nume);
		    person.setPrenume(prenume);
		    person.setTelefon(telefon);
		    
		    System.out.println("Modify before resp");
		    resp = service.path(cnp).request(MediaType.APPLICATION_JSON)
		    		.method("PATCH", Entity.entity(person, MediaType.APPLICATION_JSON), Response.class);
		    System.out.println("Modify after resp");
		    
		    System.out.println(resp);
			
			String informationAsString = resp.readEntity(String.class);					
			JSONObject jsonObject = new JSONObject(informationAsString); 
			
			System.out.println(informationAsString);
			
			int updateStatus = (int) jsonObject.get("UpdateUserInfo");
			System.out.println(updateStatus);
			
			if(updateStatus==1) {
				
				String newNume=(String) jsonObject.get("Nume");
				String newPrenume=(String) jsonObject.get("Prenume");
				String newTelefon=(String) jsonObject.get("Telefon");
				
				HttpSession s=request.getSession(true);
				s.setAttribute("nume",newNume);
				s.setAttribute("prenume",newPrenume);
				s.setAttribute("telefon",newTelefon);
				
				response.sendRedirect(request.getContextPath()+"/pages/modificare_reusita.jsp");
			}
			else {
				response.sendRedirect(request.getContextPath()+"/pages/modificare_nereusita.jsp");
			}
			
		} catch (Exception e) {
			System.out.println("Eroare in servlet-ul modify!");
		}
	}
}
