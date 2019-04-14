package com.ripbank.serviciiweb;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import com.ripbank.core.User;
import com.ripbank.db.DBManager;

@Path("clients")
public class SearchClient {
	@POST 
	@Path("{cnp}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getClient(@PathParam("cnp") String cnp){
		System.out.println("Dsa");
		List<User> clients=DBManager.getInstance().findUserByCNP(cnp);
		JSONObject json=new JSONObject();
		if (null== clients || clients.size() >1) {
			json.put("Error", 1);
		}
		else {
			for (User client : clients) {
				JSONObject obj=new JSONObject()
						.put("nume", client.getNume())
						.put("prenume", client.getPrenume())
						.put("email", client.getEmail())
						.put("parola", client.getParola())
						.put("telefon", client.getTelefon());
				json.append("client", obj);
			}
		}
		//la asta nu ajunge
		System.out.println(json.toString());
		return Response.status(200)
				.entity(json.toString())
				.build();
	}
}
