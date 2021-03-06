package com.ripbank.serviciiweb;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.logging.Log4J;
import com.ripbank.core.Account;
import com.ripbank.db.DBManager;

@Path("accounts/{cnp}")
public class UserAccounts {
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAccounts(@PathParam("cnp") String cnp){
		Log4J.getLogger().info("Request for getting bank accounts for CNP: "+cnp);
		JSONObject json = retreiveUserAccounts(cnp);
		Log4J.getLogger().info("Response for getting bank accounts for CNP: "+cnp+ " :"+json.toString());
		return Response.status(200)
				.entity(json.toString())
				.build();
	}

	static JSONObject retreiveUserAccounts(String cnp) {
		List<Account> accounts=DBManager.getInstance().getClientAccounts(cnp);
		JSONObject json=new JSONObject();
		for (Account acc : accounts) {
			JSONObject obj=new JSONObject()
					.put("iban", acc.getIban())
					.put("tipCont", acc.getTipCont().toString())
					.put("sold", acc.getSold());
			json.append("account", obj);
		}
		return json;
	}
}
