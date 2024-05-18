package com.anubhav.bankingapplication.service;

import com.anubhav.bankingapplication.dto.AccountDto;
import com.anubhav.bankingapplication.entity.Account;
import com.anubhav.bankingapplication.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface AccountService {
    public AccountDto addAccount(AccountDto accountDto);
    public AccountDto getAccountById(Long id);
    public AccountDto depositAmount(Long id, double amount);

    public AccountDto withdrawAmount(Long id, Double amount);

    public List<AccountDto> getAllAccounts();

    public void deleteAccount(Long id);
}
