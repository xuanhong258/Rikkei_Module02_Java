create database  quanlynhanvien;
use quanlynhanvien;

create table department(
    department_id varchar(5) primary key ,
    department_name varchar(50) not null unique ,
    description text,
    is_deleted bit default (0)
);

create table employee(
    employee_id int primary key auto_increment,
    first_name varchar(20) not null ,
    last_name varchar(20) not null ,
    date_of_birth date not null ,
    phone varchar(15) not null unique ,
    address varchar(255) null ,
    salary double not null check ( salary >0 ),
    created_at datetime default (CURDATE()),
    update_at datetime default (null),
    is_deleted bit default(0),
    department_id varchar(5) not null ,
    foreign key (department_id) references department(department_id)
);

DELIMITER &&
create procedure proc_find_all_department()
begin
    select * from department;
end &&
DELIMITER &&

DELIMITER &&
create procedure proc_create_department(
    id_in varchar(5),
    name_in varchar(50),
    des_in text,
    del_in bit
)
begin
    insert into department
        VALUES (id_in, name_in, des_in, del_in);
end &&
DELIMITER &&

DELIMITER &&
create procedure proc_is_exist_department(
    id_in varchar(5),
    out is_exist bit
)
begin
    declare cnt int;
    set cnt = (select count(*) from department where department_id = id_in);
    if cnt = 0 then
        set is_exist = 0;
    else
        set is_exist = 1;
    end if;
end &&
DELIMITER &&

DELIMITER &&
create procedure proc_update_department(
    id_in varchar(5),
    name_in varchar(50),
    des_in text,
    del_in bit
)
begin
    update department
        set department_name = name_in,
            description = des_in,
            is_deleted = del_in
    where department_id = id_in;
end &&
DELIMITER &&

DELIMITER &&
create procedure proc_get_department_by_id(
    id_in varchar(5)
)
begin
    select * from department where department_id = id_in;
end &&

DELIMITER &&
create procedure proc_delete_department(
    id_in varchar(5)
)
begin
    update department
        set is_deleted = 0
    where department_id = id_in;
end &&
DELIMITER &&

DELIMITER &&
create procedure proc_statistic_employee_by_department_id()
begin
    select d.department_id, d.department_name, count(e.department_id) as 'employeeNumber'
    from department d join employee e on d.department_id = e.department_id
    group by e.department_id;
end &&
DELIMITER &&

DELIMITER &&
create procedure proc_get_all_employee()
begin
    select * from employee;
end &&
DELIMITER &&

DELIMITER &&
create procedure proc_create_employee(
    f_name_in varchar(20),
    l_name_in varchar(20),
    date_in date,
    phone_in varchar(15),
    address_in varchar(255),
    salary_in double,
    create_at_in datetime,
    update_at_in datetime,
    is_deleted_in bit,
    department_id_in varchar(5)
)
begin
    insert into employee(first_name, last_name, date_of_birth, phone, address, salary, created_at, update_at, is_deleted, department_id)
        VALUES(f_name_in, l_name_in, date_in, phone_in, address_in, salary_in, create_at_in, update_at_in, is_deleted_in, department_id_in);

end &&
DELIMITER &&
