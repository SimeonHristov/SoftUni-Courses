create table people (
person_id int,
first_name varchar(30),
salary decimal (10,3),
passport_id int
);

create table passports (
passport_id int primary key auto_increment not null,
passport_number varchar(10) unique not null
);

ALTER TABLE `people` 
CHANGE COLUMN `salary` `salary` decimal (10,2),
CHANGE COLUMN `person_id` `person_id` INT auto_increment NOT NULL ,
ADD PRIMARY KEY (`person_id`),
ADD CONSTRAINT fk_people_passports 
foreign key (passport_id)
REFERENCES passports(passport_id);