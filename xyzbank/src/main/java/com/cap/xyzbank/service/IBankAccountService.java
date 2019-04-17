package com.cap.xyzbank.service;

import java.util.List;

import com.cap.xyzbank.model.BankAccount;
import com.cap.xyzbank.model.Transaction;


public interface IBankAccountService {

	public BankAccount findById(Integer bankAccountId);
	
	public BankAccount findByIdPassword(Integer bankAccountId, String password);
	
	public void save(BankAccount bankAccount);
	
	public List<BankAccount> findAll();
	
}
