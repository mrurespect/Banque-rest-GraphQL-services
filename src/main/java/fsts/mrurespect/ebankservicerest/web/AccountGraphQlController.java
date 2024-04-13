package fsts.mrurespect.ebankservicerest.web;

import fsts.mrurespect.ebankservicerest.entity.Account;
import fsts.mrurespect.ebankservicerest.service.AccountService;
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
}
