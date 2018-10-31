package com.cg.wallet.service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.cg.wallet.bean.BalanceBean;
import com.cg.wallet.bean.CustomerBean;
import com.cg.wallet.bean.DepositBean;
import com.cg.wallet.bean.FundTransferBean;
import com.cg.wallet.bean.WalletTransactions;
import com.cg.wallet.bean.WithdrawBean;
import com.cg.wallet.dao.IWalletDao;
import com.cg.wallet.dao.WalletDaoImp;
import com.cg.wallet.exception.WalletException;

public class WalletServiceImp implements IWalletService {
	
	IWalletDao dao = new WalletDaoImp();
	CustomerBean cb =  new CustomerBean();
	BalanceBean bb = new BalanceBean();
	DepositBean db = new DepositBean();
	FundTransferBean fb = new FundTransferBean();
	WithdrawBean wb =new WithdrawBean();
	@Override
	public boolean createAccount(CustomerBean cb) throws WalletException {
		// TODO Auto-generated method stub
		boolean isValid = false;
		if(validate(cb)) {
			isValid  = dao.createAccount(cb);
			
		}
		return isValid;
	}

	@Override
	public boolean deposit(DepositBean db,double amount) throws WalletException {
		// TODO Auto-generated method stub
		boolean isValid = false;
		if(validate(db)) {
			isValid = dao.deposit(db,amount);
			
		}
		return isValid;
	}

	@Override
	public boolean withdraw(WithdrawBean wb,double amount) throws WalletException {
		// TODO Auto-generated method stub
		boolean isValid = false;
		if(validate(wb)) {
			isValid = dao.withdraw(wb,amount);
			
		}
		return isValid;
	}

	@Override
	public boolean fundTransfer(FundTransferBean fb, double amount) throws WalletException {
		// TODO Auto-generated method stub
		boolean isValid = false;
		if(validate(fb)) {
			isValid = dao.fundTransfer(fb,amount);
			
		}
		return isValid;
		
	}
	@Override
	public ArrayList printTransactions(String phone,LocalDateTime sd,LocalDateTime ed) {
		// TODO Auto-generated method stub
		return dao.printTransactions(phone,sd,ed);
	}

	@Override
	public boolean validate(CustomerBean cb) throws WalletException {
		// TODO Auto-generated method stub
		boolean isValid = true;
		if(!(cb.getFirstName()!=null && cb.getFirstName().matches("[A-Za-z]{2,}"))) {
			throw new WalletException();
		}
		if(!(cb.getLastName()!=null && cb.getLastName().matches("[A-Za-z]{2,}"))) {
			throw new WalletException();
		}
		if(!(cb.getPhoneNum()!=null && cb.getPhoneNum().matches("^[6-9][0-9]{9}"))) {
			throw new WalletException();
		}
		if(!(cb.getEmailId()!=null && cb.getEmailId().matches("[a-z_A-Z0-9]+@+[a-z]+\\.com"))) {
			throw new WalletException();
		}
		return isValid;
	}
	public boolean validate(BalanceBean bb) throws WalletException {
		boolean isValid = true;
		if(!(bb.getPhoneNum()!=null && bb.getPhoneNum().matches("^[6-9][0-9]{9}"))) {
			throw new WalletException();
		}
		if(!(bb.getBalance()>=0)){
			throw new WalletException();
		}
		return isValid;
	}
	public boolean validate(DepositBean db) throws WalletException {
		boolean isValid = true;
		if(!(db.getPhoneNum()!=null && db.getPhoneNum().matches("^[6-9][0-9]{9}"))) {
			throw new WalletException();
		}
		if(!(db.getBalance()>=0)){
			throw new WalletException();
		}
		if(!(db.getAmount()>0)){
			throw new WalletException();
		}
		
		return isValid;
	}
	public boolean validate(WithdrawBean wb) throws WalletException {
		boolean isValid = true;
		if(!(wb.getPhoneNum()!=null && wb.getPhoneNum().matches("^[6-9][0-9]{9}"))) {
			throw new WalletException();
		}
		if(!(wb.getBalance()>=0)){
			throw new WalletException();
		}
		if(!(wb.getAmount()>0)){
			throw new WalletException();
		}
		
		return isValid;
	}
	public boolean validate(FundTransferBean fb) throws WalletException {
		boolean isValid = true;
		if(!(fb.getSourcePhoneNum()!=null && fb.getSourcePhoneNum().matches("^[6-9][0-9]{9}"))) {
			throw new WalletException();
		}
		if(!(fb.getDesPhoneNum()!=null && fb.getDesPhoneNum().matches("^[6-9][0-9]{9}"))) {
			throw new WalletException();
		}
		if(!(fb.getBalance()>=0)){
			throw new WalletException();
		}
		if(!(fb.getAmount()>0)){
			throw new WalletException();
		}
		
		return isValid;
	}

	
}
