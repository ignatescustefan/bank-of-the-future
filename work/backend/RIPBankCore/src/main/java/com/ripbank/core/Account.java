package com.ripbank.core;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {
	private TipCont tipCont;
	private String iban;
	private String proprietarCnp;
	private String PIN;
	private double sold;
	public Account(TipCont tipCont, String iban, String proprietarCnp, String pIN, double sold) {
		super();
		this.tipCont = tipCont;
		this.iban = iban;
		this.proprietarCnp = proprietarCnp;
		PIN = pIN;
		this.sold = sold;
	}
	public TipCont getTipCont() {
		return tipCont;
	}
	public void setTipCont(TipCont tipCont) {
		this.tipCont = tipCont;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getProprietarCnp() {
		return proprietarCnp;
	}
	public void setProprietarCnp(String proprietarCnp) {
		this.proprietarCnp = proprietarCnp;
	}
	public String getPIN() {
		return PIN;
	}
	public void setPIN(String pIN) {
		PIN = pIN;
	}
	public double getSold() {
		return sold;
	}
	public void setSold(double sold) {
		this.sold = sold;
	}

}