package com.ripbank.core.DAO;

import java.util.List;

import com.ripbank.core.User;

public interface UserDAO {
	public List<User> findUserByEmail(String email);
	
	public List<User> findUserByEmailAndPassword(String email, String password);
	
	public List<User> findUserByCNP(String cnp);
	
	public boolean updateUserInformation(String cnp, String nume, String prenume, String telefon);
	
	public boolean deleteClient(String cnp);
}