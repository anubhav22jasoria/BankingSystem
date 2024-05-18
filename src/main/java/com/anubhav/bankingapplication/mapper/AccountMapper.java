package com.anubhav.bankingapplication.mapper;

import com.anubhav.bankingapplication.dto.AccountDto;
import com.anubhav.bankingapplication.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountMapper {
    public static AccountDto accountToAccountDto(Account account){
        return new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getAccountBalance()
        );
    }
    public static Account accountDtoToAccount(AccountDto accountDto){
        return new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getAccountBalance()
        );
    }

    public static List<AccountDto> accountToAccountDto(List<Account> accounts) {
        List<AccountDto> accountDtos = new ArrayList<>();
        for(Account a : accounts){
            accountDtos.add(AccountMapper.accountToAccountDto(a));
        }
        return accountDtos;
    }
}
