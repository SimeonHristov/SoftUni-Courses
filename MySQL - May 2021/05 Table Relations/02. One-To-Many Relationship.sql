create table manufacturers (
manufacturer_id int primary key auto_increment not null,
name varchar (30),
established_on date
);

create table models (
model_id int primary key auto_increment not null,
name varchar (30),
manufacturer_id int,
constraint fk_models_manufacturers
foreign key (manufacturer_id)
references manufacturers(manufacturer_id)
);

insert into manufacturers
values
(1,'BMW', '1916/03/01'),
(2,'Tesla','2003/01/01'),
(3,'Lada','1966/05/01');

insert into models
values
(101,'X1',1),
(102,'i6',1),
(103,'Model S',2),
(104,'Model X',2),
(105,'Model 3',2),
(106,'Nova',3);