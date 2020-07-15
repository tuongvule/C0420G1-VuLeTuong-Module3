create database bank_account;
use bank_account;

create table customers(
id int primary key auto_increment,
name varchar(50) not null,
email varchar(100) unique not null,
phone varchar(15) unique not null
);

create table accounts(
id int primary key auto_increment,
type_account varchar(20),
open_date date,
balance int,

customer_id int,
foreign key(customer_id) references customers(id)
);

create table transactions(
id int primary key auto_increment,
amount int,
tran_time date,
tran_description varchar(200),

account_number int,
foreign key (account_number) references accounts(id)

);