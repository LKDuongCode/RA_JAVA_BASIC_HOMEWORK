use practice_ss29;
DELIMITER //

CREATE PROCEDURE get_employee_count_by_department()
BEGIN
    SELECT
        d.departmentId,
        d.departmentName,
        COUNT(e.employeeId) AS employeeCount
    FROM department d
             LEFT JOIN employee e ON d.departmentId = e.departmentId
    GROUP BY d.departmentId, d.departmentName;
END //

DELIMITER ;
