delimiter //
create procedure getCusByld
(in cusNum int(11))
begin
select * from customers where customerNumber = cusNum;
end 
// delimiter ;

call getCusByld(175);

delimiter //
create procedure GetCustomersCountByCity(
	in in_city varchar(50),
    out total int
    )
    
begin
	select count(customerNumber)
    into total
    from customers
    where city = in_city;
end//
delimiter ;

-- Gọi store procedure:
call GetCustomersCountByCity('Lyon',@total);
select @total;

-- tham số loại INOUT
-- INOUT là sự kết hợp giữa IN và OUT, ví dụ:
DELIMITER //

CREATE PROCEDURE SetCounter(
    INOUT counter INT,
    IN inc INT
)
BEGIN
    SET counter = counter + inc;
END//
DELIMITER ;

-- Gọi store procedure:

SET @counter = 1;

CALL SetCounter(@counter,1);

CALL SetCounter(@counter,1);

CALL SetCounter(@counter,5);

SELECT @counter;

