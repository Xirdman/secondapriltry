package com.example.restserviceproject.service;

import com.example.restserviceproject.entity.BankAccount;

import java.util.List;
import java.util.Optional;

public class BankAccountServiceImpl implements BankAccountService {
    @Override
    public List<BankAccount> findAll() {
        return null;
    }

    @Override
    public int InsertBankAccount(int ownerId, String accountNumber, double value) {
        return 0;
    }

    @Override
    public boolean updateBankAccount(int ownerId, String accountNumber, double value) {
        return false;
    }

    @Override
    public boolean deleteBankAccount() {
        return false;
    }

    @Override
    public Optional<BankAccount> findById(int id) {
        return Optional.empty();
    }
}
