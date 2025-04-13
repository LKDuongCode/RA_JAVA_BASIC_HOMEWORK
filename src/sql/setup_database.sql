create database practice_ss29;
use practice_ss29;

create table Account (
    username varchar(50) primary key,
    password varchar(50) not null,
    status bit
);

create table Department (
    departmentId int primary key auto_increment,
    departmentName varchar(100) not null unique ,
    description varchar(255),
    status bit
);

create table Employee (
    employeeId varchar(5) primary key,
    employeeName varchar(150),
    email varchar(100) unique ,
    phone varchar(10),
    gender enum('MALE','FEMALE','OTHER'),
    levelSalary int check ( levelSalary > 0 ),
    salary DOUBLE CHECK (salary > 0),
    dob date,
    address varchar(255) not null,
    status enum('ACTIVE','INACTIVE','ONLEAVE','POLICYLEAVE'),
    departmentId int,
    foreign key (departmentId) references Department(departmentId)
);

