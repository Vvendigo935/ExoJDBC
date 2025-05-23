package org.example.Exo_JDBC2.dao;

import org.example.Exo_JDBC2.model.Account;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AccountDao extends BaseDaoExo2b<Account> {
    public AccountDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean createAcc(Account element) throws SQLException {
        request = "INSERT INTO accounts (acc_totalAmount,acc_cust_id) values (?,?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1,element.getAcc_totalAmount());
        statement.setInt(2,element.getAcc_cust_id());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()){
            element.setAcc_id(resultSet.getInt(1));
        }
        return nbRow == 1;
    }


    @Override
    public boolean deleteAcc(Account element) throws SQLException {
        request = "DELETE FROM accounts WHERE acc_id = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,element.getAcc_id());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public Account get(int acc_id) throws SQLException {
        Account account = null;
        request = "SELECT * FROM accounts WHERE id = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,acc_id);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            account = new Account(resultSet.getInt("acc_id"),
                    resultSet.getDouble("acc_amount"),
                    resultSet.getInt("acc_cust_id"));
        }
        return account;
    }

    @Override
    public List<Account> get() throws SQLException {
        List<Account> accounts = null;
        request = "SELECT * FROM accounts";
        statement = connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
           Account account = new Account(resultSet.getInt("acc_id"),
                    resultSet.getDouble("acc_amount"),
                    resultSet.getInt("acc_cust_id"));
            accounts.add(account);
        }
        return accounts;
    }
}
