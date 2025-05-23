package org.example.Exo_JDBC2.model;

public class Account {
private int acc_id;
private double acc_totalAmount;
private int acc_cust_id;

    public Account() {
    }

    public Account(double acc_totalAmount, int acc_cust_id) {
        this.acc_totalAmount = acc_totalAmount;
        this.acc_cust_id = acc_cust_id;
    }

    public Account(int acc_id, double acc_totalAmount, int acc_cust_id) {
        this.acc_id = acc_id;
        this.acc_totalAmount = acc_totalAmount;
        this.acc_cust_id = acc_cust_id;
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public double getAcc_totalAmount() {
        return acc_totalAmount;
    }

    public void setAcc_totalAmount(double acc_totalAmount) {
        this.acc_totalAmount = acc_totalAmount;
    }

    public int getAcc_cust_id() {
        return acc_cust_id;
    }

    public void setAcc_cust_id(int acc_cust_id) {
        this.acc_cust_id = acc_cust_id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "acc_id=" + acc_id +
                ", acc_totalAmount=" + acc_totalAmount +
                ", acc_cust_id=" + acc_cust_id +
                '}';
    }
}
