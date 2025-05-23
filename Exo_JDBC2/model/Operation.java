package org.example.Exo_JDBC2.model;

public class Operation {
    private int op_id;
    private double op_amount;
    private String op_status;
    private int op_acc_id;

    public Operation() {
    }

    public Operation(double op_amount, String op_status, int op_acc_id) {
        this.op_amount = op_amount;
        this.op_status = op_status;
        this.op_acc_id = op_acc_id;
    }

    public int getOp_id() {
        return op_id;
    }

    public void setOp_id(int op_id) {
        this.op_id = op_id;
    }

    public double getOp_amount() {
        return op_amount;
    }

    public void setOp_amount(double op_amount) {
        this.op_amount = op_amount;
    }

    public String getOp_status() {
        return op_status;
    }

    public void setOp_status(String op_status) {
        this.op_status = op_status;
    }

    public int getOp_acc_id() {
        return op_acc_id;
    }

    public void setOp_acc_id(int op_acc_id) {
        this.op_acc_id = op_acc_id;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "op_id=" + op_id +
                ", op_amount=" + op_amount +
                ", op_status='" + op_status + '\'' +
                ", op_acc_id=" + op_acc_id +
                '}';
    }
}
