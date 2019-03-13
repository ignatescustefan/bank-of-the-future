package com.ripbank.serviciiweb;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "login" path)
 */
@Path("login")
public class Login {

	//assume that the connection with db is ok
	private boolean userAndPasswordExists(String username, String password) {
		//connect to db, see if is ok
		return false;
	}
	
	//vezi sigur ce returnezi 
	@POST
	//@Produces ceva trebuie să fie
	@Produces(MediaType.TEXT_PLAIN)
	public boolean authorizeLoginAttempt(String username, String password) {
		if (userAndPasswordExists(username, password) && 
				TokenCommunication.tokenCodeIsValid(username)) {
			return true;
		}
		return false;
	}
	
}