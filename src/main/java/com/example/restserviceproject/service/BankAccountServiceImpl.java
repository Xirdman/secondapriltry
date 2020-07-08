package com.example.restserviceproject.service;

import com.example.restserviceproject.dao.BankAccountDao;
import com.example.restserviceproject.entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BankAccountServiceImpl implements BankAccountService {
    private BankAccountDao bankAccountDao;
    public BankAccountServiceImpl(@Autowired BankAccountDao bankAccountDao){
        this.bankAccountDao = bankAccountDao;
    }
    @Override
    public Optional<List<BankAccount>> findAll() {
        return bankAccountDao.findAll();
    }

    @Override
    public int insertBankAccount(int ownerId, String accountNumber, double value) {
        return bankAccountDao.insertBankAccount(ownerId,accountNumber,value);
    }

    @Override
    public boolean updateBankAccount(int ownerId, String accountNumber, double value, int id) {
        return bankAccountDao.updateBankAccount(ownerId,accountNumber,value,id);
    }

    @Override
    public boolean deleteBankAccount(int id) {
        return bankAccountDao.deleteBankAccount(id);
    }

    @Override
    public Optional<BankAccount> findById(int id) {
        return bankAccountDao.findById(id);
    }
}
