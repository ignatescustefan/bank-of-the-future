package com.ripbank.core;

import java.util.List;

public interface ContDAO {
	public List<Double> getBalanceForIBAN(String iban);
}