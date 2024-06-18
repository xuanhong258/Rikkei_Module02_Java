create database JDBC_Demo_DB;
use JDBC_Demo_DB;

create table Categories(
    catalog_id int primary key auto_increment,
    catalog_name varchar(150) not null unique ,
    description text,
    catalog_status bit
);

create table Product(
    product_id char(5) primary key ,
    product_name varchar(100) not null unique ,
    price float check ( price > 0 ),
    title varchar(200),
    catalog_id int,
    foreign key (catalog_id) references Categories(catalog_id),
    product_status bit
);

DELIMITER &&
create procedure get_all_category()
begin
    select * from categories;
end &&
DELIMITER &&

DELIMITER &&
create procedure create_catalog(
    name_in varchar(150),
    description_in text,
    status_in bit
)
begin
    insert into categories(catalog_name, description, catalog_status)
        VALUES(name_in, description_in, status_in);
end &&
DELIMITER &&

DELIMITER &&
create procedure update_catalog(
    id_in int,
    name_in varchar(150),
    description_in text,
    status_in bit
)
begin
    update categories
        set catalog_name = name_in,
            description = description_in,
            catalog_status = status_in
    where catalog_id = id_in;
end &&
DELIMITER &&

DELIMITER &&
create procedure is_exist_catalog(
    id_in int,
    out is_exist bit
)
begin
    declare cnt_catalog int;
    set cnt_catalog = (select count(*) from categories where catalog_id = id_in);
    if cnt_catalog = 0 then
        set is_exist = 0;
    else
        set is_exist = 1;
    end if;
end &&
DELIMITER &&

DELIMITER &&
create procedure get_catalog_by_id(
    id_in int
)
begin
    select * from categories where catalog_id = id_in;
end &&

DELIMITER &&

DELIMITER &&
create procedure delete_catalog_by_id(
    id_in int
)
begin
    delete from categories where catalog_id = id_in;
end &&

DELIMITER &&

DELIMITER &&
create procedure sort_catalog_by_name()
begin
    select * from categories order by catalog_name;
end &&
DELIMITER &&

DELIMITER &&
create procedure find_catalog_by_name(
    name_in varchar(150)
)
begin
    select * from categories where catalog_name = name_in;
end &&
DELIMITER &&

DELIMITER &&
create procedure is_exist_catalog_name(
    name_in varchar(150),
    out is_exist bit
)
begin
    declare cnt_catalog int;
    set cnt_catalog = (select count(*) from categories where catalog_name = name_in);
    if cnt_catalog = 0 then
        set is_exist = 0;
    else
        set is_exist = 1;
    end if;
end &&
DELIMITER &&

DELIMITER &&
create procedure get_all_product()
begin
    select * from product;
end &&
DELIMITER &&

DELIMITER &&
create procedure create_product(
    id_in char(5),
    name_in varchar(100),
    price_in float,
    title_in varchar(200),
    catalog_id_in int,
    status_in bit
)
begin
    insert into product
    VALUES (
            id_in,
            name_in,
            price_in,
            title_in,
            catalog_id_in,
            status_in
           );
end &&
DELIMITER &&

DELIMITER &&
create procedure update_product(
    id_in char(5),
    name_in varchar(100),
    price_in float,
    title_in varchar(200),
    catalog_id_in int,
    status_in bit
)
begin
    update product
        set product_name = name_in,
            price = price_in,
            title = title_in,
            catalog_id = catalog_id_in,
            product_status = status_in
    where product_id = id_in;
end &&
DELIMITER &&

DELIMITER &&
create procedure is_exist_product(
    id_in char(5),
    out is_exit bit
)
begin
    declare product_cnt int;
    set product_cnt = (select count(*) from product where product_id = id_in);
    if product_cnt = 0 then
        set is_exit = 0;
    else
        set is_exit = 1;
    end if;
end &&
DELIMITER &&

DELIMITER &&
create procedure get_product_by_id(
    id_in char(5)
)
begin
    select * from product where product_id = id_in;
end &&
DELIMITER &&

DELIMITER &&
create procedure delete_product(
    id_in char(5)
)
begin
    delete from product where product_id = id_in;
end &&
DELIMITER &&

DELIMITER &&
create procedure find_product(
    string_in varchar(200)
)
begin
    select * from product where product_name like concat('%', string_in, '%') or title like concat('%',string_in,'%');
end &&
DELIMITER &&

DELIMITER &&
create procedure statistic_product_by_catalog_id()
begin
    select c.catalog_id, c.catalog_name, count(p.catalog_id) as 'product_count'
    from Product p join Categories c on p.catalog_id = c.catalog_id
    group by c.catalog_id;
end &&
DELIMITER &&