package com.ripbank.core.DTO;

public class CompleteTransactionDetailsDTO extends TransactionDTO {
	private int idTranzactie;
	private String dataTranzactie;
	private String oraTranzactie;

	public CompleteTransactionDetailsDTO() {
		super();
	}

	public CompleteTransactionDetailsDTO(int idTranzactie, String dataTranzactie, String oraTranzactie) {
		super();
		this.idTranzactie = idTranzactie;
		this.dataTranzactie = dataTranzactie;
		this.oraTranzactie = oraTranzactie;
	}

	public int getIdTranzactie() {
		return idTranzactie;
	}

	public void setIdTranzactie(int idTranzactie) {
		this.idTranzactie = idTranzactie;
	}

	public String getDataTranzactie() {
		return dataTranzactie;
	}

	public void setDataTranzactie(String dataTranzactie) {
		this.dataTranzactie = dataTranzactie;
	}

	public String getOraTranzactie() {
		return oraTranzactie;
	}

	public void setOraTranzactie(String oraTranzactie) {
		this.oraTranzactie = oraTranzactie;
	}

	@Override
	public String toString() {
		return "CompleteTransactionDetailsDTO [idTranzactie=" + idTranzactie + ", dataTranzactie=" + dataTranzactie
				+ ", oraTranzactie=" + oraTranzactie + "]";
	}

}
