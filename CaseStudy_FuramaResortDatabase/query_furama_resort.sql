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

 select distinct cus.id_customer, cus.name, tof.name_type_of_customer,cus.id_type_of_customer, con.id_contract, s.name_service, con.contract_start_date, con.contract_end_date,
			(cost + price*unit) as Total_money
from customers cus
left join contracts con on cus.id_customer = con.id_customer
left join services s on con.id_service = s.id_service
left join detailed_contracts dc on con.id_contract = dc.id_contract
inner join type_of_customers tof on tof.id_type_of_customer = cus.id_type_of_customer
left join accompanied_services acse on acse.id_accompanied_service = dc.id_accompanied_service ;
-- select id_customer, name, type_of_customers.id_type_of_customer, contracts.id_contract, services.name_service,
-- contracts.contract_start_date, contracts.contract_end_date,(cast(services.cost as unsigned)*accompanied_services.unit*accompanied_services.price) as Total_money
-- from customers cus
-- left join contracts con on cus.id_customer = con.id_customer
-- inner join type_of_customers t on cus.id_type_of_customer = t.id_type_of_customer
-- left join services s on con.id_service = s.id_service
-- left join detailed_contracts dcon on dcon.id_contract = con.id_contract
-- left join accompanied_services acs on acs.id_accompanied_service = dcon.id_accompanied_service;

/*6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại 
Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).*/
-- select * from services s
-- inner join type_of_services tos on tos.id_type_of_service = s.id_type_of_service;
select * from services s
inner join type_of_services tos on s.id_type_of_service = tos.id_type_of_service
inner join contracts con on con.id_service = s.id_service
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
 
select  s.id_service, s.name_service, s.area, s.number_of_people, s.cost
from services s
inner join contracts con on con.id_service = s.id_service
inner join type_of_services tos on tos.id_type_of_service = s.id_type_of_service
where year(con.contract_start_date) = 2018 and not year(con.contract_start_date)=2019;

/* 8. Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên*/
select distinct `name`
from customers;
select * 
from customers
group by name;
select name
from customers
union
select name
from customers;

/*9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng 
trong năm 2020 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.*/

select month(contract_start_date), count(id_customer) as 'quantity of contracts', sum(total_money)
from contracts
where year(contract_start_date) =2020
group by month(contract_start_date);

/* 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, 
TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).*/

select con.id_contract, con.contract_start_date, con.contract_end_date, con.deposit, count(id_detailed_contract) as 'quantity of accompanied servives'
from contracts con
inner join detailed_contracts dc on dc.id_contract = con.id_contract 
group by con.id_contract;

/* 11. Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có 
		TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.*/
	
select cus.name, cus.address, acse.id_accompanied_service, acse.name_accompanied_service,  toc.name_type_of_customer
from accompanied_services acse
inner join detailed_contracts dc on dc.id_accompanied_service = acse.id_accompanied_service
inner join contracts con on con.id_contract = dc.id_contract
inner join customers cus on cus.id_customer = con.id_customer
inner join type_of_customers toc on toc.id_type_of_customer = cus.id_type_of_customer
where cus.id_type_of_customer=1 and (cus.address = 'Vinh' or cus.address = 'Da Nang')
group by cus.name;

/*12. Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, 
		SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả 
        các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được
        khách hàng đặt vào 6 tháng đầu năm 2019.*/
        
	select con.id_contract, e.name as 'name_employee', cus.name as 'name_customer', cus.phone_number, s.name_service, count(dc.id_detailed_contract)
    from contracts con 
    join employees e on con.id_employee = e.id_employee
    join customers cus on cus.id_customer = con.id_customer
    join services s on s.id_service = con.id_service
    join detailed_contracts dc on dc.id_contract = con.id_contract
    -- where year(con.contract_start_date)=2020;
    where (con.contract_start_date between '2020-1-01' and '2020-12-31') 
    and (con.contract_start_date not between '2019-01-01' and '2019-06-31');
    
--     where month(con.contract_start_date) in (10,11,12) and (not month(con.contract_start_date) in (1,2,3,4,5,6)) and year(con.contract_start_date)=2019;
/*13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các 
	Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).*/
    
    
    
select acs.id_accompanied_service, acs.name_accompanied_service, count(acs.id_accompanied_service)
   from accompanied_services acs
   join detailed_contracts dc on dc.id_accompanied_service = acs.id_accompanied_service
   join contracts con on con.id_contract = dc.id_contract
   join customers cus on cus.id_customer = con.id_customer
   group by acs.id_accompanied_service;
   
/*14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
   Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.*/
   
select acs.name_accompanied_service, con.id_contract, tos.name_type_of_service, count(dc.id_accompanied_service)
from contracts con
inner join detailed_contracts dc on  con.id_contract = dc.id_contract
inner join accompanied_services acs on acs.id_accompanied_service = dc.id_accompanied_service
inner join services s on s.id_service = con.id_service
inner join type_of_services tos on tos.id_type_of_service = s.id_type_of_service
group by name_accompanied_service
having count(dc.id_accompanied_service) =1;

/*15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan,
 SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.*/
 
 select con.id_employee, e.name, deg.degree, dep.name_department, e.phone_number,e.address, count(e.name)
from employees e
inner join contracts con on con.id_employee = e.id_employee
inner join degrees deg on deg.id_degree = e.id_degree
inner join departments dep on dep.id_department = e.id_department
where year(con.contract_start_date) in(2019, 2020)
group by e.name
having (count(e.name)) >=3;
/*16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019. */

/*17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ 
		Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với tổng
		Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ. */
update customers
join(
select type_of_customers.id_type_of_customer
from contracts 
inner join customers on customers.id_customer = contracts.id_customer
inner join type_of_customers on type_of_customers.id_type_of_customer = customers.id_type_of_customer
where name_type_of_customer="Diamond" and year(contracts.contract_start_date)=2020
group by customers.name
having sum(total_money) >10000
)
 v on customers.id_type_of_customer = v.id_type_of_customer
set customers.id_type_of_customer = 6;

        
/* 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).*/

/* 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi*/

update accompanied_services as a
inner join (
select d.id_accompanied_service
from detailed_contracts d
inner join contracts c on c.id_contract = d.id_contract
where year(c.contract_start_date) = 2019
group by d.id_accompanied_service
having count(d.id_accompanied_service) = 10
) v on v.id_accompanied_service = a.id_accompanied_service
set a.price = a.price*2;

/* 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
		thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.*/
select id_employee, name, email, phone_number, birthday, address
from employees
union
select id_customer, name, email, phone_number, birthday, address
from customers;