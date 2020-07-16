create database library_management;
use library_management;

create table readers(
	id int primary key auto_increment,
    reader_name varchar(30) not null,
    address varchar(500),
    email varchar(50),
    image varchar(255)
    );
    

create table categories(
	id int primary key auto_increment,
    category_name varchar(200)
    );
    
create table authors(
	id int primary key auto_increment,
    author_name varchar(200)
    );
    
create table books(
	id int primary key auto_increment,
    book_name varchar(200),
    `description` text not null,
    category_id int,
    foreign key (category_id) references categories(id)
    );
    
create table author_book(
	book_id int,
    author_id int,
    primary key(book_id,author_id),
    foreign key (book_id) references books(id),
    foreign key (author_id) references authors(id)
    );
    
create table borrow_book(
	book_id int,
    reader_id int,
    primary key (book_id, reader_id),
    foreign key (book_id) references books(id),
    foreign key (reader_id) references readers(id)
    );
    
insert into readers(reader_name, address, email, image)
	values
    ('Tuong', 'Quang Nam', 'tuongvule@gmai.com','src1'),
    ('viet', 'Quang Nam', 'tuongvule@gmai.com','src1'),
    ('Huy', 'Quang Nam', 'tuongvule@gmai.com','src1'),
    ('Thinh', 'Quang Nam', 'tuongvule@gmai.com','src1'),
    ('Vu', 'Quang Nam', 'tuongvule@gmai.com','src1');
    
    
insert into categories(category_name)
	values
    ('Sach khoa hoc'),
    ('sach am nhac'),
    ('sach giao khoa'),
    ('sach ton giao'),
    ('sach tam ly'),
    ('sach suc khoe');

insert into authors(author_name)
	values
    ('nguyen bính'),
    ('nguyen nhat anh'),
    ('ho chi minh'),
    ('to huu'),
    ('to hoai'),
    ('xuan hong');


insert into books(book_name, `description`, category_id)
	values
    ('Tuong', 'Quang Nam', 'tuongvule@gmai.com'),
    ('Tuong', 'Quang Nam', 'tuongvule@gmai.com'),
    ('Tuong', 'Quang Nam', 'tuongvule@gmai.com'),
    ('Tuong', 'Quang Nam', 'tuongvule@gmai.com'),
    ('Tuong', 'Quang Nam', 'tuongvule@gmai.com'),
    ('Tuong', 'Quang Nam', 'tuongvule@gmai.com');
   
insert into author_book(book_id,author_id)
values
(1,1),
(1,2),
(1,3),
(2,1),
(2,2);

insert into borrow_book(book_id, reader_id)
values
(1,1),
(5,4),
(2,1),
(3,5),
(3,1);


    drop database library_management;
    
