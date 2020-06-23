package com.example.restserviceproject.dao;

import com.example.restserviceproject.entity.BankAccount;

import java.util.List;
import java.util.Optional;

public interface BankAccountDao {
    Optional<List<BankAccount>> findAll();

    boolean updateBankAccount(int ownerId, String accountNumber, double value,int id);

    boolean deleteBankAccount(int id);

    int insertBankAccount(int ownerId, String accountNumber, double value);

    Optional<BankAccount> findById(int id);

}
