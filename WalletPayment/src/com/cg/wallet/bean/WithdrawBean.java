package com.cg.wallet.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class WithdrawBean implements Serializable {
	
	private String phoneNum;
	
	private double balance;
	
	private double amount;
	
	private LocalDateTime date;
	
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	

}
