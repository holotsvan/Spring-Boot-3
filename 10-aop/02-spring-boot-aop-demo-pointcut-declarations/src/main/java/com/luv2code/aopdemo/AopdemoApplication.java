package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

    private AccountDAO accountDAO;

    @Autowired
    public AopdemoApplication(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService) {
        return runner -> {
//			demoTheBeforeAdvice(accountDAO,membershipDAO);
//          demoTheAfterThrowingAdvice(accountDAO);
//            demoTheAfterAdvice(accountDAO);
            demoTheAroudnAdvice(trafficFortuneService);
        };
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        Account account = new Account();
        account.setLevel("3 level");
        account.setName("Ivan");
        accountDAO.addAccount(account, true);
        membershipDAO.addMembership();
        accountDAO.doWork();
        System.out.println(accountDAO.findAccounts());
        membershipDAO.addMembership();
    }

    private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
        try {
            boolean tripWire = true;
            Account account = new Account();
            account.setLevel("3 level");
            account.setName("Ivan");
            accountDAO.addAccount(account, true);
            accountDAO.doWork();
            System.out.println(accountDAO.findAccounts(tripWire));
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    private void demoTheAfterAdvice(AccountDAO accountDAO) {
        Account account = new Account();
        account.setLevel("3 level");
        account.setName("Ivan");
        accountDAO.addAccount(account, true);
        accountDAO.doWork();
        System.out.println(accountDAO.findAccounts());
    }

    private void demoTheAroudnAdvice(TrafficFortuneService trafficFortuneService) {
        System.out.println("\nMain Program : demoTheAroundAdvice");
        System.out.println("Calling getFortune()");
        String data = trafficFortuneService.getFortune();
        System.out.println("Fortune:" + data);
        System.out.println("Finished");
    }
}
