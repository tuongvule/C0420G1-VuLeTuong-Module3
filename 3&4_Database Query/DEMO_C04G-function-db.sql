select *
from instructor i 
	left join instructor_teach_class itc
    on i.id = itc.instructor_id
where instructor_id is null;

select *
from instructor
where id not in (
	select instructor_id
	from instructor_teach_class
);

select *
from instructor
where exists (
	select instructor_id
	from instructor_teach_class
);

select id, name, date_of_birth, 'student' as 'type'
from student
union all
select id, name, date_of_birth, 'instructor' as 'type'
from instructor;

select distinct name
from student;

select name
from student
order by name asc
limit 2;

select c.name, count(s.class_id)
from student s
	right join class c on s.class_id = c.id
-- where count(s.class_id) = 0
group by c.id
having count(s.class_id) = 0;

select *
from student s
	right join class c on s.class_id = c.id
	
