package com.example.restserviceproject.dao;

import com.example.restserviceproject.entity.BankAccount;
import com.example.restserviceproject.mapper.BankAccountRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;
import java.util.Optional;

public class BankAccountDaoImpl implements BankAccountDao {
    NamedParameterJdbcTemplate template;

    @Override
    public Optional<List<BankAccount>> findAll() {
        List<BankAccount> list = null;
        try {
            list = template.query("SELECT * FROM bankaccounts ",new BankAccountRowMapper());
        }catch (EmptyResultDataAccessException e){

        }
        return Optional.ofNullable(list);
    }

    @Override
    public boolean updateBankAccount(int ownerId, String accountNumber, double value, int id) {
        final String sql = "UPDATE bankaccounts SET ownerid =:ownerId, balance =: money, accountnumber =: accountNumber WHERE id=:id";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("ownerId", ownerId)
                .addValue("money", value)
                .addValue("accountnumber", accountNumber);
        return template.execute(sql, parameterSource, preparedStatement -> preparedStatement.executeUpdate() > 0);
    }

    @Override
    public boolean deleteBankAccount(int id) {
        final String sql = "DELETE FROM bankaccounts WHERE id=:id";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        return template.execute(sql, param, preparedStatement -> preparedStatement.executeUpdate() > 0);
    }

    @Override
    public int insertBankAccount(int ownerId, String accountNumber, double value) {
        final String sql = "INSERT INTO bankaccounts(ownerid,balance,accountnumber) VALUES (:ownerId,:money,:accountNumber)";
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("ownerId", ownerId)
                .addValue("money", value)
                .addValue(":accountNumber", accountNumber);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(sql, parameterSource, keyHolder);
        return (int) keyHolder.getKey();
    }

    @Override
    public Optional<BankAccount> findById(int id) {
        final String sql = "SELECT * FROM bankaccounts WHERE id =:id";
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("id", id);
        BankAccount bankAccount = null;
        try {
            bankAccount = template.queryForObject(sql, parameterSource, new BankAccountRowMapper());
        } catch (EmptyResultDataAccessException e) {
        }
        return Optional.ofNullable(bankAccount);
    }
}
