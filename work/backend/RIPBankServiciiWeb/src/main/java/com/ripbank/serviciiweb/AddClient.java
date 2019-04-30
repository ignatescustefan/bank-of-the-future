package com.ripbank.serviciiweb;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.logging.Log4J;
import com.ripbank.core.User;
import com.ripbank.db.DBManager;

@Path("addClient")
public class AddClient {
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response addClient(User user) {
		Log4J.getLogger().info("Request for creating an user: " + user.toString());
		if (DBManager.getInstance().createUser(user)) {
			// random an IBAN
			String accountIBAN = DBManager.getInstance().generateIBAN(user.getCnp());
			// create account by IBAN and user
			if (DBManager.getInstance().createAccount(user, accountIBAN)) {
				Log4J.getLogger().info("Successfully created user: " + user.toString());
				return Response.status(200).entity("Account created").build();
			}
		}
		// TODO: add message for duplicate entry
		return null;
	}
}
