package com.ripbank.core.DTO;

public class ClientInfoDTO {
	private String nume;
	private String prenume;
	private String telefon;

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

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return "ClientInfoDTO [nume=" + nume + ", prenume=" + prenume + ", telefon=" + telefon + "]";
	}
}
