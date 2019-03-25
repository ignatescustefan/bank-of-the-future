package com.ripbank.serviciiweb;

public class Utilizator {
	private String email;
    private String password;
    
    public String getEmail() {
		return email;
	}
    public String getPassword() {
		return password;
	}
    void setEmail(String newEmail) {
    	email=newEmail;
    }
    public void setPassword(String newPassword) {
    	password=newPassword;
    }
}
