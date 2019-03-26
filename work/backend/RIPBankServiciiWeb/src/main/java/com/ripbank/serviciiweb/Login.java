package com.ripbank.serviciiweb;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.ripbank.core.User;
import com.ripbank.db.DBManager;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.ripbank.core.UserDTO;

/**
 * Root resource (exposed at "login" path)
 */

@Path("login")
public class Login {
	
	//TODO: change to USERDTO
	private JSONObject verifyEmailPasswordCombination(String email, String password) {
		//TODO: need to log this
		List<User> usersList=DBManager.getInstance().findUserByEmailAndPassword(email, password);
		if (null == usersList || 1 != usersList.size()) {
			//not successful 
			return new JSONObject()
					.append("LoginOk", 0);
		}
		return new JSONObject()
				.append("LoginOk", 1)
				.append("CNP", usersList.get(0).getCnp())
				.append("Email", usersList.get(0).getEmail())
				.append("Nume", usersList.get(0).getNume())
				.append("Prenume", usersList.get(0).getPrenume())
				.append("Telefon", usersList.get(0).getTelefon());
	}

	@POST
	//@Consumes("application/x-www-form-urlencoded")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getAuthorizedUser(UserDTO user) {
		JSONObject jsonObject=verifyEmailPasswordCombination(user.getEmail(), user.getPassword());
		System.out.println("S-a ajuns aici");
		//TODO: log this, not console printing
		SimpleLogging.apel();
		System.out.println(jsonObject.toString());
		return Response
				.status(200)
				.entity(jsonObject.toString())
				.build();
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