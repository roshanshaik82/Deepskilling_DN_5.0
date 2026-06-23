CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(50),
    account_type VARCHAR2(20),
    balance NUMBER(10,2)
);
INSERT INTO accounts VALUES (101, 'Ali', 'SAVINGS', 10000);
INSERT INTO accounts VALUES (102, 'Ahmed', 'SAVINGS', 15000);
INSERT INTO accounts VALUES (103, 'John', 'CURRENT', 20000);

COMMIT;
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    UPDATE accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_type = 'SAVINGS';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly Interest Applied Successfully');
END;
/
EXEC ProcessMonthlyInterest;
SELECT * FROM accounts;