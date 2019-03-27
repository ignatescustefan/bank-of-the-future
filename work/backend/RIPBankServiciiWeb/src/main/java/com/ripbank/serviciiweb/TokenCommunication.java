package com.ripbank.serviciiweb;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ripbank.core.User;
import com.ripbank.db.DBManager;

@Path("tokenAuth")
public class TokenCommunication {

	/**
	 * Root resource (exposed at "tokenAuth" path)
	 */

	// vezi sigur ce returnezi
	// @Produces ceva trebuie sÄƒ fie
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePINToToken(@QueryParam("cnp") String cnp) {
		List<User> usersList = DBManager.getInstance().findUserByCNP(cnp);
		System.out.println("Am ajuns aici");
		if (null == usersList || 1 != usersList.size()) {
			return null;
		} else {
			// TODO: fa asociere cu contul curent @ da pinul
			return usersList.get(0).getCnp();
		}
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public boolean tokenCodeIsValid(@PathParam("cnp") String cnp, @PathParam("tokenCode") String tokenCode) {
		// connect to db, decrypt, see if it's time-valid
		System.out.println(cnp + "   " + tokenCode);
		return false;
	}
}