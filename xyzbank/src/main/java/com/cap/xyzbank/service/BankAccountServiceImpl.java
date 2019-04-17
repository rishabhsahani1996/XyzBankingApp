package com.cap.xyzbank.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.xyzbank.dao.IBankAccountDao;
import com.cap.xyzbank.model.BankAccount;
import com.cap.xyzbank.model.Transaction;

@Service("bankService")
public class BankAccountServiceImpl implements IBankAccountService{

	@Autowired
	IBankAccountDao dao;

	@Override
	public BankAccount findById(Integer bankAccountId) {
		BankAccount bank= dao.findById(bankAccountId).get();
		return bank;
	}

	@Override
	public BankAccount findByIdPassword(Integer bankAccountId, String password) {
		BankAccount bankAccount = null;
		try {
			bankAccount = dao.findByIdAndPassword(bankAccountId , password);
		} catch (Exception e) {
			bankAccount = null;
		}
		return bankAccount;
	}

	@Override
	public void save(BankAccount bankAccount) {
		dao.save(bankAccount);
		
	}

	@Override
	public List<BankAccount> findAll() {
		List<BankAccount> banklist = dao.findAll();
		return banklist;
	}
	
	
}
