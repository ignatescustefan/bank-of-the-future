package com.ripbank.serviciiweb;


import java.io.ByteArrayOutputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.generatePDF.PDFReportPrinter;
import com.logging.Log4J;
import com.ripbank.core.DTO.CompleteTransactionDetailsDTO;
import com.ripbank.core.DTO.TransactionReportInformationDTO;
import com.ripbank.db.DBManager;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONObject;


@Path("generatePDFReport")
public class GeneratePDFReport
{
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response generatePDFReportOfTransactions(TransactionReportInformationDTO transactionReportInformationDTO) 
	{
		List<CompleteTransactionDetailsDTO> transactions = DBManager.getInstance().getTransactions(transactionReportInformationDTO);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		String result_file_path="rep_"+dtf.format(now);
		PDFReportPrinter PDF_Report_Printer=new PDFReportPrinter(result_file_path,
				(ArrayList<CompleteTransactionDetailsDTO>) transactions,
				transactionReportInformationDTO);
		System.out.println("GENERAREEE");
		PDF_Report_Printer.generateReport();
		FileInputStream fis=null;
		ByteArrayOutputStream byteArrayOutputStream=null;
		try 
		{
			fis=new FileInputStream(result_file_path+".pdf");
			byte[] buffer = new byte[8192];
		    byteArrayOutputStream = new ByteArrayOutputStream();

		    int bytesRead;
		    while ((bytesRead = fis.read(buffer)) != -1)
		    {
		        byteArrayOutputStream.write(buffer, 0, bytesRead);
		    }
		    fis.close();
		    byteArrayOutputStream.flush();
		} 
		catch (IOException e) 
		{
			System.out.println("Eroare la conversia PDF-ului in ByteArrayOutputStream!");
			e.printStackTrace();
		}
		
	    if(byteArrayOutputStream==null)
	    {
	    	System.out.println("ByteArrayOutputStream al pdf-ului este NULL.");
	    	JSONObject jsonObject = new JSONObject().put("Error", true);
			Log4J.getLogger().info("Error at converting "+result_file_path+".pdf to ByteArray.");
			return Response.status(200).entity(jsonObject.toString()).build();
	    }
	    
	    byte[] bytes = byteArrayOutputStream.toByteArray();
	    String base64String = Base64.encodeBase64String(bytes);
	    
	    //new StringPDFDecoder("AnaAreMere114444.pdf",base64String).RecreatePDF_File();
	    
	    if(base64String!=null)
	    {
	    	JSONObject jsonObject = new JSONObject().put("Error", false);
	    	jsonObject.put("EncodedByteArrayOfPDF",base64String);
	    	Log4J.getLogger().info("Sent the pdf report file named: "+result_file_path+".pdf");
	    	return Response.status(200).entity(jsonObject.toString()).build();
	    }
	    JSONObject jsonObject = new JSONObject().put("Error", true);
		Log4J.getLogger().info("Sent the pdf report file named: "+result_file_path+".pdf");
		return Response.status(200).entity(jsonObject.toString()).build();
	    
	    
	    
	}
	
}
