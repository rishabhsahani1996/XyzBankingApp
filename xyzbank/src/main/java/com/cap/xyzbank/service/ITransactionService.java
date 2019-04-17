package com.cap.xyzbank.service;
import java.util.List;

import com.cap.xyzbank.model.Transaction;

public interface ITransactionService {
	public void save(Transaction transaction);

	public List<Transaction> findByBankAccountId(Integer id);
}
