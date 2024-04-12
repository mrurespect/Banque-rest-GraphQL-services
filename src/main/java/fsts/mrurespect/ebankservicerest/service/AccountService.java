package fsts.mrurespect.ebankservicerest.service;

import fsts.mrurespect.ebankservicerest.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    Account getAccountById(String id);
    Account addAccount(Account account);
    Account updateAccount(Account account);
    void deleteAccount(String id);
}
