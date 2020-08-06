drop database if exists furama_resort_management;
create database furama_resort_management;

use furama_resort_management;

-- 1. Tạo bảng Vị trí.

create table positions(
	id_position int primary key auto_increment,
    name_position varchar(45)
    );
truncate table positions;
	insert into  positions(name_position)
	values
	('Receptionist'),
	('Server'),
	('Expert '),
	('Supervisor'),
	('Manager'),
	('Director');

-- 2. Tạo bảng Trình độ

create table degrees(
	id_degree int primary key auto_increment,
    degree varchar(45)
    );
	insert into degrees(degree)
	values
    ('Intermediate'),
    ('College'),
    ('University'),
    ('Post_graduate');

-- truncate table degrees;
-- 3. Tạo bảng Bộ phận

create table departments(
	id_department int primary key auto_increment,
    name_department varchar(45)
    );

	insert into departments(name_department)
	values
	('Sale_marketing'),
    ('Administration'),
    ('Service'),
    ('Management');
    
 --    truncate departments;
 -- 4. Tạo bảng Nhân viên
 
 create table employees(
	id_employee int primary key auto_increment,
    `name` varchar(50),
    birthday date,
    id_card varchar(45),
    salary varchar(45),
    phone_number varchar(45),
    email varchar(45),
    address varchar(45),
    id_position int,
    id_degree int,
    id_department int,
    foreign key (id_position) references positions (id_position),
    foreign key (id_degree) references degrees(id_degree),
    foreign key (id_department) references departments(id_department)
    );
    

	
INSERT INTO `furama_resort_management`.`employees` (`name`, `birthday`, `id_card`, `salary`, `phone_number`, `email`, `address`, `id_position`, `id_degree`, `id_department`) VALUES ('Vu Le Tuong', '2000-12-12', '123654987', '9000$', '0903736122', 'tuongvule@gmai.com', 'Quang Nam', '1', '1', '1');
INSERT INTO `furama_resort_management`.`employees` (`name`, `birthday`, `id_card`, `salary`, `phone_number`, `email`, `address`, `id_position`, `id_degree`, `id_department`) VALUES ('Nguyen Van Huy', '1999-11-24', '111222333', '4567$', '0900876456', 'nguyenvanhuy@gmai.com', 'Quang Binh', '2', '2', '3');
INSERT INTO `furama_resort_management`.`employees` (`name`, `birthday`, `id_card`, `salary`, `phone_number`, `email`, `address`, `id_position`, `id_degree`, `id_department`) VALUES ('Vo Duc Viet', '1998-9-24', '222333444', '9875$', '0789123765', 'voducviet@gmai.com', 'Quang Binh', '1', '2', '4');
INSERT INTO `furama_resort_management`.`employees` (`name`, `birthday`, `id_card`, `salary`, `phone_number`, `email`, `address`, `id_position`, `id_degree`, `id_department`) VALUES ('Duong Nhat Huy', '1997-4-13', '999888555', '4563$', '2347765123', 'duongnhathuy@gmail.com', 'DaNang', '2', '1', '4');
INSERT INTO `furama_resort_management`.`employees` ( `name`, `birthday`, `id_card`, `salary`, `phone_number`, `email`, `address`, `id_position`, `id_degree`, `id_department`) VALUES ('Pham Vu', '1996-8-31', '222777444', '1235$', '0123987643', 'phamvu@gmai.com', 'Binh Thuan', '3', '3', '1');
INSERT INTO `furama_resort_management`.`employees` (`name`, `birthday`, `id_card`, `salary`, `phone_number`, `email`, `address`, `id_position`, `id_degree`, `id_department`) VALUES ('Huynh Van Thinh', '2000-3-22', '765893164', '2345$', '0909080706', 'huynhvanthinh@gmai.com', 'Quang Ngai', '6', '3', '2');
INSERT INTO `furama_resort_management`.`employees` (`name`, `birthday`, `id_card`, `salary`, `phone_number`, `email`, `address`, `id_position`, `id_degree`, `id_department`) VALUES ('Nguyen Van Hieu', '2003-6-18', '123666887', '9876$', '0134765876', 'nguyenvanhieu@gmail.com', 'Ben Tre', '5', '4', '3');
INSERT INTO `furama_resort_management`.`employees` (`name`, `birthday`, `id_card`, `salary`, `phone_number`, `email`, `address`, `id_position`, `id_degree`, `id_department`) VALUES ('Nguyen Hai Dang', '2004-9-26', '987654321', '7653$', '0902878654', 'nguyenhaidang@gmail.com', 'Hau Giang', '4', '2', '3');
INSERT INTO `furama_resort_management`.`employees` (`name`, `birthday`, `id_card`, `salary`, `phone_number`, `email`, `address`, `id_position`, `id_degree`, `id_department`) VALUES ('Vo Dai Ka', '1996-2-18', '276489104', '3987', '0987542781', 'vodaika@gmail.com', 'Bac Lieu', '1', '1', '2');
INSERT INTO `furama_resort_management`.`employees` (`name`, `birthday`, `id_card`, `salary`, `phone_number`, `email`, `address`, `id_position`, `id_degree`, `id_department`) VALUES ('Vu Thanh Quang', '1992-4-6', '129384762', '8000', '0897654125', 'vuthanhquang@gmail.com', 'Thanh Hoa', '3', '3', '1');

-- 5. Tạo bảng loại khách

create table type_of_customers(
	id_type_of_customer int primary key auto_increment,
    name_type_of_customer varchar(45)
    );
    insert into type_of_customers(name_type_of_customer)
    values
    ('Diamond'),
    ('Gold'),
    ('Silver'),
    ('Member');
    
-- 6. Tạo bảng Khách hàng

create table customers(
	id_customer int primary key auto_increment,
    `name` varchar(45),
    birthday date,
    id_card varchar(45),
    phone_number varchar(45),
    email varchar(45),
    address varchar(45),
    id_type_of_customer int,
    foreign key (id_type_of_customer) references type_of_customers(id_type_of_customer)
    );
    
INSERT INTO `furama_resort_management`.`customers` (`name`, `birthday`, `id_card`, `phone_number`, `email`, `address`, `id_type_of_customer`) VALUES ('Nguyen Van B', '2008-09-8', '123456090', '0976431234', 'nguyenvana@gmai.com', 'DakLak', '1');
INSERT INTO `furama_resort_management`.`customers` (`name`, `birthday`, `id_card`, `phone_number`, `email`, `address`, `id_type_of_customer`) VALUES ('Tran Thi C', '1994-7-9', '287698234', '0345768921', 'tranthic@gmai.com', 'Gia Lai', '2');
INSERT INTO `furama_resort_management`.`customers` (`name`, `birthday`, `id_card`, `phone_number`, `email`, `address`, `id_type_of_customer`) VALUES ('Bui Thi C', '1995-3-5', '2098763421', '0977345128', 'buithic@gmail.com', 'Quang Ngai', '3');
INSERT INTO `furama_resort_management`.`customers` (`name`, `birthday`, `id_card`, `phone_number`, `email`, `address`, `id_type_of_customer`) VALUES ('Nguyen Dong', '1997-6-7', '209865482', '0987654321', 'nguyendong@gmail.com', 'Quang Nam', '4');
INSERT INTO `furama_resort_management`.`customers` (`name`, `birthday`, `id_card`, `phone_number`, `email`, `address`, `id_type_of_customer`) VALUES ('Do Van', '1996-10-29', '145237459', '0999888777', 'dovan@gmail.com', 'Ha Giang', '4');
INSERT INTO `furama_resort_management`.`customers` (`name`, `birthday`, `id_card`, `phone_number`, `email`, `address`, `id_type_of_customer`) VALUES ('Tran Van Thang', '1973-6-21', '208765986', '0900000765', 'tranvanthang@gmai.co,', 'Da Nang', '1');
INSERT INTO `furama_resort_management`.`customers` (`name`, `birthday`, `id_card`, `phone_number`, `email`, `address`, `id_type_of_customer`) VALUES ('Nguyen Tien Quoc', '1940-2-4', '237548918', '0907645286', 'nguyentienquoc@gmai.com', 'Da Nang', '1');
INSERT INTO `furama_resort_management`.`customers` (`name`, `birthday`, `id_card`, `phone_number`, `email`, `address`, `id_type_of_customer`) VALUES ('Tran Trung Quan', '2001-3-19', '275982875', '0123485671', 'trantrungquan@gmail.com', 'Quang Tri', '2');


	
-- 7. Tạo bảng Kiểu thuê

create table type_of_rents(
	id_type_of_rent int primary key auto_increment,
    name_type_of_rent varchar(45),
    price int
    );
	
insert into type_of_rents(name_type_of_rent, price)
	values
    ('by_year',7000),
    ('by_month',600),
    ('by_day',240),
    ('by_hour',25);
    
-- 8. Tạo bảng loại Dịch vụ

create table type_of_services(
	id_type_of_service int primary key auto_increment,
	name_type_of_service varchar(45)
    );
    
    insert into type_of_services(name_type_of_service)
    values
    ('Villa'),
    ('House'),
    ('Room');
    
-- 9. Tạo bảng Dịch vụ

create table services(
	id_service int primary key auto_increment,
    name_service varchar(45),
    area int,
    floor int,
    number_of_people varchar(45),
    cost varchar(45),
    status varchar(45),
    id_type_of_rent int, 
    id_type_of_service int,
    foreign key(id_type_of_rent) references type_of_rents(id_type_of_rent),
    foreign key(id_type_of_service) references type_of_services(id_type_of_service)
    );
INSERT INTO `furama_resort_management`.`services` (`name_service`, `area`, `floor`, `number_of_people`, `cost`, `status`, `id_type_of_rent`, `id_type_of_service`) VALUES ('Villa1', '20', '4', '5', '40', 'on', '1', '1');
INSERT INTO `furama_resort_management`.`services` (`name_service`, `area`, `floor`, `number_of_people`, `cost`, `status`, `id_type_of_rent`, `id_type_of_service`) VALUES ('House1', '40', '1', '6', '30', 'on', '2', '2');
INSERT INTO `furama_resort_management`.`services` (`name_service`, `area`, `floor`, `number_of_people`, `cost`, `status`, `id_type_of_rent`, `id_type_of_service`) VALUES ('Room1', '50', '2', '7', '60', 'on', '3', '3');
INSERT INTO `furama_resort_management`.`services` (`name_service`, `area`, `floor`, `number_of_people`, `cost`, `status`, `id_type_of_rent`, `id_type_of_service`) VALUES ('Villa2', '25', '3', '4', '70', 'on', '4', '1');
INSERT INTO `furama_resort_management`.`services` (`name_service`, `area`, `floor`, `number_of_people`, `cost`, `status`, `id_type_of_rent`, `id_type_of_service`) VALUES ('House2', '60', '5', '3', '70', 'on', '1', '2');
INSERT INTO `furama_resort_management`.`services` (`name_service`, `area`, `floor`, `number_of_people`, `cost`, `status`, `id_type_of_rent`, `id_type_of_service`) VALUES ('Room2', '35', '6', '3', '50', 'on', '2', '3');
INSERT INTO `furama_resort_management`.`services` (`name_service`, `area`, `floor`, `number_of_people`, `cost`, `status`, `id_type_of_rent`, `id_type_of_service`) VALUES ('Villa3', '55', '7', '6', '80', 'on', '3', '1');


-- 10.   Tạo bảng dịch vụ đi kèm

 create table accompanied_services(
	id_accompanied_service int primary key auto_increment,
    name_accompanied_service varchar(45),
    price int,
    unit varchar(45), 
    status_of_customer varchar(45)
    );

INSERT INTO `furama_resort_management`.`accompanied_services` (`name_accompanied_service`, `price`, `unit`) VALUES ('Massage', '50', 'hour');
INSERT INTO `furama_resort_management`.`accompanied_services` (`name_accompanied_service`, `price`, `unit`) VALUES ('Karaoke', '30', 'hour');
INSERT INTO `furama_resort_management`.`accompanied_services` (`name_accompanied_service`, `price`, `unit`) VALUES ('Food', '50', 'portion');
INSERT INTO `furama_resort_management`.`accompanied_services` (`name_accompanied_service`, `price`, `unit`) VALUES ('Drink', '20', 'portion');
INSERT INTO `furama_resort_management`.`accompanied_services` (`name_accompanied_service`, `price`, `unit`) VALUES ('Car Rental', '20', 'hour');

-- 11. Tạo bảng Hợp đồng

create table contracts(
	id_contract int primary key auto_increment,
    contract_start_date date,
    contract_end_date date,
	deposit int,
    total_money int,
    id_employee int,
    id_customer int,
    id_service int,
    foreign key (id_employee) references employees(id_employee),
    foreign key (id_customer) references customers(id_customer),
    foreign key (id_service) references services(id_service)
    );

INSERT INTO `furama_resort_management`.`contracts` (`id_contract`, `contract_start_date`, `contract_end_date`, `deposit`, `total_money`, `id_employee`, `id_customer`, `id_service`) VALUES ('2', '2020-1-15', '2020-1-24', '1200', '7400', '2', '6', '2');
INSERT INTO `furama_resort_management`.`contracts` (`id_contract`, `contract_start_date`, `contract_end_date`, `deposit`, `total_money`, `id_employee`, `id_customer`, `id_service`) VALUES ('3', '2020-1-15', '2020-1-24', '1200', '7400', '3', '8', '3');
INSERT INTO `furama_resort_management`.`contracts` (`id_contract`, `contract_start_date`, `contract_end_date`, `deposit`, `total_money`, `id_employee`, `id_customer`, `id_service`) VALUES ('4', '2020-1-15', '2020-1-24', '1200', '9000', '3', '6', '4');
INSERT INTO `furama_resort_management`.`contracts` (`id_contract`, `contract_start_date`, `contract_end_date`, `deposit`, `total_money`, `id_employee`, `id_customer`, `id_service`) VALUES ('5', '2020-3-20', '2020-3-28', '1200', '7100', '4', '1', '5');
INSERT INTO `furama_resort_management`.`contracts` (`id_contract`, `contract_start_date`, `contract_end_date`, `deposit`, `total_money`, `id_employee`, `id_customer`, `id_service`) VALUES ('6', '2020-3-20', '2020-3-26', '1000', '7200', '5', '7', '6');
INSERT INTO `furama_resort_management`.`contracts` (`id_contract`, `contract_start_date`, `contract_end_date`, `deposit`, `total_money`, `id_employee`, `id_customer`, `id_service`) VALUES ('7', '2020-4-15', '2020-4-25', '1000', '8000', '6', '7', '7');
INSERT INTO `furama_resort_management`.`contracts` (`id_contract`, `contract_start_date`, `contract_end_date`, `deposit`, `total_money`, `id_employee`, `id_customer`, `id_service`) VALUES ('8', '2020-5-15', '2020-5-25', '1000', '8000', '6', '7', '7');


-- 12. Tạo bảng Hợp đồng chi tiết

create table detailed_contracts(
	id_detailed_contract int primary key auto_increment,
    quantity int,
    id_contract int, 
    id_accompanied_service int, 
    foreign key (id_contract) references contracts (id_contract),
    foreign key (id_accompanied_service) references accompanied_services (id_accompanied_service)
    );
    

    
    
    
    
	



