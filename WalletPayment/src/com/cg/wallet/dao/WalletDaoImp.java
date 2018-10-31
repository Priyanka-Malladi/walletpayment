package com.cg.wallet.dao;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cg.wallet.bean.CustomerBean;
import com.cg.wallet.bean.DepositBean;
import com.cg.wallet.bean.FundTransferBean;
import com.cg.wallet.bean.WalletTransactions;
import com.cg.wallet.bean.WithdrawBean;
import com.cg.wallet.exception.WalletException;

public class WalletDaoImp implements IWalletDao {
	
	List<CustomerBean> customerList = new ArrayList<CustomerBean>();
	
	List<WalletTransactions> transacList = new ArrayList<WalletTransactions>();
	
	
	@Override
	public boolean createAccount(CustomerBean cb) {
		// TODO Auto-generated method stub
	
		return customerList.add(cb);
	}

	@Override
	public boolean deposit(DepositBean db, double amount) throws WalletException {
		// TODO Auto-generated method stub
		boolean isValid = true;
		for (CustomerBean cb : customerList) {
			if(cb.getPhoneNum()==db.getPhoneNum()) {
				db.setBalance(db.getBalance()+amount);
				db.setDate(LocalDateTime.now());
				isValid = true;
				WalletTransactions transac = new WalletTransactions();
				transac.setAmount(amount);
				transac.setBalance(db.getBalance());
				transac.setDate(db.getDate());
				transac.setPhoneNum(db.getPhoneNum());
				transac.setType("deposit");
				transacList.add(transac);
			}
			else {
				throw new WalletException();
			}
			
		}
		return isValid;
	}

	@Override
	public boolean withdraw(WithdrawBean wb, double amount) throws WalletException {
		// TODO Auto-generated method stub
		boolean isValid = true;
		for (CustomerBean cb : customerList) {
			if(cb.getPhoneNum()==wb.getPhoneNum()) {
				if(wb.getBalance()>amount) {
				wb.setBalance(wb.getBalance()-amount);
				wb.setDate(LocalDateTime.now());
				isValid = true;
				WalletTransactions transac = new WalletTransactions();
				transac.setAmount(amount);
				transac.setBalance(wb.getBalance());
				transac.setDate(wb.getDate());
				transac.setPhoneNum(wb.getPhoneNum());
				transac.setType("withdraw");
				transacList.add(transac);
			}
			}
			else {
				throw new WalletException();
			}
			
		}
		return isValid;
	}

	@Override
	public boolean fundTransfer(FundTransferBean fb, double amount) {
		// TODO Auto-generated method stub
		boolean isValid = true;
		for (CustomerBean cb1 : customerList) {
			if(cb1.getPhoneNum()== fb.getSourcePhoneNum()) {
				for (CustomerBean cb2 : customerList) {
					if(cb2.getPhoneNum()==fb.getDesPhoneNum()) {
						withdraw(cb1,amount);
						deposit(cb2,amount);
					}
					
				}
		}
			else {
				throw new WalletException();
			}
			
		}
		return isValid;
	}

	@Override
	public ArrayList printTransactions(String phone,LocalDateTime sd, LocalDateTime ed) {
		// TODO Auto-generated method stub
		ArrayList li = new ArrayList<>();
		for (WalletTransactions walletTransac: transacList){
			if(walletTransac.getPhoneNum()==phone) {
			
			if(walletTransac.getDate().isAfter(sd) && walletTransac.getDate().isBefore(ed))
			{
				li.add(walletTransac);
				
		}
			
		}
			
	}
		return li;

	

}
}