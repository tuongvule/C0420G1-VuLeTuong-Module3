/*
Bước 1: Sử dụng mệnh đề group by
Quan sát bảng orders trong csdl classicmodels.
*/
select status from orders 
group by status

/*
Bước 2: Sử dụng các hàm tập hợp với mệnh đề group by
*/
select status, COUNT(*) as 'So luong status'
from orders
group by status

/*
Bước 3: Sử dụng group by với hàm tập hợp truy vấn trên hai bảng.
Quan sát bảng orders và orderdetails.
Hãy thực hiện tính tổng số tiền của các đơn hàng theo trạng thái đặt hàng.
Ta sẽ sử dụng lệnh inner join để kết nối 2 bảng và sử dụng hàm sum để
tính tổng số tiền, nhóm theo trường status. Lệnh truy vấn được như sau:
*/

select status, sum(quantityOrdered * priceEach) as amount
from orders
inner join orderdetails on orders.orderNumber = orderdetails.orderNumber
group by status

/*
Bước 4: Một yêu cầu khác là tính tổng tiền của từng đơn hàng, 
thực hiện lệnh truy vấn sau:
*/
select orderNumber, sum(quantityOrdered*priceEach) as total
from orderdetails
group by orderName;

/*
Bước 5: GROUP BY với mệnh đề HAVING
Để lọc các nhóm được trả về bởi mệnh đề GROUP BY, chúng ta sử dụng mệnh đề HAVING.
 Truy vấn sau đây sử dụng mệnh đề HAVING để bao gồm tổng doanh thu của những năm lớn hơn năm 2003.
*/
select year(orderDate) as year,
sum(quantityOrdered * priceEach) as total
from orders
inner join  orderdetails on orders.orderNumber = orderdetails.orderNumber
where status = 'shipped'
group by year()
having year > 2003



