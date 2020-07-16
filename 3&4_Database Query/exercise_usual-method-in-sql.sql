CREATE DATABASE student_management;
USE student_management;
CREATE TABLE student(
	id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(20),
    age INT,
    course VARCHAR(20),
	course_fee INT
    );
    
    INSERT INTO student(`name`, age, course, course_fee)
    VALUES
    ('Hoang', 21, 'CNTT', 400000),
    ('Viet', 19, 'DTVT', 320000),
    ('Huong', 18, 'KTDN', 600000),
    ('Nhan', 19, 'CK', 450000),
    ('Huong', 22, 'TCNH', 500000),
    ('Hong', 20, 'CNSH', 200000);
    
    DROP DATABASE student_management;
    
    -- Viết câu lệnh hiện thị tất cả các dòng có tên là Huong
    SELECT * FROM student
		WHERE `name` = 'Huong';
	/*	
		3	Huong	18	KTDN	600000
		5	Huong	22	TCNH	500000 
	*/
    
    -- Viết câu lệnh lấy ra tổng số tiền của Huong
    
    SELECT 
    name, SUM(course_fee)
FROM
    student
WHERE
    `name` = 'Huong'
GROUP BY `name`;
    /*
    kết quả: Huong    1100000
    */
    
    -- Viết câu lệnh lấy ra tên danh sách của tất cả học viên, không trùng lặp
    SELECT DISTINCT `name`
    FROM student;
    
    select name, age, course from student
	group by `name`;


				