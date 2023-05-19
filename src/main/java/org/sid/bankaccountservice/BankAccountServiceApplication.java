package org.sid.bankaccountservice;

import org.sid.bankaccountservice.entities.BanckAccount;
import org.sid.bankaccountservice.enums.AccountType;
import org.sid.bankaccountservice.repositories.BankAccountRepositoty;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;


@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(BankAccountRepositoty bankAccountRepositoty) {
		return args -> {
           for (int i=0; i< 10; i++) {
			   BanckAccount banckAccount = BanckAccount.builder()
					   .id(UUID.randomUUID().toString())
					   .type(Math.random()>0.5 ? AccountType.CURRENT_TYPE : AccountType.SAVING_ACCOUNT)
					   .balance(10000 + Math.random() * 90000)
					   .currency("MAD")
					   .build();
			   bankAccountRepositoty.save(banckAccount);
		   }
		};
	}

}
