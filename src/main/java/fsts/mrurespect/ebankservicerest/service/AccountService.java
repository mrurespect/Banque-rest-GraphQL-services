package fsts.mrurespect.ebankservicerest.service;

import fsts.mrurespect.ebankservicerest.dto.AccountRequestDto;
import fsts.mrurespect.ebankservicerest.dto.AccountResponseDto;
import fsts.mrurespect.ebankservicerest.entity.Account;
import fsts.mrurespect.ebankservicerest.exception.account.AccountNotFoundException;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    Account getAccountById(String id) throws AccountNotFoundException;
    AccountResponseDto addAccount(AccountRequestDto account);
    Account updateAccount(Account account) throws AccountNotFoundException;
    boolean deleteAccount(String id) throws AccountNotFoundException;
}
