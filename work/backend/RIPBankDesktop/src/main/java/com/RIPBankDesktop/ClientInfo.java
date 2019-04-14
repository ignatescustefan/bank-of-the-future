package com.RIPBankDesktop;

public class ClientInfo{
	private String nume;
	private String prenume;
	private String email;
	private String telefon;

	public ClientInfo(String nume, String prenume,String email, String telefon) {
		this.nume = nume;
		this.prenume = prenume;
		this.email=email;
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	@Override
	public String toString() {
		return "ClientInfo [nume=" + nume + ", prenume=" + prenume + ", email=" + email + ", telefon=" + telefon + "]";
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
}
