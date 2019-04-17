package com.cap.xyzbank.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cap.xyzbank.model.BankAccount;
import com.cap.xyzbank.model.Transaction;
import com.cap.xyzbank.service.IBankAccountService;
import com.cap.xyzbank.service.ITransactionService;

@RestController
@RequestMapping("/accounts")
public class MainController {
	@Autowired
	private IBankAccountService bankService;
	
	@Autowired
	private ITransactionService transactionService;
	
	int temp;
	

	@PostMapping("/checkuser")
	public ModelAndView requestLogin(@RequestParam Integer id, @RequestParam String password) {
		ModelAndView modelAndView;
		
		BankAccount bank= bankService.findByIdPassword(id, password);
		temp=id;
		if (bank==null) {
			modelAndView = new ModelAndView("loginfailed");
		} else {
			modelAndView = new ModelAndView("options");
		}
		return modelAndView;
	}
	
	@PostMapping("/checkmanager")
	public ModelAndView requestmanagerLogin(@RequestParam String user, @RequestParam String password) {
		ModelAndView modelAndView;
		String a=user;
		String p=password;
		if (a.equals("rishabh") && p.equals("sahani")) {
			modelAndView = new ModelAndView("register");
			return modelAndView;
		} else {
			modelAndView = new ModelAndView("loginfailed");
		}
		return modelAndView;
	}
	
	@PostMapping("/save")
	public ModelAndView save(@RequestParam String fullName, @RequestParam String password, @RequestParam Integer balance) {
		
		BankAccount bankAccount = new BankAccount();
		
		bankAccount.setFullName(fullName);
		bankAccount.setPassword(password);
		bankAccount.setBalance(balance);
		bankService.save(bankAccount);
		
		List<BankAccount> banksList = bankService.findAll();
		ModelAndView modelAndView = new ModelAndView("registereduser");
		modelAndView.addObject("REGISTER",banksList);
		return modelAndView;
	}
	@GetMapping("/show")
	public ModelAndView getbalancefromid() {
		
		BankAccount bank= bankService.findById(temp);
		double balance = bank.getBalance();
		ModelAndView modelAndView = new ModelAndView("balance");
		
		modelAndView.addObject("BALANCE",balance);
		return modelAndView;
	}
	
	@PostMapping("/add")
	public ModelAndView addbalance(@RequestParam Integer money) {
		ModelAndView modelAndView;
		if(money<=0) {
			modelAndView= new ModelAndView("improper");
			return modelAndView;
				
			}else {
		BankAccount bank= bankService.findById(temp);
		Integer currentBalance= bank.getBalance();
		currentBalance += money;
		
		bank.setBalance(currentBalance);
		bankService.save(bank);
		
		Transaction transaction=new Transaction();
		transaction.setType("deposit");
		transaction.setAmount(money);
		transaction.setBankAccount(bank);
		
		transactionService.save(transaction);
		
		modelAndView = new ModelAndView("deposited");
		
		modelAndView.addObject("DEPOSIT",bank);//bank ki jagah current balance likhna agr naa ho to
		return modelAndView;
	}
	}
	
	@PostMapping("/subtract")
	public ModelAndView subbalance(@RequestParam Integer withdraw) {
		if(withdraw<=0) {
			ModelAndView modelAndView= new ModelAndView("improper");
			return modelAndView;
				
			}else {
		BankAccount bank= bankService.findById(temp);
		Integer currentBalance= bank.getBalance();
		
		if(currentBalance < withdraw) {
			ModelAndView modelAndView= new ModelAndView("insufficient");
			return modelAndView;
		}else {
			currentBalance -= withdraw;
			bank.setBalance(currentBalance);
			bankService.save(bank);
			
			Transaction transaction=new Transaction();
			transaction.setType("withdraw");
			transaction.setAmount(withdraw);
			transaction.setBankAccount(bank);
			
			transactionService.save(transaction);
			
			ModelAndView modelAndView= new ModelAndView("withdrawal");
			
			modelAndView.addObject("WITHDRAW", bank);
			return modelAndView;
		}}
	}
	
	@PostMapping("/fundtransfer")
	public ModelAndView transferbalance(@RequestParam Integer id, @RequestParam Integer transfer) {
		if(transfer<=0) {
		ModelAndView modelAndView= new ModelAndView("improper");
		return modelAndView;
			
		}else {
		BankAccount sender= bankService.findById(temp);
		BankAccount receiver= bankService.findById(id);
		
		int senderBalance= sender.getBalance();
		
		if(senderBalance < transfer) {
			ModelAndView modelAndView= new ModelAndView("insufficient");
			return modelAndView;
		}else {
			
			senderBalance= sender.getBalance() - transfer;
			int receiverBalance= receiver.getBalance() + transfer;
			
			sender.setBalance(senderBalance);
			receiver.setBalance(receiverBalance);
			
			bankService.save(sender);
			bankService.save(receiver);
		
		Transaction senderTransaction=new Transaction();
		senderTransaction.setType("DEBITED");
		senderTransaction.setAmount(transfer);
		senderTransaction.setBankAccount(sender);
		transactionService.save(senderTransaction);
		
		Transaction receiverTransaction = new Transaction();
		receiverTransaction.setType("CREDITED");
		receiverTransaction.setAmount(transfer);
		receiverTransaction.setBankAccount(receiver);
		transactionService.save(receiverTransaction);
		
		ModelAndView modelAndView= new ModelAndView("fundtransfered");
		modelAndView.addObject("FROMACCOUNTNO", sender.getId());
		modelAndView.addObject("TOACCOUNTNO", receiver.getId());
		modelAndView.addObject("AMOUNTTRANSFERRED", transfer);
		modelAndView.addObject("SENDERBALANCE", senderBalance);
		return modelAndView;
		}}
	}
	@GetMapping("/transaction")
	public ModelAndView transaction() {
		List<Transaction> list= transactionService.findByBankAccountId(temp);
		ModelAndView modelAndView = new ModelAndView("receipt");
	modelAndView.addObject("PRINT",list);
		return modelAndView;
		
	}
	
	
}
