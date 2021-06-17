create schema football_scout_database;
use football_scout_database;

create table skills_data (
	id int primary key auto_increment,
    dribbling int default 0,
    pace int default 0,
    passing int default 0,
    shooting int default 0,
    speed int default 0,
    strength int default 0
);

create table countries (
	id int primary key auto_increment,
    name varchar(45) not null
);

create table towns (
	id int primary key auto_increment,
    name varchar(45)  not null,
    country_id int not null,
    constraint fk_towns_countries
    foreign key (country_id) references countries(id)
);

create table stadiums (
	id int primary key auto_increment,
    name varchar(45) not null,
    capacity int not null,
    town_id int not null,
    constraint fk_stadiums_towns
    foreign key (town_id) references towns(id)
); 



create table teams (
	id int primary key auto_increment,
    name varchar(45) not null,
    established DATE not null,
    fan_base  bigint not null default 0,
    stadium_id int not null,
    constraint fk_teams_stadiums
    foreign key (stadium_id) references stadiums(id)
);


create table players (
	id int primary key auto_increment,
    first_name varchar(10) not null,
    last_name varchar(20) not null,
    age int not null default 0,
    position char(1) not null,
    salary decimal(10,2) not null default 0,
    hire_date DATETIME,
    skills_data_id int not null,
    team_id int not null,
    constraint fk_players_skills
    foreign key (skills_data_id) references skills_data(id),
    constraint fk_players_teams
    foreign key (team_id) references teams(id)
);

create table coaches (
	id int primary key auto_increment,
	first_name varchar(10) not null,
    last_name varchar(20) not null,
    salary decimal(10,2) not null default 0,
    coach_level int not null default 0
);

create table players_coaches(
	player_id INT,
	coach_id INT,
	
    CONSTRAINT pk_players_coaches
	PRIMARY KEY (player_id, coach_id),
	
    CONSTRAINT fk_players_coaches_players
	FOREIGN KEY (player_id)
	REFERENCES players(id),
	
    CONSTRAINT fk_players_coaches_coaches
	FOREIGN KEY (coach_id)
	REFERENCES coaches(id)
);









