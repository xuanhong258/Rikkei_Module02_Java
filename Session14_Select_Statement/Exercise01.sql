create database session12_exercise01;
use session12_exercise01;

create table class(
	class_id int primary key auto_increment,
    class_name varchar(100) not null,
    start_date date not null,
    class_status bit default(1)
);

create table student(
	student_id int primary key auto_increment,
    student_name varchar(100) not null unique,
    address text not null,
    phone text not null,
    student_status bit default(1),
    class_id int,
    foreign key(class_id) references class(class_id)
);

create table subjects(
	sub_id int primary key auto_increment,
    sub_name varchar(100) not null unique,
    credit float check(credit > 0),
    sub_status bit default(1)
);

create table mark(
	mark_id int primary key auto_increment,
    sub_id int,
    foreign key(sub_id) references subjects(sub_id),
    student_id int,
    foreign key(student_id) references student(student_id),
    mark float check(mark > 0),
    exam_time date not null
);

insert into class(class_name, start_date, class_status)
values('JV240403', '2024-04-03', 1),
('JV240219', '2024-02-19', 0),
('JV240408', '2024-04-08', 1),
('JV241203', '2024-12-03', 1),
('JV241230', '2024-12-30', 1);

insert into subjects(sub_name, credit, sub_status)
values('Toan', 2, 1),
('Van', 3, 1),
('Dia Ly', 5, 0),
('Sinh hoc', 4, 1),
('English', 2, 1),
('Lich su', 3, 0);

insert into mark(sub_id, student_id, mark, exam_time)
values(1, 19, 10, '2024-06-09'),
(2, 21, 10, '2024-06-09'),
(3, 23, 8, '2024-06-09'),
(5, 25, 6, '2024-06-09'),
(3, 24, 9, '2024-06-09');

insert into mark(sub_id, student_id, mark, exam_time)
values(1, 27, 6, '2024-06-09');

insert into student(student_name, address, phone, student_status, class_id)
values('Tuan', 'Ha Noi', '0999999991',1, 1),
('Hung', 'Nam Dinh', '0999999992',1, 2),
('Nam', 'HCM', '0999999993',1, 1),
('Dieu', 'Ha Noi', '0999999994',0, 3),
('Quang', 'HCM', '0999999995',1, 3),
('Dat', 'HCM', '0999999996',1, 3),
('Hong', 'Nam Dinh', '0999999997',1, 4),
('Hoang', 'Ha Noi', '0999999998',1, 2),
('Diem', 'Nam Dinhi', '0999999999',1, 1);
select * from student;

select *
from student
where student.student_name like 'H%';

select *
from class
where class.start_date between '2024-12-01' and '2024-12-31';

select *
from subjects
where credit between 3 and 5;

update student 
set class_id = 2
where student_name = 'Hung';
select * from student;

select st.student_name, oc.sub_name, oc.mark
from student st inner join
(select subjects.sub_name, mark.mark, student_id
from mark inner join subjects on mark.sub_id = subjects.sub_id) as oc
where st.student_id = oc.student_id
order by oc.mark DESC, st.student_name ASC;















