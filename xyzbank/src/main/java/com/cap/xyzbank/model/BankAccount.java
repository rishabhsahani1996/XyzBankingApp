package com.cap.xyzbank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "Bank_Accounts")
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", sequenceName = "seq_banks_id", allocationSize = 1)
	private Integer id;
	private String password;
	private String fullName;
	private Integer balance;
//	@OneToMany(mappedBy="bank",cascade=CascadeType.ALL)
//	private Set<Transaction> transaction = new HashSet<>();
//	
//	public Set<Transaction> getTransaction() {
//		return transaction;
//	}
//	public void setTransaction(Set<Transaction> transaction) {
//		this.transaction = transaction;
//	}
	
	public BankAccount() {

	}
	
	public BankAccount(Integer id, String password, String fullName, Integer balance) {
		this.id = id;
		this.password = password;
		this.fullName = fullName;
		this.balance = balance;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Bank_Account [id=" + id + ", fullName=" + fullName + ", balance=" + balance + "]";
	}
//	public void addTransaction(Transaction transaction) {
//		transaction.setBankAccount(this);			//this will avoid nested cascade
//		this.getTransaction().add(transaction);
//	}
	


	
}
