use practice_ss29;

-- phân trang danh sách
delimiter //
create procedure get_employee_per_page (
    in in_numberOfElement int,
    in in_currentPage int
)
begin
    declare page int  default (in_currentPage - 1) * in_numberOfElement;
    select * from employee limit in_numberOfElement offset page;
end //
delimiter //


-- lấy tất
delimiter  //
create procedure  get_all_employee()
begin
    select * from employee;
end //
delimiter //;