package DTO;

public class TransactionDTO {
	private String ibanSursa;
    private String ibanDestinatie;
    private double suma;
    
    public String getIbanSursa() {
		return ibanSursa;
	}
    public String getIbanDestinatie() {
		return ibanDestinatie;
	}
    public double getSuma() {
    	return suma;
    }
    public void setIbanSursa(String newIbanSursa) {
    	ibanSursa=newIbanSursa;
    }
    public void setIbanDestinatie(String newIbanDestinatie) {
    	ibanDestinatie=newIbanDestinatie;
    }
    public void setSuma(double newSuma) {
    	suma=newSuma;
    }
	@Override
	public String toString() {
		return "TransactionDTO [ibanSursa=" + ibanSursa + ", ibanDestinatie=" + ibanDestinatie  + ", suma=" + suma + "]";
	}
}
