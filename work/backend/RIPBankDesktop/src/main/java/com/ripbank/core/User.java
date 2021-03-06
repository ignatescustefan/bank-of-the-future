package com.ripbank.core;

public class User {
	private String nume;
	private String prenume;
	private String email;
	private String parola;
	private String cnp;
	private String telefon;
	private ClientStatus clientStatus=ClientStatus.activ;

	public User() {
		super();
	}

	public User(String nume, String prenume, String email, String parola, String cnp, String telefon,
			ClientStatus clientStatus) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.email = email;
		this.parola = parola;
		this.cnp = cnp;
		this.telefon = telefon;
		this.clientStatus = clientStatus;
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

	public ClientStatus getClientStatus() {
		return clientStatus;
	}

	public void setClientStatus(ClientStatus clientStatus) {
		this.clientStatus = clientStatus;
	}

	@Override
	public String toString() {
		return "User [nume=" + nume + ", prenume=" + prenume + ", email=" + email + ", parola=" + parola + ", cnp="
				+ cnp + ", telefon=" + telefon + ", clientStatus=" + clientStatus + "]";
	}

}
