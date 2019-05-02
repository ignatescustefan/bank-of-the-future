package com.ripbank.serviciiweb;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.logging.Log4J;
import com.ripbank.core.User;
import com.ripbank.db.DBManager;

@Path("addClient")
public class AddClient {
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response addClient(User user) {
		Log4J.getLogger().info("Request for creating an user: " + user.toString());
		JSONObject json=new JSONObject();
		if (DBManager.getInstance().createUser(user)) {
			//random an IBAN
			String accountIBAN = DBManager.getInstance().generateIBAN(user.getCnp());
			// create account by IBAN and user
			if (DBManager.getInstance().createAccount(user, accountIBAN)) {
				Log4J.getLogger().info("Successfully created user: " + user.toString());
				json.put("Created", true);
				return Response.status(200).entity(json.toString()).build();
			}
		}
		json.put("Created", false);
		return Response.status(200).entity(json.toString()).build();
	}
}