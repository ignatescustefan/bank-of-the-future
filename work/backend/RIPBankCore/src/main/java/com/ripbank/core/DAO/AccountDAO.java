package com.ripbank.core.DAO;

import java.util.List;

import com.ripbank.core.Account;

public interface AccountDAO {
	public List <Double> getBalanceForIBAN(String iban);
	public List <Account> getClientAccounts(String cnp);
}