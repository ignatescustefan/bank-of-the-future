package com.ripbank.core;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Utilizator {
	
	private String nume;
	private String prenume;
	private String email;
	private String parola;
	private String cnp;
	private String telefon;
	
	public Utilizator() {
		
	}

	public Utilizator(String nume, String prenume, String email, String parola, String cnp, String telefon) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.email = email;
		this.parola = parola;
		this.cnp = cnp;
		this.telefon = telefon;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	@Override
	public String toString() {
		StringBuilder builder=new StringBuilder();
		builder.append("Client: ").append(prenume).append(" ").append(nume);
		builder.append(" Email: ").append(email);
		return builder.toString();
	}
}
