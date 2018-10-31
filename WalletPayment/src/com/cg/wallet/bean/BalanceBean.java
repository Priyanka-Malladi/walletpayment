package com.cg.wallet.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class BalanceBean implements Serializable {
	private LocalDate date;
	private LocalTime time;
	private double balance;
	private String phoneNum;


	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	
}
