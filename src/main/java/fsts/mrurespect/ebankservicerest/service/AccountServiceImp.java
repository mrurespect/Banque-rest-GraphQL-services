package fsts.mrurespect.ebankservicerest.service;


import fsts.mrurespect.ebankservicerest.dto.AccountMapper;
import fsts.mrurespect.ebankservicerest.dto.AccountRequestDto;
import fsts.mrurespect.ebankservicerest.dto.AccountResponseDto;
import fsts.mrurespect.ebankservicerest.entity.Account;
import fsts.mrurespect.ebankservicerest.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
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
    public AccountResponseDto addAccount(AccountRequestDto accountDto) {
        Account account = AccountMapper.mapToEntity(accountDto);
        Account savedAccount = accountRepository.save(account);
          return AccountMapper.mapToDto(savedAccount);
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
