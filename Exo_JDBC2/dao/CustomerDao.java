package org.example.Exo_JDBC2.dao;

import org.example.Exo_JDBC2.model.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao extends BaseDaoExo2<Customer>{
    public CustomerDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean createCust(Customer element) throws SQLException {
        request = "INSERT INTO customers (cust_name,cust_surname,cust_phone) values (?,?,?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,element.getCust_name());
        statement.setString(2,element.getCust_surname());
        statement.setInt(3,element.getCust_phone());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()){
            element.setCust_id(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public boolean updateCust(Customer element) throws SQLException {
        request = "UPDATE customers SET cust_name = ?, cust_surname = ?, cust_phone = ? WHERE cust_id = ?";
        statement = connection.prepareStatement(request);
        statement.setString(1,element.getCust_name());
        statement.setString(2,element.getCust_surname());
        statement.setInt(3,element.getCust_id());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public boolean deleteCust(Customer element) throws SQLException {
        request = "DELETE FROM customers WHERE cust_id = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,element.getCust_id());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }



    @Override
    public Customer get(int cust_id) throws SQLException {
        Customer customer = null;
        request = "SELECT * FROM customers WHERE id = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,cust_id);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            customer = new Customer(resultSet.getInt("cust_id"),
                    resultSet.getString("cust_name"),
                    resultSet.getString("cust_surname"),
            resultSet.getInt("cust_phone"));
        }
        return customer;
    }

    @Override
    public List<Customer> get() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        request = "SELECT * FROM customers";
        statement = connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()){
            Customer customer = new Customer(resultSet.getInt("cust_id"),
                    resultSet.getString("cust_name"),
                    resultSet.getString("cust_surname"),
                    resultSet.getInt("cust_phone"));
            customers.add(customer);
        }
        return customers;
    }
}
