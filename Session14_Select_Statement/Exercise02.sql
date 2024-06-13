create database session12_exercise02;
use session12_exercise02;

create table customer(
	customer_id int primary key auto_increment,
    customer_name varchar(100) not null,
    age int check(age > 0)
);

insert into customer(customer_name, age)
values('Minh Quan', 10),
		('Ngoc Oanh', 20),
		('Hong Ha', 50);

create table orders(
	order_id int primary key auto_increment,
    customer_id int,
    foreign key(customer_id) references customer(customer_id),
    order_date date not null,
    order_total int
);

insert into orders(customer_id, order_date)
values(1, '2006-03-21'),
		(2, '2006-03-23'),
		(1, '2006-03-16');

create table products(
	product_id int primary key auto_increment,
    product_name varchar(100) not null,
    product_price int check(product_price > 0)
);

insert into products(product_name, product_price)
values('May giat', 3),
		('Tu lanht', 5),
        ('Dieu hoa', 7),
		('Quat', 1),
        ('Bep dien', 2);

create table order_detail(
	order_id int,
    foreign key(order_id) references orders(order_id),
    product_id int,
    foreign key(product_id) references products(product_id),
    primary key(order_id, product_id),
    quantity int check(quantity > 0)
);

insert into order_detail
values(1, 1, 3),
		(1, 3, 7),
        (1, 4, 2),
        (2, 1, 1),
        (3, 1, 8),
        (2, 5, 4),
        (2, 3, 3);

select c.customer_name, p.product_name
from ((customer c inner join orders o on c.customer_id = o.customer_id)
	inner join order_detail od on o.order_id = od.order_id
    inner join products p on p.product_id = od.product_id
);

select *
from customer cu
where cu.customer_id not in(
select distinct c.customer_id
from customer c join orders o on c.customer_id = o.customer_id);

select o.order_id, o.order_date, od.quantity * p.product_price as price
from(orders o inner join order_detail od on o.order_id = od.order_id)
inner join products p on p.product_id = od.product_id
order by price asc;






