package com.ripbank.core.DAO;

import java.util.List;

import com.ripbank.core.Account;
import com.ripbank.core.TipCont;

public interface AccountDAO {
	public List<Double> getBalanceForIBAN(String iban);

	public List<Account> getClientAccounts(String cnp);

	public String generateIBAN(String cnp);

	public boolean createAccount(String cnp, String iban, TipCont tipCont, Double amount);
	
	public String getPINForDefaultAccount(String cnp);
}