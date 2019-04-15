package com.ripbank.serviciiweb;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.ripbank.core.DTO.TransactionDTO;
import com.ripbank.db.DBManager;

@Path("transaction")
public class Transaction {
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Response makeTransaction(TransactionDTO transactionDTO) {
		JSONObject object = new JSONObject();
		object.put("TransactionResult", DBManager.getInstance().makeTransaction(transactionDTO));
		System.out.println("BE:" + object);
		return Response
				.status(200)
				.entity(object.toString())
				.build();
	}
}
