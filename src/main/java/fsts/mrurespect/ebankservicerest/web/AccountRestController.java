package fsts.mrurespect.ebankservicerest.web;

import fsts.mrurespect.ebankservicerest.dto.AccountRequestDto;
import fsts.mrurespect.ebankservicerest.dto.AccountResponseDto;
import fsts.mrurespect.ebankservicerest.entity.Account;
import fsts.mrurespect.ebankservicerest.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private final AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable String id) {
        return accountService.getAccountById(id);
    }
    @PostMapping("/accounts")
    public AccountResponseDto addAccount(@RequestBody AccountRequestDto account) {
        return accountService.addAccount(account);
    }

    @PutMapping("/accounts")
    public Account updateAccount(@RequestBody Account account) {
        return accountService.updateAccount(account);
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
    }
}
