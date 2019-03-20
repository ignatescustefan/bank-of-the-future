package com.ripbank.core;

public interface UserDAO {
	public boolean findUserByEmail(String email);
	
	public boolean findUserByCNP(String cnp);
}
