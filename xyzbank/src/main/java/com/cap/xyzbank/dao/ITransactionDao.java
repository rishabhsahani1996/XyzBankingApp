package com.cap.xyzbank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.xyzbank.model.BankAccount;
import com.cap.xyzbank.model.Transaction;

public interface ITransactionDao extends JpaRepository<Transaction, Integer> {

	public List<Transaction> findByBankAccountId(Integer id);

	
}
