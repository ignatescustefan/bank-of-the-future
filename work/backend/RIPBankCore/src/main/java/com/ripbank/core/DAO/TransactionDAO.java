package com.ripbank.core.DAO;

import java.util.List;

import com.ripbank.core.DTO.CompleteTransactionDetailsDTO;
import com.ripbank.core.DTO.TransactionDTO;
import com.ripbank.core.DTO.TransactionReportInformationDTO;

public interface TransactionDAO {
	public boolean makeTransaction(TransactionDTO transaction);

	public List<CompleteTransactionDetailsDTO> getTransactions(
			TransactionReportInformationDTO transactionReportInformationDTO);
}
