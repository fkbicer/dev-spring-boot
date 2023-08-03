package com.example.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.example.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String email;
    private String serviceCode;

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        
        System.out.println(getClass() + " DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " doing my job...");
        return false;
    }

    public String getEmail() {
        System.out.println(getClass() + " ==> getEmail");
        return email;
    }

    public void setEmail(String email) {
        System.out.println(getClass() + " ==> setEmail");
        this.email = email;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " ==> getServiceCode.");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " ==> setServiceCode.");
        this.serviceCode = serviceCode;
    }
    
}
