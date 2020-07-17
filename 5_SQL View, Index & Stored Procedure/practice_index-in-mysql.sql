use classicmodels;
select * from customers where customerNumber = 175;

explain select * from customers where customerNumber  = 175;


-- Các bạn thêm chỉ mục cho bảng customers như sau:
alter table customers add index 
idx_customerNumber(customerNumber);

explain select * from customers where customerNumber  = 175;
/*
possible_keys : Đưa ra những Index có thể sử dụng để query
key : và Index nào đang được sử dụng
key_len : Chiều dài của từng mục trong Index
ref : Cột nào đang sử dụng
rows : Số hàng (rows) mà MySQL dự đoán phải tìm
extra : Thông tin phụ, thật tệ nếu tại cột này là “using temporary” hay “using filesort”
*/

/*
Bạn có thể Add index theo cặp như bạn add index cho cặp contactFirstName và contactLastName.
*/

alter table customers add index idx_full_name(contactFirstName, contactLastName);

explain select * from customers where contactFirstName = 'Jean' 
		or contactFirstName = 'King';
        



