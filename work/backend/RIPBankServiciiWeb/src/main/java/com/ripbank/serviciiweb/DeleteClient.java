package com.ripbank.serviciiweb;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.ripbank.db.DBManager;

@Path("delete/{cnp}")
public class DeleteClient {

	//TODO: need to implement this
	@Produces({MediaType.APPLICATION_JSON})
	public Response deleteClient(@PathParam("cnp") String cnp){
		JSONObject jsonObject=new JSONObject();
		boolean val=DBManager.getInstance().deleteClient(cnp);
		jsonObject.put("Deleted", val);
		return Response
				.status(200)
				.entity(jsonObject.toString())
				.build();
	}
}
