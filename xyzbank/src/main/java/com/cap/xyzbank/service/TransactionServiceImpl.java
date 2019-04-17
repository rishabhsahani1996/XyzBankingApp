package com.cap.xyzbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.xyzbank.dao.ITransactionDao;
import com.cap.xyzbank.model.Transaction;

@Service("transactionService")
public class TransactionServiceImpl implements ITransactionService{
	@Autowired
	private ITransactionDao transactionDao;

	@Override
	public void save(Transaction transaction) {

		transactionDao.save(transaction);
	}

	@Override
	public List<Transaction> findByBankAccountId(Integer id) {
		List<Transaction> list = transactionDao.findByBankAccountId(id);
		return list;
	}

}
