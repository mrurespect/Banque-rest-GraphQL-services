package fsts.mrurespect.ebankservicerest.service;

import fsts.mrurespect.ebankservicerest.entity.Account;
import fsts.mrurespect.ebankservicerest.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class AccountServiceImp implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    public Account getAccountById(String id){
        return accountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }

    @Override
    public Account addAccount(Account account) {
        if (accountRepository.findById(account.getId()).isPresent())
            throw new RuntimeException(String.format("Account %s already exists",account.getId()));

        if (account.getId()==null || account.getId().isEmpty())account.setId(UUID.randomUUID().toString());
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
        if (accountRepository.findById(account.getId()).isEmpty())
            throw new RuntimeException(String.format("Account %s not found",account.getId()));
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }
}
