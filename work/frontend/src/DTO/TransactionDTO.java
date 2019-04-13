package DTO;

import proiect.TipCont;

public class TransactionDTO {
	private String ibanDest;
	private String ibanSource;
	private double amount;
	private TipCont tipCont;
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
	public TipCont getTipCont() {
		return tipCont;
	}
	public void setTipCont(TipCont tipCont) {
		this.tipCont = tipCont;
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
				+ ", tipCont=" + tipCont + ", operatorTranzactie=" + operatorTranzactie + "]";
	}
	
}
