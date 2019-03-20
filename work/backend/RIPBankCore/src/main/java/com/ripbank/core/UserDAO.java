package com.ripbank.core;

import java.util.List;

public interface UserDAO {
	public List<User> findUserByEmail(String email);
	
	public List<User> findUserByEmailAndPassword(String email, String password);
	
	public List<User> findUserByCNP(String cnp);
}