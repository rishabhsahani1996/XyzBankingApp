package com.cap.xyzbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.xyzbank.model.BankAccount;


public interface IBankAccountDao extends JpaRepository<BankAccount, Integer>{

	public BankAccount findByIdAndPassword(Integer id, String password);
	
}
