package com.ripbank.core.DTO;

//A class representing the information to be send from see transactions page
public class TransactionReportInformationDTO {
	private String cnp;
	private String startDate;
	private String finalDate;

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(String finalDate) {
		this.finalDate = finalDate;
	}

	public TransactionReportInformationDTO(String cnp, String startDate, String finalDate) {
		super();
		this.cnp = cnp;
		this.startDate = startDate;
		this.finalDate = finalDate;
	}

	public TransactionReportInformationDTO() {
		super();
	}

}
