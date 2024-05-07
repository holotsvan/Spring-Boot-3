package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addMembership() {
        System.out.println(getClass()+": DOING MY DB WORK: ADDING A MEMBERSHIP");
    }

    @Override
    public boolean goToSleep(){
        return true;
    }
}
