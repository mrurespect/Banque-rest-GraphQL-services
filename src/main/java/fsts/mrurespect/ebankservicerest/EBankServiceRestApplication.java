package fsts.mrurespect.ebankservicerest;

import fsts.mrurespect.ebankservicerest.entity.Account;
import fsts.mrurespect.ebankservicerest.enums.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import fsts.mrurespect.ebankservicerest.repository.AccountRepository;

@SpringBootApplication
public class EBankServiceRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EBankServiceRestApplication.class, args);
    }
    @Bean
    CommandLineRunner run(@Autowired  AccountRepository accountRepository) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                Account account=Account.builder()
                        .accountType(Math.random()>0.5? AccountType.CURRENT_ACCOUNT: AccountType.SAVINGS_ACCOUNT)
                        .balance(Math.random()*1000+1000)
                        .currency("USD")
                        .id("ACC"+i)
                        .build();
                accountRepository.save(account);
            }
        };
    }

}
