drop database if exists iNotes;
create database iNotes;
use iNotes;
create table note_type(
id_type int(11) primary key auto_increment,
`name` varchar(100),
`description` varchar(200)
);

INSERT INTO `inotes`.`note_type` (`name`, `description`) VALUES ('Cá nhân', 'abc');
INSERT INTO `inotes`.`note_type` (`name`, `description`) VALUES ('Công ty', 'def');

create table note(
id int(11) primary key auto_increment,
title varchar(100),
content varchar(500),
id_type int(11),
foreign key (id_type) references note_type(id_type)
);

INSERT INTO `inotes`.`note` (`title`, `content`, `id_type`) VALUES ('Sửa quạt', 'Mang quạt đi sửa ở Điện Biên Phủ', '1');
INSERT INTO `inotes`.`note` (`title`, `content`, `id_type`) VALUES ('Mua Tivi', 'Mua Tivi Vsmart 55 inch', '2');
INSERT INTO `inotes`.`note` (`title`, `content`, `id_type`) VALUES ('Báo cáo tuần', 'Viết báo cáo và lập kế hoạch tuần tới', '1');


select id_type, `name`, `description` 
from note_type;

select id, title, content, id_type
from note;

