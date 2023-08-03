package com.example.aopdemo.dao;

import java.util.List;

import com.example.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

    String getEmail();

    void setEmail(String email);

    String getServiceCode();

    void setServiceCode(String serviceCode);

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);
    
}
