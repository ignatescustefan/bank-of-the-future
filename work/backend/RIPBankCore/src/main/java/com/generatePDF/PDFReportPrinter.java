package com.generatePDF;

import com.ripbank.core.DTO.CompleteTransactionDetailsDTO;
import com.ripbank.core.DTO.TransactionReportInformationDTO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter; 
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

public class PDFReportPrinter 
{
	int current_row;
	int current_page;
	int no_of_pages;
	int no_of_records;
	String start_Date;
	String end_Date;
	String dest;
	String cnp;
	Cell cell;
	Table table;
	PdfWriter writer;
	PdfDocument pdfDoc;
	Document doc;
	ByteArrayOutputStream baos;
	FileOutputStream fos;
	ArrayList<CompleteTransactionDetailsDTO> list;

	public PDFReportPrinter(String report_file_path, ArrayList<CompleteTransactionDetailsDTO> list,TransactionReportInformationDTO transactionReportInformationDTO)
	{
		this.list=list;
		current_row=0;
		cnp=transactionReportInformationDTO.getCnp();
		start_Date=transactionReportInformationDTO.getStartDate();
		end_Date=transactionReportInformationDTO.getFinalDate();
		current_page=1;
		no_of_pages=-1;
		no_of_records=list.size();
		if(no_of_records>=0 && no_of_records<=18)
		{
			no_of_pages=1;
		}
		else
		{
			if(no_of_records>18)
			{
				int total_rows=no_of_records;
				int rows_remained=total_rows-18;
				int full_tables_remained=rows_remained/22;
				int rows_last_table=rows_remained-full_tables_remained*22;
				no_of_pages=1+full_tables_remained;
				if(rows_last_table>0)
				{
					no_of_pages++;
				}
			}
		}
		try 
		{
			fos=new FileOutputStream(report_file_path+".pdf");
			writer = new PdfWriter(fos);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Eroare PdfWriter");
			e.printStackTrace();
		}
		baos=new ByteArrayOutputStream();
		pdfDoc = new PdfDocument(writer);                      
		doc = new Document(pdfDoc);
	}

	public Table creare_header_extras_cont() 
	{
		float [] pointColumnWidths1 = {277.0f,278.0f};       
		table = new Table(pointColumnWidths1);                             
		table.setHorizontalAlignment(HorizontalAlignment.CENTER);
		table.setBorder(Border.NO_BORDER);

		Paragraph title=new Paragraph("Extras de cont");
		title.setFontColor(Color.RED);
		title.setFontSize(12);
		Cell h_cell_11=new Cell();
		h_cell_11.add(title);
		h_cell_11.setTextAlignment(TextAlignment.LEFT);
		h_cell_11.setVerticalAlignment(VerticalAlignment.MIDDLE);
		h_cell_11.setBorder(Border.NO_BORDER);

		Paragraph start_date=new Paragraph("Data inceput: "+start_Date);
		start_date.setFontColor(Color.BLACK);
		start_date.setFontSize(12);
		Cell h_cell_12=new Cell();
		h_cell_12.add(start_date);
		h_cell_12.setTextAlignment(TextAlignment.RIGHT);
		h_cell_12.setVerticalAlignment(VerticalAlignment.MIDDLE);
		h_cell_12.setBorder(Border.NO_BORDER);

		Paragraph user=new Paragraph("Utlizator: "+cnp);
		user.setFontColor(Color.BLACK);
		user.setFontSize(12);
		Cell h_cell_21=new Cell();
		h_cell_21.add(user);
		h_cell_21.setTextAlignment(TextAlignment.LEFT);
		h_cell_21.setVerticalAlignment(VerticalAlignment.MIDDLE);
		h_cell_21.setBorder(Border.NO_BORDER);

		Paragraph end_date=new Paragraph("Data sfarsit: "+end_Date);
		end_date.setFontColor(Color.BLACK);
		end_date.setFontSize(12);
		Cell h_cell_22=new Cell();
		h_cell_22.add(end_date);
		h_cell_22.setTextAlignment(TextAlignment.RIGHT);
		h_cell_22.setVerticalAlignment(VerticalAlignment.MIDDLE);
		h_cell_22.setBorder(Border.NO_BORDER);

		table.addCell(h_cell_11);
		table.addCell(h_cell_12);
		table.addCell(h_cell_21);
		table.addCell(h_cell_22);

		return table;
	}

	public void adaugare_celula(String txt)
	{
		cell=new Cell();
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		cell.add(txt);
		cell.setHeight(30f);
		table.addCell(cell);
	}

	public void adaugare_celule_header()
	{
		adaugare_celula("Nr.crt.");
		adaugare_celula("Identificator");
		adaugare_celula("IBAN expeditor");
		adaugare_celula("IBAN destinatar");
		adaugare_celula("Suma");
		adaugare_celula("Data");
		adaugare_celula("Ora");
		adaugare_celula("Operator");
	}

	public void create_new_page()
	{
		add_page_number();
		doc.add(new AreaBreak(AreaBreakType.NEXT_AREA));
		Paragraph two_enters=new Paragraph("\n\n");
		doc.add(two_enters);
	}
	public void add_page_number()
	{
		String page_no="";
		if(no_of_records!=18)
		{
			page_no="\n"+current_page+"/"+no_of_pages;
		}
		else
		{
			page_no=""+current_page+"/"+no_of_pages+"\nDocument generat automat de RIPBank PDF Creator.";
		}
		Paragraph page_number=new Paragraph(page_no);
		page_number.setTextAlignment(TextAlignment.CENTER);
		doc.add(page_number);
		current_page++;
	}
	public Table CreateTable(int inf_limit,int sup_limit)
	{
		float [] pointColumnWidths1 = {29f,50f,123f,123f,40f,50f,40f,100f};       
		table = new Table(pointColumnWidths1);                             
		table.setFontSize(8);
		table.setHorizontalAlignment(HorizontalAlignment.CENTER);

		adaugare_celule_header();

		for(int i=inf_limit;i<=sup_limit;++i)
		{
			adaugare_celula(""+(i+1));
			adaugare_celula(""+(list.get(i).getIdTranzactie()));
			adaugare_celula(list.get(i).getIbanSource());
			adaugare_celula(list.get(i).getIbanDest());
			adaugare_celula(""+list.get(i).getAmount());
			adaugare_celula(list.get(i).getDataTranzactie());
			adaugare_celula(list.get(i).getOraTranzactie());
			adaugare_celula(list.get(i).getOperatorTranzactie());
		}
		return table;
	}
	public void generateReport()
	{
		doc.setMargins(0f, 0f, 0f, 0f);      
		ImageData data=null;
		Image image=null;
		try 
		{
			data = ImageDataFactory.create("https://i.imgur.com/nOmVb2N.png");
		} 
		catch (MalformedURLException e) 
		{
			System.out.println("Eroare citire imagine");
			e.printStackTrace();
		}   
		if(data!=null)
		{
			image = new Image(data);                             
		}
		else
		{
			System.out.println("Eroare creare imagine.");
			return;
		}
		doc.add(image);
		Table header_extras=creare_header_extras_cont();
		doc.add(header_extras);
		current_row=0;
		if(no_of_records>=18)
		{
			Table tab=CreateTable(0,17);
			doc.add(tab);
			if(no_of_records!=18)
			{
				create_new_page();
			}
			else
			{
				add_page_number();
			}
			current_row=18;
			int total_rows=list.size();
			int rows_remained=total_rows-18;
			int full_tables_remained=rows_remained/22;
			int rows_last_table=rows_remained-full_tables_remained*22;
			for(int j=0;j<full_tables_remained;++j)
			{
				tab=CreateTable(current_row,current_row+21);
				doc.add(tab);

				if((j!=full_tables_remained-1 || rows_last_table!=0) && no_of_records!=18)
				{
					create_new_page();
				}
				current_row+=22;
			}
			if(rows_last_table>0)
			{
				tab=CreateTable(current_row,current_row+rows_last_table-1);
				doc.add(tab);
			}
		}
		else
		{
			if(no_of_records>0 && no_of_records<18)
			{
				Table tab=CreateTable(0,no_of_records-1);
				doc.add(tab);
			}
			else
			{
				if(no_of_records<=0)
				{
					String err_msg_1="\n\nNu exista tranzactii in perioada specificata!\n";
					String err_msg_2="Introduceti un alt interval de timp.";
					Paragraph error_message=new Paragraph("");
					error_message.add(err_msg_1);
					error_message.add(err_msg_2);
					error_message.setTextAlignment(TextAlignment.CENTER);
					doc.add(error_message);
				}
			}
		}
		if(no_of_records!=18)
		{
			add_page_number();
			String automatic_message="Document generat automat de RIPBank PDF Creator.";
			Paragraph aut_mess=new Paragraph(automatic_message);
			aut_mess.setTextAlignment(TextAlignment.CENTER);
			doc.add(aut_mess);
		} 
		doc.close();
		try {
			fos.flush();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
