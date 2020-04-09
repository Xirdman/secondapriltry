package com.example.restserviceproject.dao;

import com.example.restserviceproject.entity.BankAccount;

import java.util.List;

public interface BankAccountDao {
    List<BankAccount> findAll();

    void updateBankAccount(BankAccount bankAcc);

    void deleteBankAccount(BankAccount bankAcc);

    void insertBankAccount(BankAccount bankAcc);

    void executeUpdateBankAccount(BankAccount bankAcc);
}
