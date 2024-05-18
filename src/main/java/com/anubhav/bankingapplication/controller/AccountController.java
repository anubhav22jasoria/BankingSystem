package com.anubhav.bankingapplication.controller;

import com.anubhav.bankingapplication.dto.AccountDto;
import com.anubhav.bankingapplication.entity.Account;
import com.anubhav.bankingapplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accountDtos = accountService.getAllAccounts();
        return new ResponseEntity<>(accountDtos,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        AccountDto addedAccount = accountService.addAccount(accountDto);
        return new ResponseEntity<>(addedAccount, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable(name = "id") Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return new ResponseEntity<>(accountDto,HttpStatus.OK);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositAmount(@PathVariable(name = "id") Long id,@RequestBody Map<String,Double> amt){
        AccountDto accountDto = accountService.depositAmount(id,amt.get("amount"));
        return new ResponseEntity<>(accountDto,HttpStatus.OK);
    }


    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdrawAmount(@PathVariable(name = "id") Long id,@RequestBody Map<String,Double> amt){
        AccountDto accountDto = accountService.withdrawAmount(id,amt.get("amount"));
        return new ResponseEntity<>(accountDto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable(name = "id") Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>("Account with the id : "+id +" has been deleted",HttpStatus.OK);
    }
}
