package mapper;

import entity.BankAccount;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccountRowMapper implements RowMapper<BankAccount> {
    @Override
    public BankAccount mapRow(ResultSet resultSet, int i) throws SQLException {
        BankAccount bankAccount=new BankAccount();
        bankAccount.setId(resultSet.getInt("id"));
        bankAccount.setOwnerId(resultSet.getInt("ownerid"));
        bankAccount.setAccountNumber(resultSet.getString("accountnumber"));
        bankAccount.setBalance(resultSet.getDouble("balance"));
        return bankAccount;
    }
}
