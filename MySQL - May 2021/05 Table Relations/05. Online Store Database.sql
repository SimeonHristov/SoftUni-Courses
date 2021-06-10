create table cities (
city_id int primary key auto_increment,
name varchar(50)
);

create table customers (
-- customer_id int primary key auto_increment not null,
customer_id int primary key auto_increment,
name varchar (50),
birthday DATE,
city_id int,
constraint fk_customers_towns
foreign key (city_id)
references cities(city_id)
);

create table orders (
order_id int primary key auto_increment,
customer_id int,
constraint fk_orders_cust
foreign key (customer_id)
references customers(customer_id)
);

create table item_types (
item_type_id int primary key,
name varchar(50)
);

create table items (
item_id int primary key,
name varchar(50),
item_type_id int,
constraint fk_item_item_types
foreign key (item_type_id)
references item_types(item_type_id)
);

create table order_items (
order_id int,
item_id int,
constraint pk_order_items
primary key (order_id, item_id),
constraint fk_order_items_orders
foreign key (order_id)
references orders(order_id),
constraint fk_order_items_items
foreign key (item_id)
references items(item_id)
);