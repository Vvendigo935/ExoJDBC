CREATE DATABASE IF NOT EXISTS exo_jdbc2;

USE exo_jdbc2;

CREATE TABLE IF NOT EXISTS customers(
cust_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
cust_name VARCHAR(50),
cust_surname VARCHAR(50),
cust_phone INT(10)
);

CREATE TABLE IF NOT EXISTS accounts(
acc_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
acc_totalAmount DOUBLE,
cust_id INT NOT NULL,
CONSTRAINT fk_cust_id FOREIGN KEY(cust_id)REFERENCES customers(cust_id)
);
-- a voir apres pour la liste des op

CREATE TABLE IF NOT EXISTS operations(
op_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
op_amount DOUBLE,
op_status VARCHAR(50),
acc_id INT NOT NULL,
CONSTRAINT fk_acc_id FOREIGN KEY(acc_id)REFERENCES accounts(acc_id)
);

SELECT * FROM customers;
SELECT * FROM accounts;
SELECT * FROM operations;

DROP TABLE customers;