create database test;
use test;
create table note_type(
id Int primary key auto_increment,
`name` varchar(100)
);
create table note(
id Int primary key auto_increment,
title varchar(100),
content varchar(500),
type_id int,
delete_note int default 0,
foreign key (type_id) references note_type(id) on delete cascade
);
DELIMITER //
create procedure search_by_title(v_title varchar(50))
begin
select *
from note
where title like concat('%', v_title, '%');
end
//DELIMITER ;