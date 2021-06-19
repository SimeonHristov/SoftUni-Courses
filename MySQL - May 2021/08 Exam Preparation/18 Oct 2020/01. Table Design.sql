create schema softuni_stores_system;
use softuni_stores_system;

create table pictures (
	id int primary key auto_increment,
    url varchar(100) not null,
    added_on DATETIME not null
);

create table categories (
	id int primary key auto_increment,
    name varchar(40) not null
);

create table products (
	id int primary key auto_increment,
    name varchar(40)  not null,
    best_before DATE,
    price decimal (10,2) not null,
    description text,
    category_id int not null,
    picture_id int not null,
    constraint fk_products_categories
    foreign key (category_id) references categories(id),
    constraint fk_products_pictures
    foreign key (picture_id) references pictures(id)
);

create table towns (
	id int primary key auto_increment,
    name varchar(20) unique not null
);

create table addresses (
	id int primary key auto_increment,
    name varchar(50) unique not null,
    town_id int not null,
    constraint fk_addresses_towns
    foreign key (town_id) references towns(id)
);

create table stores (
	id int primary key auto_increment,
    name varchar(20) unique not null,
    rating float not null,
    has_parking boolean default 0,
    address_id int not null,
    constraint fk_stores_addresses
    foreign key (address_id) references addresses(id)
);

create table products_stores(
	product_id INT not null,
	store_id INT not null,
	
    CONSTRAINT pk_products_stores
	PRIMARY KEY (product_id, store_id),
	
    CONSTRAINT fk_products_stores_products
	FOREIGN KEY (product_id)
	REFERENCES products(id),
	
    CONSTRAINT fk_products_stores_stores
	FOREIGN KEY (store_id)
	REFERENCES stores(id)
);

create table employees (
	id int primary key auto_increment,
    first_name varchar(15)  not null,
    middle_name char(1),
    last_name varchar(20)  not null,
    salary decimal (19,2) not null default 0,
    hire_date DATE not null,
    manager_id int,
    store_id int not null,
    constraint fk_employees_managers
    foreign key (manager_id) references employees(id),
    constraint fk_employees_stores
    foreign key (store_id) references stores(id)
);







