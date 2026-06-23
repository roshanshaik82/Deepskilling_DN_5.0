BEGIN
    FOR cust IN (
        SELECT customer_name, loan_due_date
        FROM customers
        WHERE loan_due_date BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: ' || cust.customer_name ||
            ' loan due on ' ||
            TO_CHAR(cust.loan_due_date,'DD-MON-YYYY')
        );
    END LOOP;
END;
/