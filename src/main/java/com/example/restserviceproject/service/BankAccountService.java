package com.example.restserviceproject.service;

import com.example.restserviceproject.entity.BankAccount;

import java.util.List;
import java.util.Optional;

public interface BankAccountService {
    Optional<List<BankAccount>> findAll();

    int insertBankAccount(int ownerId, String accountNumber, double value);

    boolean updateBankAccount(int ownerId, String accountNumber, double value,int id);

    boolean deleteBankAccount(int id);

    Optional<BankAccount> findById(int id);
}
