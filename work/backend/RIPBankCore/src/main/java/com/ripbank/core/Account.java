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

}