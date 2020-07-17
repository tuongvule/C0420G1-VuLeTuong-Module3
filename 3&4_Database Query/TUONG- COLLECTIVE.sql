create database codegym_management;
-- drop database codegym_management;

use codegym_management;

create table account_james (
	`account` varchar(50),
    `password` varchar(50),
    
    constraint pk_account_james primary key (`account`)
);

create table instructor (
	id int primary key,
    `name` varchar(60),
    date_of_birth date
);

create table type_of_class (
	id int,
    `name` varchar(20),
    primary key (id)
);

create table class (
	id int primary key,
    `name` char(7),
    type_of_class_id int,
    
    foreign key (type_of_class_id) references type_of_class(id)
);

create table student (
	id int primary key,
    `name` varchar(60),
    date_of_birth date,
    `account` varchar(50),
    class_id int,
    
    foreign key (`account`) references account_james (`account`),
    foreign key (class_id) references class (id)
);


create table instructor_teach_class (
	class_id int,
    instructor_id int,
    
    primary key (class_id, instructor_id),
    foreign key (class_id) references class (id),
    foreign key (instructor_id) references instructor (id)
);

insert into type_of_class
values
(1, 'Full time'),
(2, 'Half time');

insert into class
values
(1, 'C0420G1', 1),
(2, 'C0520G1', 1),
(3, 'C0220H1', 2);

insert into account_james
values
('tien.nguyen', '12345678'),
('toan.le', '12345678'),
('chuong.kim', '12345678'),
('long.duong', '12345678');

insert into student
values
(1, 'Tien', '2000-07-14', 'tien.nguyen', 1),
(2, 'Toan', '2002-05-03', 'toan.le', 2),
(3, 'Chuong', '2001-04-03', 'chuong.kim', 2),
(4, 'Long', '2002-01-25', 'long.duong', null);

insert into instructor
values
(1, 'Tien', '2000-07-14'),
(2, 'Trung', '2002-05-03'),
(3, 'Hai', '2003-11-03'),
(4, 'Chanh', '1998-07-09');

insert into instructor_teach_class
values
(1, 1),
(1, 2),
(2, 1);

-- 4. Lấy ra tất cả thông tin giảng viên hiện đang không dạy lớp nào?
select *
from instructor i 
	left join instructor_teach_class itc
    on i.id = itc.instructor_id
where instructor_id is null;

-- 4. Lấy ra tất cả thông tin giảng viên hiện đang không dạy lớp nào?-- cách 2
select *
from instructor
where id not in (
	select instructor_id
	from instructor_teach_class
);

-- 3. Lấy ra thông tin của các học viên đang theo học tại lớp,
--  và lớp đó do giảng viên nào dạy?
select s.name as`student name`, c.name `class name`, i.name as `instructor name`
	from class c
	inner join student s on c.id = s.class_id
    inner join instructor_teach_class itc on itc.class_id = c.id
    inner join instructor i on itc.instructor_id = i.id;

/*
select *
from instructor
where exists (
	select instructor_id
	from instructor_teach_class
);
*/


-- 2. Tính tổng số giảng viên đang dạy mỗi lớp (kể cả giảng viên không dạy lớp nào)?
select c.id,c.name ,count(instructor_id)
from class c
left join instructor_teach_class itc
on c.id=itc.class_id
group by class_id
;

select c.name as `class name`, count(instructor_id) as`instructor amount`
	from instructor_teach_class itc
    right join class c on c.id = itc.class_id
    group by c.name;
    
-- 1. Tính tổng số học viên của mỗi lớp (kể cả lớp không có học viên học)?
select c.name, count(s.id)
	from student s
    right join class c on c.id = s.class_id
    group by c.name;
    
    -- 2.Hiển thị lớp mà không có học viên học.
select c.name, count(s.class_id)
	from student s
	right join class c on s.class_id = c.id
	group by c.id
	having count(s.class_id) = 0;
    
/*Bài tập bài mới
1. Lấy ra danh sách tất cả học viên, giảng viên đang làm việc và học tập tại CodeGym
2. Lấy ra danh sách các học viên không trùng tên nhau
3. Lấy ra 2 học viên đầu tiên được sắp xếp theo alphabet
4. Lấy ra tất cả thông tin giảng viên hiện đang không dạy lớp nào?
*/

-- 1
select id, name, date_of_birth, 'student' as 'type'
from student
union all
select id, name, date_of_birth, 'instructor' as 'type'
from instructor;

-- 2
select *
from student
group by name;
    
select distinct name
from student;

-- 3
select * 
from student
order by name asc
limit 2;

-- 4
select i.name, itc.instructor_id
	from instructor i
    left join instructor_teach_class itc
    on instructor_id = i.id
    where class_id is null;
    
-- thao tác với chuỗi

select *
from student
where name regexp binary '[A-Z]';
select date_format(date_of_birth, "%d %m %Y")
from student;
select concat(name, ' ', date_of_birth)
from student;

