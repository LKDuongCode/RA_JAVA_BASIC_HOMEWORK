use practice_ss29;

delimiter //
create procedure login_account (
    in in_username varchar(50),
    in in_password varchar(50)
)
begin
    select username, password, status
    from account
    where username = in_username
    and password = in_password
    and status = true;
end //

// delimiter ;