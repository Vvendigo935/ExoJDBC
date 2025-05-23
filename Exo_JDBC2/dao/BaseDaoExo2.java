package org.example.Exo_JDBC2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDaoExo2<T> {
    protected Connection connection;
    protected PreparedStatement statement;
    protected String request;
    protected ResultSet resultSet;

    protected BaseDaoExo2(Connection connection){
        this.connection = connection;
    }

    public abstract boolean createCust(T element) throws SQLException;
    public abstract boolean updateCust(T element) throws SQLException;
    public abstract boolean deleteCust(T element) throws SQLException;
    public abstract T get(int id) throws SQLException;
    public abstract List<T> get() throws SQLException;
}

abstract class BaseDaoExo2b<Y>{

    protected Connection connection;
    protected PreparedStatement statement;
    protected String request;
    protected ResultSet resultSet;


    protected BaseDaoExo2b(Connection connection){
        this.connection = connection;}

    public abstract boolean createAcc(Y element) throws SQLException;
    public abstract boolean deleteAcc(Y element) throws SQLException;
    public abstract Y get(int id) throws SQLException;
    public abstract List<Y> get() throws SQLException;
}

abstract class BaseDaoExo2c<U>{

    protected Connection connection;
    protected PreparedStatement statement;
    protected String request;
    protected ResultSet resultSet;


    protected BaseDaoExo2c(Connection connection){
        this.connection = connection;}

    public abstract boolean createOp(U element) throws SQLException;
    public abstract boolean updateOp(U element) throws SQLException;
    public abstract U get(int id) throws SQLException;
    public abstract List<U> get() throws SQLException;
}