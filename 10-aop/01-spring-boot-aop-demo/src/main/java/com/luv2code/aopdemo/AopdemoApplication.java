package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	private AccountDAO accountDAO;

	@Autowired
	public AopdemoApplication(AccountDAO accountDAO){
		this.accountDAO=accountDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner->{
			demoTheBeforeAdvice(accountDAO,membershipDAO);

		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO,MembershipDAO membershipDAO){
		Account account = new Account();
		accountDAO.addAccount(account,true);
		membershipDAO.addMembership();
		accountDAO.doWork();
		membershipDAO.addMembership();
	}
}
