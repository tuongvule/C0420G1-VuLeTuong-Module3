/*2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên 
   bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.*/

use furama_resort_management;
select * from employees
where reverse(name) regexp  '^[a-z]+[H|K|T]' and name regexp'[a-z A-Z]{1,15}';

/*3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi
   và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.*/

select * from customers
where address = "Da Nang" or address="Quang Tri"
having TIMESTAMPDIFF(YEAR,birthday,current_date()) >=18 and TIMESTAMPDIFF(YEAR,birthday,current_date()) <=50;

select * from customers
having TIMESTAMPDIFF(YEAR,birthday,current_date()) between  18 and 50;

/* 4. Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
	  Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
      Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.*/
      
select customers.name, count(contracts.id_customer) as number_of_reservations
from customers 
join contracts on customers.id_customer = contracts.id_customer
where customers.id_type_of_customer = 1
group by customers.name
order by number_of_reservations asc;

/* 5. Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu,
      NgayLamHopDong, NgayKetThuc, TongTien (Với TongTien được tính theo công thức như sau:
      ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các
      Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).*/

select customers.id_customer, customers.name, type_of_customers.id_type_of_customer, contracts.id_contract, services.name_service,
contracts.contract_start_date, contracts.contract_end_date,(cast(services.cost as unsigned)*accompanied_services.unit*accompanied_services.price) as Total_money
from customers cus
left join contracts con on cus.id_customer = con.is_customer
inner join type_of_customers t on cus.id_type_of_customer = t.id_type_of_customer
left join services s on con.id_service = s.id_service
left join detailed_contracts dcon on dcon.id_contract = con.id_contract
left join accompanied_services acs on acs.id_accompanied_service = dcon.id_accompanied_service;

/*6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại 
Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).*/

select * from services s
inner join type_of_services tos on s.id_service = tos.id_service
where s.id_service not in (
	select s.id_service
    from services s
    inner join type_of_services tos on s.id_type_of_service = tos.id_type_of_service
    inner join contracts con on s.id_service = con.id_service
    where year(con.contract_start_date) = 2019 and
    (month(con.contract_start_date)=1 or
	month(con.contract_start_date)=2 or
    month(con.contract_start_date)=3)
    );

/*7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu
 của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng 
 được Khách hàng đặt phòng  trong năm 2019.*/
 
--  select services.id_service, services.name, -- 
