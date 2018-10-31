package com.cg.wallet.dao;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.cg.wallet.bean.CustomerBean;
import com.cg.wallet.bean.DepositBean;
import com.cg.wallet.bean.FundTransferBean;
import com.cg.wallet.bean.WalletTransactions;
import com.cg.wallet.bean.WithdrawBean;
import com.cg.wallet.exception.WalletException;

public interface IWalletDao {

public boolean createAccount(CustomerBean cb);

public boolean deposit(DepositBean db,double amount) throws WalletException;

public boolean withdraw(WithdrawBean wb,double amount) throws WalletException;

public boolean fundTransfer(FundTransferBean fb, double amount);

public ArrayList printTransactions(String phone,LocalDateTime sd,LocalDateTime ed);

}
