package com.ripbank.serviciiweb;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.ripbank.core.User;
import com.ripbank.db.DBManager;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Root resource (exposed at "login" path)
 */

@Path("login")
public class Login {
	//assume that the connection with db is ok
	private boolean userAndPasswordExists(String email, String password) {
		//TODO:2 must return null or USER (with no password)
		//TODO:2 for saving in session
		List<User> usersList=DBManager.getInstance().findUserByEmailAndPassword(email, password);
		if (null == usersList || 1 != usersList.size()) {
			return false;
		}
		return true;
	}

	@POST
	//@Consumes("application/x-www-form-urlencoded")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getAuthorizedUser(Utilizator user) {
		JSONObject jsonObject=new JSONObject();
		String email=user.getEmail();
		String password=user.getPassword();
		
		if (userAndPasswordExists(email, password)) {
			System.out.println("S-a ajuns aici");
			jsonObject.append("LoginOk", 1);
			jsonObject.append("username", "ana");
			jsonObject.append("nume", "ion");
			//TODO: log this, not console printing
			System.out.println(jsonObject.toString());
			return Response
					.status(200)
					.entity(jsonObject.toString())
					.build();
		}
		else {
			//TODO: log this, not console printing
			System.out.println("else");
			jsonObject.append("LoginOk", 0);
			return Response
					.status(200)
					.entity(jsonObject.toString())
					.build();
		}
	}

	@GET
	public void getAuthorizedUserGET() {
		System.out.println("da");
	}
}