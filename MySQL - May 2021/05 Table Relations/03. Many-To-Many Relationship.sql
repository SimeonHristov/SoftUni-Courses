create table students (
student_id int primary key auto_increment not null,
name varchar (30) not null
);

insert into students (name) VALUES
('Mila'),
('Toni'),
('Ron');

create table exams (
exam_id int primary key auto_increment not null,
name varchar (30) not null
);

alter table exams auto_increment = 101;

insert into exams (name) VALUES
('Spring MVC'),
('Neo4j'),
('Oracle 11g');

create table students_exams (
	student_id int,
    exam_id int,
    constraint pk_students_exams
    primary key (student_id, exam_id),
    constraint pk_students_exams_students
    foreign key (student_id)
    references students(student_id),
    constraint pk_students_exams_exams
    foreign key (exam_id)
    references exams(exam_id)
);

insert into students_exams
values
(1,101),
(1,102),
(2,101),
(3,103),
(2,102),
(2,103);
