create table majors (
major_id int primary key auto_increment,
name varchar (50)
);

create table students (
student_id int primary key auto_increment,
student_number varchar (12),
student_name varchar (50),
major_id int,
constraint fk_students_majors
foreign key (major_id)
references majors(major_id)
);

create table  payments (
payment_id int primary key auto_increment,
payment_date DATE,
payment_amount decimal (8,2),
student_id int,
constraint fk_payments_students
foreign key (student_id)
references students(student_id)
);

create table subjects (
subject_id int primary key auto_increment,
name varchar (50)
);

create table agenda (
student_id int ,
subject_id int,
constraint pk_agenda
primary key (student_id, subject_id),
constraint fk_agenda_student
foreign key (student_id)
references students(student_id),
constraint fk_agenda_subject
foreign key (subject_id)
references subjects(subject_id)
);
