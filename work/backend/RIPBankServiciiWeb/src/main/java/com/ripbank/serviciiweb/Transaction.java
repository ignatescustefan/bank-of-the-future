package com.ripbank.serviciiweb;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

import com.logging.Log4J;
import com.ripbank.core.DTO.TransactionDTO;
import com.ripbank.db.DBManager;
import com.ripbank.serviciiweb.UserAccounts;

@Path("transaction")
public class Transaction {
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response makeTransaction(TransactionDTO transactionDTO) {
		JSONObject object = new JSONObject();
		object.put("TransactionResult", DBManager.getInstance().makeTransaction(transactionDTO));
		JSONObject accounts = UserAccounts
				.retreiveUserAccounts(DBManager.getInstance().getCNPByIBAN(transactionDTO.getIbanSource()));
		Log4J.getLogger().info("Begin a transaction: " + transactionDTO.toString());
		object.put("Accounts", accounts);
		Log4J.getLogger().info("Transaction result: " + object.toString());
		return Response.status(200).entity(object.toString()).build();
	}
}
