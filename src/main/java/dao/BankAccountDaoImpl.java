package dao;

import entity.BankAccount;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class BankAccountDaoImpl implements BankAccountDao{
    NamedParameterJdbcTemplate template;
    @Override
    public List<BankAccount> findAll() {
        return null;
    }

    @Override
    public void updateBankAccount(BankAccount bankAcc) {

    }

    @Override
    public void deleteBankAccount(BankAccount bankAcc) {

    }

    @Override
    public void insertBankAccount(BankAccount bankAcc) {

    }

    @Override
    public void executeUpdateBankAccount(BankAccount bankAcc) {

    }
}
