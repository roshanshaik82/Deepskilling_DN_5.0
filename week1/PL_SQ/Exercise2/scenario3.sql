CREATE TABLE bank_accounts (
    account_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(50),
    balance NUMBER(10,2)
);
INSERT INTO bank_accounts VALUES (1001, 'Ali', 20000);
INSERT INTO bank_accounts VALUES (1002, 'Ahmed', 10000);
COMMIT;
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
)
IS
    v_balance NUMBER;
BEGIN
    SELECT balance
    INTO v_balance
    FROM bank_accounts
    WHERE account_id = p_from_account;
    IF v_balance >= p_amount THEN
        UPDATE bank_accounts
        SET balance = balance - p_amount
        WHERE account_id = p_from_account;
        UPDATE bank_accounts
        SET balance = balance + p_amount
        WHERE account_id = p_to_account;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer Successful');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient Balance');
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Account Not Found');
END;
/
EXEC TransferFunds(1001,1002,5000);
SELECT * FROM bank_accounts;