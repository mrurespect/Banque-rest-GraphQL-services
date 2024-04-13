package fsts.mrurespect.ebankservicerest.service;

import fsts.mrurespect.ebankservicerest.dto.AccountRequestDto;
import fsts.mrurespect.ebankservicerest.dto.AccountResponseDto;
import fsts.mrurespect.ebankservicerest.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    Account getAccountById(String id);
    AccountResponseDto addAccount(AccountRequestDto account);
    Account updateAccount(Account account);
    void deleteAccount(String id);
}
