create table clients (
id int primary key auto_increment not null,
client_name varchar (100) not null
);

create table employees (
id int primary key auto_increment not null,
first_name varchar (30) not null,
last_name varchar (30) not null,
project_id int
);

create table projects (
id int primary key auto_increment not null,
client_id int ,
project_lead_id int,
constraint fk_client_project
foreign key (client_id) REFERENCES clients(id),
constraint fk_project_employee
foreign key (project_lead_id) REFERENCES employees(project_id)
);