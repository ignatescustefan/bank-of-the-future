package com.RIPBankDesktop;

import javax.swing.JPanel;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.toedter.calendar.JDateChooser;

import DTO.TransactionReportInformationDTO;
import proiect.SendGeneratePDF;
import proiect.StringPDFDecoder;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class GeneratePDF extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public String cnp;
	private JDateChooser dateSfarsit;
	private JDateChooser dateInceput;
	protected JButton btnGenereazExtras;
	public JButton btnAnuleaza;

	public GeneratePDF() {
		setBounds(0, 57, 893, 70);
		setLayout(null);

		dateSfarsit = new JDateChooser();
		dateSfarsit.setBounds(94, 42, 100, 20);
		add(dateSfarsit);

		dateInceput = new JDateChooser();
		dateInceput.setBounds(94, 11, 100, 20);
		add(dateInceput);

		btnAnuleaza = new JButton("Anuleaza");
		btnAnuleaza.setBounds(804, 45, 89, 23);
		add(btnAnuleaza);

		btnGenereazExtras = new JButton("Generează PDF");
		btnGenereazExtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				generatePDF(cnp);
			}
		});
		btnGenereazExtras.setBounds(212, 39, 138, 23);
		add(btnGenereazExtras);

		JLabel lblDataInceput = new JLabel("Data inceput:");
		lblDataInceput.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataInceput.setBounds(0, 11, 83, 20);
		add(lblDataInceput);

		JLabel lblDataSfarsit = new JLabel("Data sfarsit:");
		lblDataSfarsit.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataSfarsit.setBounds(0, 42, 83, 20);
		add(lblDataSfarsit);
	}

	public void generatePDF(String cnp) {

		if(dateInceput.getDate()==null || dateSfarsit.getDate()==null) {

		}
		else {
			int result = dateInceput.getCalendar().compareTo(dateSfarsit.getCalendar());
			if (result < 0) {
				int year_start = dateInceput.getCalendar().get(Calendar.YEAR);
				int month_start = 1 + dateInceput.getCalendar().get(Calendar.MONTH);
				int day_start = dateInceput.getCalendar().get(Calendar.DATE);
				System.out.println(year_start + " " + month_start + " " + day_start);
				int year_end = dateSfarsit.getCalendar().get(Calendar.YEAR);
				int month_end = 1 + dateSfarsit.getCalendar().get(Calendar.MONTH);
				int day_end = dateSfarsit.getCalendar().get(Calendar.DATE);
				System.out.println(year_end + " " + month_end + " " + day_end);

				TransactionReportInformationDTO transactionReport = new TransactionReportInformationDTO();

				transactionReport.setCnp(cnp);
				String startDate = Integer.toString(year_start) + "-";
				if (month_start < 10) {
					startDate += "0" + Integer.toString(month_start) + "-";
				} else {
					startDate += Integer.toString(month_start) + "-";
				}
				if (day_start < 10) {
					startDate += "0" + Integer.toString(day_start);
				} else {
					startDate += Integer.toString(day_start);
				}
				System.out.println(startDate);
				transactionReport.setStartDate(startDate);
				String finalDate = Integer.toString(year_end) + "-";
				if (month_end < 10) {
					finalDate += "0" + Integer.toString(month_end) + "-";
				} else {
					finalDate += Integer.toString(month_end) + "-";
				}
				if (day_end < 10) {
					finalDate += "0" + Integer.toString(day_end);
				} else {
					finalDate += Integer.toString(day_end);
				}
				System.out.println(finalDate);
				transactionReport.setFinalDate(finalDate);
				SendGeneratePDF sendReport = new SendGeneratePDF();
				Response myResponse = sendReport.getAnswer(transactionReport);
				// System.out.println(myResponse);
				String informationAsString = myResponse.readEntity(String.class);
				JSONObject jsonObject = new JSONObject(informationAsString);
				// System.out.println(informationAsString);

				Boolean error = jsonObject.getBoolean("Error");
				if (error == false) {
					String byteArray = jsonObject.getString("EncodedByteArrayOfPDF");
					// System.out.println(byteArray);
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
					LocalDateTime now = LocalDateTime.now();
					String result_file_name = "rep_" + dtf.format(now) + ".pdf";
					String result_file_path = System.getProperty("user.home") + "\\" + result_file_name;
					System.out.println(result_file_path);
					new StringPDFDecoder(result_file_path, byteArray).RecreatePDF_File();

					JOptionPane.showMessageDialog(null, "PDF nou creat!");
					System.out.println("PDF nou creat!");
				} else {
					JOptionPane.showMessageDialog(null, "Extras nereusit");
					System.out.println("extras nereusit");

				}
			} else {
				System.out.println("dateStart>dateEnd");
				JOptionPane.showMessageDialog(null, "Date inceput mai mare decat data sfarsit");
			}
		}
	}
}
