CREATE DATABASE demo;
DROP DATABASE demo;
USE demo;

CREATE TABLE products(
id INT PRIMARY KEY AUTO_INCREMENT,
product_code VARCHAR(50),
product_name VARCHAR(100),
product_price INT,
product_amount INT,
product_description VARCHAR(200),
product_status VARCHAR(50)
);

INSERT INTO   products(product_code, product_name, product_price, product_amount, product_description, product_status)
VALUES
('lamp','lamp_learn',300000, 4,'vip lamp','on'),
('bot','glass_bottle',200000, 6,'normall bottle','on'),
('bok','paper_book',500000, 7,'friendly with environment','on'),
('spe','vip_speaker',345000, 9,'sound clear and detail','on'),
('mo','lamp_learn',450000, 12,'black and white','on');
					
-- THAO TÁC VỚI INDEX

EXPLAIN SELECT * FROM products
WHERE product_code = 'spe';

CREATE UNIQUE INDEX idx_product_code 
ON products (product_code);

EXPLAIN SELECT * FROM products
WHERE product_code = 'spe';

CREATE  INDEX idx_composite
ON products (product_name, product_amount);

-- THAO TÁC VỚI VIEW

CREATE VIEW product_view AS 
SELECT product_code, product_name, product_price, product_amount, product_status
FROM  products;

SELECT * FROM product_view;

UPDATE product_view
SET product_name = 'e_book'
WHERE product_code = 'bok';

DROP VIEW product_view;

-- THAO TÁC VỚI STORE_PROCEDURE
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
CREATE PROCEDURE show_all ()
BEGIN
	SELECT *
    FROM products;
END; //
delimiter ;

CALL show_all();

-- Tạo store procedure thêm một sản phẩm mới

delimiter //
CREATE PROCEDURE insert_all (v_code VARCHAR(50), v_name VARCHAR(50),
				v_price INT, v_amount INT, v_des VARCHAR(50),
				v_status VARCHAR(50))
BEGIN
INSERT INTO
products(product_code, product_name, product_price, product_amount, product_description, product_status)
VALUES
(v_code, v_name, v_price, v_amount, v_des, v_status);
END; //
delimiter ;	
USE demo;

CALL insert_all ('com', 'HP', 56000000, 7, 'color: silver, 14inch', 'on');
DROP PROCEDURE insert_all;

-- Tạo store procedure xoá sản phẩm theo id

delimiter //
CREATE PROCEDURE delete_all(v_id INT)
BEGIN
	DELETE FROM products
    WHERE id = v_id;
END; //
delimiter ;

CALL delete_all(4);

-- Tạo store procedure sửa thông tin sản phẩm theo id

delimiter //
CREATE PROCEDURE update_all(v_id INT, v_code VARCHAR(50), v_name VARCHAR(50),
				v_price INT, v_amount INT, v_des VARCHAR(50),
				v_status VARCHAR(50) )
	BEGIN 
    UPDATE demo.products
    SET 
    product_code = v_code,
    product_name = v_name,
    product_price = v_price,
    product_amount = v_amount,
    product_description = v_des,
    product_status = v_status
    WHERE id = v_id;
    END; //
delimiter ;

CALL update_all(5, 'mouse', 'mouse have wire', 200000, 123, 'silver and gold', 'on');
    

