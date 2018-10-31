package com.cg.wallet.bean;

import java.time.LocalDateTime;

public class FundTransferBean {
	
	private String sourcePhoneNum;
	
	private String desPhoneNum;
	
	private double balance;
	
	private double amount;

	private LocalDateTime date;
	
	public String getSourcePhoneNum() {
		return sourcePhoneNum;
	}

	public void setSourcePhoneNum(String sourcePhoneNum) {
		this.sourcePhoneNum = sourcePhoneNum;
	}

	public String getDesPhoneNum() {
		return desPhoneNum;
	}

	public void setDesPhoneNum(String desPhoneNum) {
		this.desPhoneNum = desPhoneNum;
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
