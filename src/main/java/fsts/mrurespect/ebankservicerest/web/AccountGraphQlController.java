package fsts.mrurespect.ebankservicerest.web;

import fsts.mrurespect.ebankservicerest.dto.AccountRequestDto;
import fsts.mrurespect.ebankservicerest.dto.AccountResponseDto;
import fsts.mrurespect.ebankservicerest.entity.Account;
import fsts.mrurespect.ebankservicerest.entity.Customer;
import fsts.mrurespect.ebankservicerest.service.AccountService;
import fsts.mrurespect.ebankservicerest.service.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountGraphQlController {
    private final AccountService accountService;
    private final CustomerService customerService;

    public AccountGraphQlController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @QueryMapping
    public List<Account> accountList() {
        return accountService.getAllAccounts();
    }
    @QueryMapping
    public Account account(@Argument  String  id){
        return accountService.getAccountById(id);
    }

    @MutationMapping
    public AccountResponseDto addAccount(@Argument AccountRequestDto account){
        return accountService.addAccount(account);
    }
    @MutationMapping
    public Account updateAccount(@Argument Account account){
        return accountService.updateAccount(account);
    }
    @MutationMapping
    public boolean deleteAccount(@Argument String id){
        return accountService.deleteAccount(id);
    }

    @QueryMapping
    public List<Customer> customerList() {
        return customerService.getAllCustomers();
    }
}
