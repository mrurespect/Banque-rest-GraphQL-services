package fsts.mrurespect.ebankservicerest.web;

import fsts.mrurespect.ebankservicerest.dto.AccountRequestDto;
import fsts.mrurespect.ebankservicerest.dto.AccountResponseDto;
import fsts.mrurespect.ebankservicerest.entity.Account;
import fsts.mrurespect.ebankservicerest.service.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountGraphQlController {
    private final AccountService accountService;

    public AccountGraphQlController(AccountService accountService) {
        this.accountService = accountService;
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
}
