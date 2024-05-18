package com.anubhav.bankingapplication.repository;

import com.anubhav.bankingapplication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
