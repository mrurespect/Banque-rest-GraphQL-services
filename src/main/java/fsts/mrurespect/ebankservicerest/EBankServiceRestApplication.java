package fsts.mrurespect.ebankservicerest;

import fsts.mrurespect.ebankservicerest.entity.Account;
import fsts.mrurespect.ebankservicerest.entity.Customer;
import fsts.mrurespect.ebankservicerest.enums.AccountType;
import fsts.mrurespect.ebankservicerest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import fsts.mrurespect.ebankservicerest.repository.AccountRepository;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EBankServiceRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EBankServiceRestApplication.class, args);
    }
    @Bean
    CommandLineRunner run(@Autowired  AccountRepository accountRepository, @Autowired CustomerRepository customerRepository) {
        return args -> {
            Stream.of("CL1", "CL2", "CL3", "CL4", "CL5", "CL6", "CL7", "CL8", "CL9", "CL10")
                    .forEach(cn -> {
                        Customer customer = Customer.builder()
                                .name(cn)
                                .build();
                        customerRepository.save(customer);
                    });

            customerRepository.findAll().forEach(customer -> {

                for (int i = 0; i < 10; i++) {
                    Account account=Account.builder()
                            .accountType(Math.random()>0.5? AccountType.CURRENT_ACCOUNT: AccountType.SAVINGS_ACCOUNT)
                            .balance(Math.random()*1000+1000)
                            .currency("USD")
                            .id(UUID.randomUUID().toString())
                            .createDate(new java.util.Date())
                            .customer(customer)
                            .build();
                    accountRepository.save(account);
                }
                System.out.println(customer.getName());
            });

        };
    }

}
