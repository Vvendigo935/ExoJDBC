package org.example.Exo_JDBC2.services;

import org.example.Exo_JDBC2.dao.AccountDao;
import org.example.Exo_JDBC2.model.Account;
import org.example.Exo_JDBC2.utility.DatabaseManagerExo2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AccountService {

    private AccountDao accountDao;
    private Connection connection;


    public AccountService() {
        try {
            connection = new DatabaseManagerExo2().getConnection();
            accountDao = new AccountDao(connection);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public boolean createAcc(double acc_totalAmount, int acc_cust_id){
        Account account = new Account(acc_totalAmount, acc_cust_id);
        try {
            if(accountDao.createAcc(account)){
                return true;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Account getAcc(int id){
        try {
            return accountDao.get(id);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean deleteAcc(int id){
        Account account = null;
        try {
            account = accountDao.get(id);
            if(account != null){
                return accountDao.deleteAcc(account);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Account> getAllAcc(){
        try {
            return accountDao.get();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
