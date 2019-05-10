package proiect;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;

//import org.apache.tomcat.util.codec.binary.Base64;

public class StringPDFDecoder 
{
	private String absolut_path_of_generated_file;
	private String string_from_byte_array_from_generated_PDF; //raspunsul serviciului de generare PDF
															  //aici pui ce ai scos din acel field al JSON-ului returnat de serviciul de generare PDF
	private OutputStream outputStream;
	private byte[] bytes_from_decoded_string;
	public StringPDFDecoder(String absolut_path_of_generated_file,String string_from_byte_array_from_generated_PDF)
	{
		this.absolut_path_of_generated_file=absolut_path_of_generated_file;
		this.string_from_byte_array_from_generated_PDF=string_from_byte_array_from_generated_PDF;
		try 
		{
			outputStream = new FileOutputStream(this.absolut_path_of_generated_file);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File path error! Check directory hierarchy.");
			e.printStackTrace();
		}  
	}
	
	public void RecreatePDF_File()
	{
		bytes_from_decoded_string = Base64.decodeBase64(string_from_byte_array_from_generated_PDF);
		try 
		{
			outputStream.write(bytes_from_decoded_string);
			outputStream.flush();
		} 
		catch (IOException e) 
		{
			System.out.println("Error at recreating PDF file.");
			e.printStackTrace();
		}
	}
	
}
