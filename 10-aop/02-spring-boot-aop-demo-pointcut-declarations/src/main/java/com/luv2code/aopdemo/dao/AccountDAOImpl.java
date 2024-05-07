package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount(Account account, boolean isVip) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public List<Account> findAccounts() {
        return List.of(
                new Account("Jhon", "level 5"),
                new Account("Doe", "level 3"),
                new Account("Tom", "level 2"),
                new Account("Susan", "level 4")
        );
    }

    @Override
    public boolean doWork() {
        return false;
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) throws Exception {

        if(tripWire) throw new Exception("EXCEPTION!!!!!");

        return List.of(
                new Account("Jhon", "level 5"),
                new Account("Doe", "level 3"),
                new Account("Tom", "level 2"),
                new Account("Susan", "level 4")
        );    }
}
