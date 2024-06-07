CREATE DATABASE exercise03;
use exercise03;

create table customer(
	c_id int primary key,
    c_name varchar(25) not null,
    c_age tinyint check(c_age > 0)
);

create table orders(
	o_id int primary key unique,
    c_id int,
    foreign key(c_id) references customer(c_id),
    o_date date not null,
    o_total_price int check(o_total_price > 0)
);


create table product(
	p_id int primary key,
    p_name varchar(25) not null,
    p_price int check(p_price > 0)
);

create table order_detail(
	o_id int,
    foreign key(o_id) references orders(o_id),
    p_id int,
    foreign key(p_id) references product(p_id),
    od_qty int check(od_qty > 0)
);

SELECT * FROM exercise03.customer;
insert into customer
values(1, 'Minh Quan', 10),
		(2, 'Ngoc Oanh', 20),
		(3, 'Hong Ha', 50);


SELECT * FROM exercise03.orders;
insert into orders(o_id, c_id, o_date)
value(1,1,'2006-3-21'),
(2,2,'2006-3-23'),
(3,1,'2006-3-16');

SELECT * FROM exercise03.product;
insert into product
value(1,'May Giat', 3),
(2,'Tu Lanh', 5),
(3,'Dieu Hoa', 7),
(4,'Quat', 1),
(5,'Bep Dien', 2);

SELECT * FROM exercise03.order_detail;
insert into order_detail
value(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);