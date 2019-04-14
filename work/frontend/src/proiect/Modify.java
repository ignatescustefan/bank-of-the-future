package proiect;

import java.io.IOException;
import java.net.URI;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;

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

		/*StringBuilder builder=new StringBuilder();
		builder.append("nume="+nume);
		builder.append("&prenume="+prenume);
		builder.append("&telefon="+telefon);*/
					
				
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
	       
	    WebTarget service = client.target(getBaseURI());
	    
	    Response resp;
	    
	    PersonDTO person = new PersonDTO();
	    person.setNume(nume);
	    person.setPrenume(prenume);
	    person.setTelefon(telefon);
	    		
	    resp = service.path(cnp).request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(person, MediaType.APPLICATION_JSON), Response.class);
       
       
	}
}