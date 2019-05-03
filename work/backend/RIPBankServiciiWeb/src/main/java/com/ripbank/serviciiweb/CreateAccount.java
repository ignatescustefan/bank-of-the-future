package com.ripbank.serviciiweb;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.logging.Log4J;
import com.ripbank.core.TipCont;
import com.ripbank.db.DBManager;

@Path("createAccount")
public class CreateAccount {
	@Path("{cnp}&{accountType}&{amount}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response createAccount(
			@PathParam("cnp") String cnp,
			@PathParam("accountType") TipCont accountType,
			@PathParam("sold") Double sold) {
		Log4J.getLogger().info("Request for creating account for: "+cnp+", "+accountType+", "+sold);
		String iban=DBManager.getInstance().generateIBAN(cnp);
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("CreatedAccount", DBManager.getInstance().createAccount(cnp, iban, accountType, sold));
		return Response
				.status(200)
				.entity(jsonObj.toString())
				.build();
	}
}
