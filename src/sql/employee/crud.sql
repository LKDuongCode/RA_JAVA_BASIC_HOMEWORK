use practice_ss29;

use practice_ss29;

DELIMITER //

CREATE PROCEDURE insert_employee(
    IN in_employeeId VARCHAR(10),
    IN in_employeeName VARCHAR(150),
    IN in_email VARCHAR(100),
    IN in_phone VARCHAR(20),
    IN in_gender VARCHAR(10),
    IN in_levelSalary INT,
    IN in_salary DOUBLE,
    IN in_dob DATE,
    IN in_address VARCHAR(255),
    IN in_departmentId INT,
    IN in_status VARCHAR(20)
)
BEGIN
    INSERT INTO employee (
        employeeId, employeeName, email, phone, gender,
        levelSalary, salary, dob, address, departmentId, status
    )
    VALUES (
               in_employeeId, in_employeeName, in_email, in_phone, in_gender,
               in_levelSalary, in_salary, in_dob, in_address, in_departmentId, in_status
           );
END //

DELIMITER //;



DELIMITER //

CREATE PROCEDURE update_employee(
    IN in_employeeId VARCHAR(5),
    IN in_employeeName VARCHAR(150),
    IN in_email VARCHAR(100),
    IN in_phone VARCHAR(10),
    IN in_gender VARCHAR(10),
    IN in_levelSalary INT,
    IN in_salary DOUBLE,
    IN in_dob DATE,
    IN in_address VARCHAR(255),
    IN in_departmentId INT,
    IN in_status VARCHAR(20)
)
BEGIN
    UPDATE employee
    SET
        employeeName = in_employeeName,
        email = in_email,
        phone = in_phone,
        gender = in_gender,
        levelSalary = in_levelSalary,
        salary = in_salary,
        dob = in_dob,
        address = in_address,
        departmentId = in_departmentId,
        status = in_status
    WHERE employeeId = in_employeeId;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE delete_employee(
    IN in_employeeId VARCHAR(5)
)
BEGIN
    DELETE FROM employee WHERE employeeId = in_employeeId;
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE find_employee_by_name_and_age_range (
    IN in_employeeName VARCHAR(150),
    IN in_minAge INT,
    IN in_maxAge INT
)
BEGIN
    SELECT
        employeeId,
        employeeName,
        email,
        phone,
        gender,
        levelSalary,
        salary,
        dob,
        address,
        departmentId,
        status
    FROM employee
    WHERE employeeName LIKE CONCAT('%', in_employeeName, '%')
      AND TIMESTAMPDIFF(YEAR, dob, CURDATE()) BETWEEN in_minAge AND in_maxAge;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE find_employee_by_id (
    IN in_employeeId VARCHAR(5)
)
BEGIN
    SELECT
        employeeId,
        employeeName,
        email,
        phone,
        gender,
        levelSalary,
        salary,
        dob,
        address,
        departmentId,
        status
    FROM employee
    WHERE employeeId = in_employeeId;
END //

DELIMITER ;


