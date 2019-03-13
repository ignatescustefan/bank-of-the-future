package com.ripbank.serviciiweb;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("tokenAuth")
public class TokenCommunication {

	/**
	 * Root resource (exposed at "tokenAuth" path)
	 */
	
	//vezi sigur ce returnezi
	//@Produces ceva trebuie să fie
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePINToToken(String cnp) {
		//get the new PIN, and send it back
		String pin="";
		//crypt it
		return pin;
	}
	
	@GET
	@Path("{cnp}")
	@Produces(MediaType.TEXT_PLAIN)
	static protected boolean tokenCodeIsValid(@PathParam("cnp") String cnp) {
		//connect to db, decrypt, see if it's time-valid
		return false;
	}
}