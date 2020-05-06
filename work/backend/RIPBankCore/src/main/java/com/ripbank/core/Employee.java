package com.ripbank.core;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	private String nume;
	private String prenume;
	private String email;
	private String parola;
	
	public Employee() {
	}

	public Employee(String nume, String prenume, String email, String parola) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.email = email;
		this.parola = parola;
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

	@Override
	public String toString() {
		return "Angajat [nume=" + nume + ", prenume=" + prenume + ", email=" + email + "]";
	}
	
	
}