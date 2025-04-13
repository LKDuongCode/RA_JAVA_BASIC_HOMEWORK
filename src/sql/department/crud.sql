use practice_ss29;

delimiter //
create procedure insert_department(
    in in_departmentName varchar(100),
    in in_description varchar(255)
)
begin
    insert
    into department (departmentName, description, status)
    values (in_departmentName, in_description, 1);
end //
delimiter //;


delimiter //
create procedure update_department (
    in in_departmentId int,
    in in_departmentName varchar(100),
    in in_description varchar(255),
    in in_status bit
)
begin
    update department
    set departmentName = in_departmentName, description = in_description, status = in_status
    where departmentId = in_departmentId;
end //
delimiter //;


delimiter //
create procedure delete_department (
    in in_departmentId int
)
begin
    delete from department where departmentId = in_departmentId;
end //
delimiter //;


delimiter //
create procedure find_department_by_name (
    in in_departmentName varchar(100)
)
begin
    select departmentId, departmentName, description, status from department where departmentName like concat('%', in_departmentName, '%');
end //
delimiter  //;

delimiter //
create procedure find_department_by_id (
    in in_departmentId int
)
begin
    select departmentId, departmentName, description, status from department where departmentId = in_departmentId;
end //
delimiter  //;

