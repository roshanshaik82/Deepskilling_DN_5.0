CREATE TABLE employees (
    emp_id NUMBER PRIMARY KEY,
    emp_name VARCHAR2(50),
    department VARCHAR2(30),
    salary NUMBER(10,2)
);
INSERT INTO employees VALUES (1, 'Rahul', 'IT', 50000);
INSERT INTO employees VALUES (2, 'Priya', 'IT', 60000);
INSERT INTO employees VALUES (3, 'Kiran', 'HR', 40000);

COMMIT;
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
)
IS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * p_bonus_percent / 100)
    WHERE department = p_department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Bonus Updated Successfully');
END;
/
EXEC UpdateEmployeeBonus('IT', 10);
SELECT * FROM employees;