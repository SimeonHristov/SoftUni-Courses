CREATE TABLE mountains(
	id int primary key auto_increment not null,
	name VARCHAR(30) not null
);

CREATE TABLE peaks(
	id int primary key auto_increment not null,
	name VARCHAR(30) not null,
    mountain_id int,
	CONSTRAINT fk_mountain_id 
    foreign key (mountain_id)
    REFERENCES mountains(id)
);