package com.example.restserviceproject.mapper;

import com.example.restserviceproject.entity.BankAccount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccountRowMapper implements RowMapper<BankAccount> {
    @Override
    public BankAccount mapRow(ResultSet resultSet, int i) throws SQLException {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(resultSet.getInt("id"));
        bankAccount.setOwnerId(resultSet.getInt("ownerid"));
        bankAccount.setAccountNumber(resultSet.getString("accountnumber"));
        bankAccount.setBalance(resultSet.getDouble("balance"));
        return bankAccount;
    }
}
