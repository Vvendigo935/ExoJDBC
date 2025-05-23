package org.example.Exo_JDBC2.services;

import org.example.Exo_JDBC2.dao.CustomerDao;
import org.example.Exo_JDBC2.model.Customer;
import org.example.Exo_JDBC2.utility.DatabaseManagerExo2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustomerService {

    private CustomerDao customerDao;
    private Connection connection;

    public CustomerService() {
        try {
            connection = new DatabaseManagerExo2().getConnection();
            customerDao = new CustomerDao(connection);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public boolean createCust(String cust_name,String cust_surname,int cust_phone){
        Customer customer = new Customer(cust_name, cust_surname, cust_phone);
        try {
            if(customerDao.createCust(customer)){
                return true;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean updateCust(Customer customer){
        try {
            if(customerDao.updateCust(customer)){
                return true;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Customer getCust(int id){
        try {
            return customerDao.get(id);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean deleteCust(int id){
        Customer customer = null;
        try {
            customer = customerDao.get(id);
            if(customer != null){
                return customerDao.deleteCust(customer);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Customer> getAllCust(){
        try {
            return customerDao.get();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}