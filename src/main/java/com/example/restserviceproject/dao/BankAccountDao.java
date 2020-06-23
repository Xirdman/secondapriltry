package com.example.restserviceproject.dao;

import com.example.restserviceproject.entity.BankAccount;

import java.util.List;
import java.util.Optional;

public interface BankAccountDao {
    Optional<List<BankAccount>> findAll();

    boolean updateBankAccount(BankAccount bankAcc);

    boolean deleteBankAccount(BankAccount bankAcc);

    int insertBankAccount(BankAccount bankAcc);

    Optional<BankAccount> findById(int id);

}
