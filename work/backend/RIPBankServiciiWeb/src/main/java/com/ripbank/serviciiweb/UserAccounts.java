package com.ripbank.serviciiweb;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.ripbank.core.Account;
import com.ripbank.core.User;
import com.ripbank.db.DBManager;

@Path("accounts/{cnp}")
public class UserAccounts {
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAccounts(@PathParam("cnp") String cnp){
		List<User> users=DBManager.getInstance().findUserByCNP(cnp);
		List<Account> accounts=DBManager.getInstance().getClientAccounts(cnp);
		JSONObject json=new JSONObject();
		for (Account acc : accounts) {
			json.append("iban", acc.getIban());
			json.put("tipCont", acc.getTipCont().toString());
			json.put("sold", acc.getSold());
		}
				
		return Response.status(200)
				.entity(json.toString())
				.build();
	}
}
