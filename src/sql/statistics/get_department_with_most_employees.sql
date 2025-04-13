use practice_ss29;

DELIMITER //

CREATE PROCEDURE get_department_with_most_employees()
BEGIN
    SELECT
        d.departmentId,
        d.departmentName,
        COUNT(e.employeeId) AS employeeCount
    FROM department d
             JOIN employee e ON d.departmentId = e.departmentId
    GROUP BY d.departmentId, d.departmentName
    ORDER BY employeeCount DESC
    LIMIT 1;
END //

DELIMITER ;
