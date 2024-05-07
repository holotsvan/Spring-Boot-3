package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount(Account account, boolean isVip);

    List<Account> findAccounts();

    boolean doWork();

    List<Account> findAccounts(boolean tripWire) throws Exception;
}
