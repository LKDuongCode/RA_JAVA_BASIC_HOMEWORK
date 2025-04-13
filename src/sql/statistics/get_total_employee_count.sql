use practice_ss29;

DELIMITER //

CREATE PROCEDURE get_total_employee_count()
BEGIN
SELECT COUNT(*) AS totalEmployee FROM employee;
END //

DELIMITER ;
