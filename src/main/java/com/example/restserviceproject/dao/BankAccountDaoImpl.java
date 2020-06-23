package com.example.restserviceproject.dao;

import com.example.restserviceproject.entity.BankAccount;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class BankAccountDaoImpl implements BankAccountDao {
    NamedParameterJdbcTemplate template;

    @Override
    public Optional<List<BankAccount>> findAll() {
        List<BankAccount> list = new LinkedList<>();
        return Optional.ofNullable(list);
    }

    @Override
    public boolean updateBankAccount(BankAccount bankAcc) {
        return false;
    }

    @Override
    public boolean deleteBankAccount(BankAccount bankAcc) {
        return false;
    }

    @Override
    public int insertBankAccount(BankAccount bankAcc) {
        return 0;
    }

    @Override
    public Optional<BankAccount> findById(int id) {

    }
}
