package org.example.Exo_JDBC2.model;

public class Customer {
    private int cust_id;
    private String cust_name;
    private String cust_surname;
    private int cust_phone;

    public Customer() {
    }

    public Customer(String cust_name, String cust_surname, int cust_phone) {
        this.cust_name = cust_name;
        this.cust_surname = cust_surname;
        this.cust_phone = cust_phone;
    }

    public Customer(int cust_id, String cust_name, String cust_surname, int custPhone) {
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.cust_surname = cust_surname;
        this.cust_phone = cust_phone;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_surname() {
        return cust_surname;
    }

    public void setCust_surname(String cust_surname) {
        this.cust_surname = cust_surname;
    }

    public int getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(int cust_phone) {
        this.cust_phone = cust_phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + cust_id +
                ", cust_name='" + cust_name + '\'' +
                ", cust_surname='" + cust_surname + '\'' +
                ", cust_phone=" + cust_phone +
                '}';
    }
}

