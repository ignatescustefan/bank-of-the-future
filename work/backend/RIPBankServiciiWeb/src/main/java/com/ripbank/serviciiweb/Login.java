package com.ripbank.serviciiweb;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.ripbank.core.User;

/**
 * Root resource (exposed at "login" path)
 */

@Path("login")
public class Login {
	//assume that the connection with db is ok
	private boolean userAndPasswordExists(String email, String password) {
		//TODO: connect to db, see if is ok
		return false;
	}

	//something with @Produces
	//@give a response for /login request
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getAuthorizedUser(@FormParam("username") String email, @FormParam("password") String password) {
		JSONObject jsonObject=new JSONObject();
		if (userAndPasswordExists(email, password)) {
			System.out.println("S-a ajuns aici");
			jsonObject.append("LoginOK", 1);
			jsonObject.append("username", "ana");
			jsonObject.append("nume", "ion");
			//TODO: log this, not console printing
			System.out.println(jsonObject.toString());
			//it's ok
			return Response
					.status(200)
					.entity(jsonObject.toString())
					.build();
		}
		else {
			jsonObject.append("LoginOK", 0);
			return Response
					.status(200)
					.entity(jsonObject.toString())
					.build();
		}
	}
}