package com.example.restserviceproject.service;

import com.example.restserviceproject.entity.BankAccount;

import java.util.List;
import java.util.Optional;

public interface BankAccountService {
    List<BankAccount> findAll();

    int InsertBankAccount(int ownerId, String accountNumber, double value);

    boolean updateBankAccount(int ownerId, String accountNumber, double value);

    boolean deleteBankAccount();

    Optional<BankAccount> findById(int id);
}
