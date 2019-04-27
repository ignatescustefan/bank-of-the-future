package com.ripbank.serviciiweb;

import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.ripbank.core.DTO.TransactionReportInformationDTO;
import com.ripbank.core.DTO.CompleteTransactionDetailsDTO;
import com.ripbank.db.DBManager;

@Path("transactionHistory")
public class TransactionHistory {
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response viewTransactionHistory(TransactionReportInformationDTO transactionReportInformationDTO) {
		List<CompleteTransactionDetailsDTO> transactions = DBManager.getInstance()
				.getTransactions(transactionReportInformationDTO);
		JSONObject finalJSONObj = new JSONObject();
		if (transactions != null) {
			for (CompleteTransactionDetailsDTO completeTransactionDetailsDTO : transactions) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("ibanDest", completeTransactionDetailsDTO.getIbanDest());
				jsonObject.put("ibanSource", completeTransactionDetailsDTO.getIbanSource());
				jsonObject.put("amount", completeTransactionDetailsDTO.getAmount());
				jsonObject.put("tipTranzactie", completeTransactionDetailsDTO.getTipTranzactie().toString());
				jsonObject.put("operatorTranzactie", completeTransactionDetailsDTO.getOperatorTranzactie());
				jsonObject.put("idTranzactie", completeTransactionDetailsDTO.getIdTranzactie());
				jsonObject.put("dataTranzactie", completeTransactionDetailsDTO.getDataTranzactie());
				jsonObject.put("oraTranzactie", completeTransactionDetailsDTO.getOraTranzactie());
				finalJSONObj.put("#"+completeTransactionDetailsDTO.getIdTranzactie(), jsonObject);
			}
			return Response.status(200).entity(finalJSONObj.toString()).build();
		}
		return Response.status(200).entity("Error: 1").build();
	}
}
