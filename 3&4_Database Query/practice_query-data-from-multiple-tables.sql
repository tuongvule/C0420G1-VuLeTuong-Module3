/*
Bước 1: Sử dụng inner join để lấy dữ liệu từ hai bảng.
Quan sát 3 bảng customers, orders và payments trong csdl classicmodels.
Bây giờ, nếu bạn muốn lấy customerNumber, customerName, phone, paymentDate, 
amount từ hai bảng customers và payments với điều kiện là các khách hàng sống
 ở thành phố Las Vegas thực hiện truy vấn sau: 
*/
use classicmodels;
select customers.customerNumber, customerName, phone, paymentDate, amount
from customers
inner join payments
on customers.customerNumber = payments.customerNumber
where city = 'Las Vegas'

/*
-- Bước 2: Sử dụng left join để lấy dữ liệu từ hai bảng. 
-- Quan sát 2 bảng customers và orders trong csdl classicmodels. 
-- Để tìm tất cả các đơn hàng thuộc từng khách hàng, bạn có thể sử 
-- dụng mệnh đề LEFT JOIN như sau:
*/

select customers.customerNumber, customers.customerName, orders.status
from customers
left join orders
on customers.customerNumber = orders.customerNumber

/*
Để tìm tất cả khách hàng chưa đặt hàng bất kỳ sản phẩm nào, bạn có thể sử dụng truy vấn sau: 
*/

select customers.customerNumber, customers.customerName, orders.orderNumber, orders.status
from customers 
left join orders
on customers.customerNumber = orders.customerNumber
where orderNumber is null