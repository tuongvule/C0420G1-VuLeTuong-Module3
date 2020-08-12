-- yêu cầu 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
use furama_resort_management;
select * from employees
where reverse(name) regexp  '^[a-z]+[H|K|T]' and name regexp'[a-z A-Z]{1,15}';

select * from employees where ((`name` like 'h%') or (`name` like 'k%') or (`name` like '%t')) and (length(`name`)<15); 

-- yêu cầu 3: Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select * from customers
where address = "Da Nang" or address="Quang Tri"
having TIMESTAMPDIFF(YEAR,birthday,current_date()) >=18 and TIMESTAMPDIFF(YEAR,birthday,current_date()) <=50;

select * from customers
where address in ('Da Nang', 'Quang Tri') and (curdate()-birthday>(18*30*365) and curdate()-birthday < (50*30*365));

-- select `name`, (curdate()-birthday),current_date()  from customers;-- 

-- yêu cầu 4: Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select customers.name, count(contracts.id_customer) as number_of_reservations
from customers 
join contracts on customers.id_customer = contracts.id_customer
where customers.id_type_of_customer = 1
group by customers.name
order by number_of_reservations asc; 

select customers.`name`, count(contracts.id_customer) as number_of_reservations
from customers
join contracts on 
