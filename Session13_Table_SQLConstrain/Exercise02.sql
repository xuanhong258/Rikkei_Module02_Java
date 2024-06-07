CREATE DATABASE exercise02;
use exercise02;

create table customer(
	c_id int primary key,
    c_name varchar(100) not null,
    c_age int check(c_age > 0)
);

create table orders(
	o_id int primary key,
    c_id int,
    foreign key(c_id) references customer(c_id),
    o_date date not null,
    o_total_price float check(o_total_price > 0)
);

create table product(
	p_id int primary key,
    p_name varchar(100) not null,
    p_price float check(p_price > 0)
);

create table order_detail(
	o_id int,
    foreign key(o_id) references orders(o_id),
    p_id int,
    foreign key(p_id) references product(p_id),
    od_qty int check(od_qty > 0)
);

