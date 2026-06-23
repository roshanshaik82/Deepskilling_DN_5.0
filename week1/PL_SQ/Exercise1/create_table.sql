-- Create Table
CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(50),
    age NUMBER,
    balance NUMBER,
    interest_rate NUMBER,
    isvip VARCHAR2(5),
    loan_due_date DATE
);
-- Insert Sample Data
INSERT INTO customers VALUES(101, 'ram', 65, 15000, 10, 'FALSE', SYSDATE + 10);
INSERT INTO customers VALUES(102, 'ravi', 45, 8000, 12, 'FALSE', SYSDATE + 40);
INSERT INTO customers VALUES(103, 'sita', 70, 25000, 11, 'FALSE', SYSDATE + 20);
INSERT INTO customers VALUES(104, 'prem', 30, 5000, 13, 'FALSE', SYSDATE + 5);
COMMIT;
SELECT * FROM customers;