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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataTranzactie == null) ? 0 : dataTranzactie.hashCode());
		result = prime * result + idTranzactie;
		result = prime * result + ((oraTranzactie == null) ? 0 : oraTranzactie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompleteTransactionDetailsDTO other = (CompleteTransactionDetailsDTO) obj;
		if (dataTranzactie == null) {
			if (other.dataTranzactie != null)
				return false;
		} else if (!dataTranzactie.equals(other.dataTranzactie))
			return false;
		if (idTranzactie != other.idTranzactie)
			return false;
		if (oraTranzactie == null) {
			if (other.oraTranzactie != null)
				return false;
		} else if (!oraTranzactie.equals(other.oraTranzactie))
			return false;
		return true;
	}

}
