package com.ripbank.core.DAO;

import com.ripbank.core.DTO.TransactionDTO;

public interface TransactionDAO {
	public boolean makeTransaction(TransactionDTO transaction);
}
