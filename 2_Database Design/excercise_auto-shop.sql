CREATE DATABASE auto_shop;
USE auto_shop;
CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(50) NOT NULL,
    address_line1 VARCHAR(50) NOT NULL,
    address_line2 VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    postal_code VARCHAR(15) NOT NULL,
    country VARCHAR(50) NOT NULL,
    credit_limit FLOAT
);

CREATE TABLE productlines (
	id VARCHAR(50) PRIMARY KEY,
    text_description TEXT NOT NULL,
    image VARCHAR(255) NOT NULL
    );
    
       CREATE TABLE offices(
	id VARCHAR(10) PRIMARY KEY,
    city VARCHAR(50) NOT NULL,
    phone_number VARCHAR(50) NOT NULL,
    address_line1 VARCHAR(50) NOT NULL,
    address_line2 VARCHAR(50) NOT NULL,
	state VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    postal_code VARCHAR(15) NOT NULL
    ); 

CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_date DATE NOT NULL,
    require_date DATE NOT NULL,
    shipped_date DATE,
    `status` VARCHAR(15),
    comments TEXT,
    quantity_ordered INT NOT NULL,
    price_each FLOAT NOT NULL,
    
    customer_id INT,
    FOREIGN KEY(customer_id) REFERENCES customers(id)
);
    

CREATE TABLE products(
	id VARCHAR(15) PRIMARY KEY,
    product_name VARCHAR(70) NOT NULL,
    product_scale VARCHAR(10) NOT NULL,
    product_vendor VARCHAR(50) NOT NULL,
    product_description TEXT NOT NULL,
    quantity_stock INT NOT NULL,
    buy_price FLOAT NOT NULL,
    msrp FLOAT NOT NULL, -- gía bán lẻ
    
    productline_id varchar(50),
    FOREIGN KEY(productline_id) REFERENCES productlines(id)
    );
    
CREATE TABLE order_details(
	id INT PRIMARY KEY AUTO_INCREMENT,
    product_id varchar(15),
    order_id INT,
    
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (order_id) REFERENCES orders(id)
    );
    
CREATE TABLE employees(
	id INT PRIMARY KEY AUTO_INCREMENT,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    job_title VARCHAR(50) NOT NULL,
    
    report_to INT,
    office_id VARCHAR(10),
    FOREIGN KEY (report_to) REFERENCES employees(id),
    FOREIGN KEY (office_id) REFERENCES offices(id)
    );
    
    CREATE TABLE payments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    check_number VARCHAR(50) NOT NULL,
    payment_day DATE NOT NULL,
    amount FLOAT NOT NULL,
    
	customer_id INT,
    employee_id INT,
    FOREIGN KEY(customer_id) REFERENCES customers(id),
    FOREIGN KEY(employee_id) REFERENCES employees(id)
);

-- drop database auto_shop;
    

 
 
