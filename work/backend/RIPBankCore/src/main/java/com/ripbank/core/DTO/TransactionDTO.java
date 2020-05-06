package com.ripbank.core.DTO;

import com.ripbank.core.TipTranzactie;

public class TransactionDTO {
	private String ibanDest;
	private String ibanSource;
	private double amount;
	private TipTranzactie tipTranzactie;
	private String operatorTranzactie;

	public String getIbanSource() {
		return ibanSource;
	}

	public void setIbanSource(String ibanSource) {
		this.ibanSource = ibanSource;
	}

	public String getIbanDest() {
		return ibanDest;
	}

	public void setIbanDest(String ibanDest) {
		this.ibanDest = ibanDest;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TipTranzactie getTipTranzactie() {
		return tipTranzactie;
	}

	public void setTipTranzactie(TipTranzactie tipTranzactie) {
		this.tipTranzactie = tipTranzactie;
	}

	public String getOperatorTranzactie() {
		return operatorTranzactie;
	}

	public void setOperatorTranzactie(String operatorTranzactie) {
		this.operatorTranzactie = operatorTranzactie;
	}

	@Override
	public String toString() {
		return "TransactionDTO [ibanDest=" + ibanDest + ", ibanSource=" + ibanSource + ", amount=" + amount
				+ ", tipTranzactie=" + tipTranzactie + ", operatorTranzactie=" + operatorTranzactie + "]";
	}

}