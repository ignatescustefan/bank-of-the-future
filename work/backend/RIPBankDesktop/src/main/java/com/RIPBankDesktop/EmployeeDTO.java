package com.RIPBankDesktop;

public class EmployeeDTO {
	private String email;
	private String password;
	
	public EmployeeDTO(String user,String pass) {
		email=user;
		password=pass;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
