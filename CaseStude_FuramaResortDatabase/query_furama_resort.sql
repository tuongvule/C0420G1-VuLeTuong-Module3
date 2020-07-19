/*2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên 
   bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.*/

use furama_resort_management;
select * from employees
where reverse(name) regexp  '^[a-z]+[H|K|T]' and name regexp'[a-zA-Z]{1,15}';

/*3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi
   và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.*/

select * from customers
having TIMESTAMPDIFF(YEAR,birthday,current_date()) >=18 and TIMESTAMPDIFF(YEAR,birthday,current_date()) <=50;

select * from customers
having TIMESTAMPDIFF(YEAR,birthday,current_date()) between  18 and 50;

/* 4. Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
	  Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
      Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.*/
      
