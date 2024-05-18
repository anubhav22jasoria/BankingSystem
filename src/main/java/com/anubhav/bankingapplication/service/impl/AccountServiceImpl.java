package com.anubhav.bankingapplication.service.impl;


import com.anubhav.bankingapplication.dto.AccountDto;
import com.anubhav.bankingapplication.entity.Account;
import com.anubhav.bankingapplication.exception.ResourceNotFoundException;
import com.anubhav.bankingapplication.mapper.AccountMapper;
import com.anubhav.bankingapplication.repository.AccountRepository;
import com.anubhav.bankingapplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public AccountDto addAccount(AccountDto accountDto){
        Account account = AccountMapper.accountDtoToAccount(accountDto);
        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.accountToAccountDto(account);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account with the id: "+ id + " does not exist"));
        return AccountMapper.accountToAccountDto(account);
    }

    @Override
    public AccountDto depositAmount(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account with the id: "+ id + " does not exist"));
        double x = account.getAccountBalance();
        x += amount;
        account.setAccountBalance(x);
        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.accountToAccountDto(account);
    }

    @Override
    public AccountDto withdrawAmount(Long id, Double amount) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account with the id: "+ id + " does not exist"));
        double x = account.getAccountBalance();
        x -= amount;
        if(x < 0)
            throw new RuntimeException("Insufficient balance");
        account.setAccountBalance(x);
        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.accountToAccountDto(account);

    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return AccountMapper.accountToAccountDto(accounts);
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account with the id: "+ id + " does not exist"));
        accountRepository.delete(account);
    }
}
