package com.ripbank.serviciiweb;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.ripbank.core.Employee;
import com.ripbank.core.User;
import com.ripbank.core.DTO.CredentialsDTO;
import com.ripbank.db.DBManager;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("login")
public class Login {
	
	private JSONObject checkUserEmailAndPass(CredentialsDTO user) {
		//TODO: need to log this
		List<User> usersList=DBManager.getInstance().findUserByEmailAndPassword(user.getEmail(), user.getPassword());
		if (null == usersList || 1 != usersList.size()) {
			//not successful 
			return new JSONObject()
					.put("LoginOk", 0);
		}
		return new JSONObject()
				.put("LoginOk", 1)
				.put("CNP", usersList.get(0).getCnp())
				.put("Email", usersList.get(0).getEmail())
				.put("Nume", usersList.get(0).getNume())
				.put("Prenume", usersList.get(0).getPrenume())
				.put("Telefon", usersList.get(0).getTelefon());
	}

	private JSONObject checkEmployeeEmailAndPass (CredentialsDTO employee) {
		List<Employee> employees=DBManager.getInstance()
				.findEmployeeByEmailAndPass(employee.getEmail(), employee.getPassword());
		if (null == employees || 1 != employees.size()) {
			//not successful 
			return new JSONObject()
					.put("LoginOk", 0);
		}
		return new JSONObject()
				.put("LoginOk", 1)
				.put("Email", employees.get(0).getEmail())
				.put("Nume", employees.get(0).getNume())
				.put("Prenume", employees.get(0).getPrenume());
	}
	
	@GET
	@Produces({MediaType.TEXT_PLAIN})
	public String returnSmth() {
		return "da";
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAuthorizedUser(CredentialsDTO user) {
		//System.out.println("S-a ajuns aici");
		JSONObject jsonObject=checkUserEmailAndPass(user);
		//TODO: log this, not console printing
		SimpleLogging.apel();
		System.out.println(jsonObject.toString());
		return Response
				.status(200)
				.entity(jsonObject.toString())
				.build();
	}
	
	@Path("/employee")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAuthorizedEmployee(CredentialsDTO user) {
		JSONObject jsonObject=checkEmployeeEmailAndPass(user);
		System.out.println("Se logheaza un angajat");
		return Response
				.status(200)
				.entity(jsonObject.toString())
				.build();
	}
	
	//TODO: need to move verifyTokenAuth to another API
	@Path("/{cnp}")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Response verifyTokenAuth(@PathParam("cnp") String cnp) {
		//TODO: get current time; if it's <1 min, return ok
		/*
		 * if it's fine
		 * return Response.status(200).build();
		 */
		return Response.status(401).build();
				
	}
	
	private static class SimpleLogging {
		/* Get actual class name to be printed on*/
		static Logger log=Logger.getLogger(SimpleLogging.class.getName());
		public static void apel() {
			log.debug("Hello this is a debug message");
			log.info("Hello this is an info message");
		}
	}
	
}