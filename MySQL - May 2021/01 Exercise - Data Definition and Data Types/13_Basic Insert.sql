CREATE TABLE `towns` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (50) NOT NULL
);

CREATE TABLE `addresses` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`address_text` TEXT,
`town_id` INT NOT NULL,
CONSTRAINT fk_addresses_towns
FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`)
);

CREATE TABLE `departments` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (50) NOT NULL
);


CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR (50) NOT NULL,
`middle_name` VARCHAR (50),
`last_name` VARCHAR (50) NOT NULL,
`job_title` VARCHAR (50) NOT NULL,
`department_id` INT NOT NULL,
`hire_date` DATE, 
`salary` DECIMAL,
`address_id` INT NOT NULL,
CONSTRAINT fk_employees_departments
FOREIGN KEY (`department_id`) REFERENCES `departments`(`id`),
CONSTRAINT fk_employees_addresses
FOREIGN KEY (`address_id`) REFERENCES `addresses`(`id`)
);

INSERT INTO `towns` VALUES 
(1, 'Sofia'),(2, 'Plovdiv'),(3, 'Varna'),(4, 'Burgas');

INSERT INTO `departments` VALUES 
(1, 'Engineering'),(2, 'Sales'),(3, 'Marketing'),(4, 'Software Development'), (5, 'Quality Assurance');

INSERT INTO `employees` VALUES 
(1, 'Ivan ', 'Ivanov', 'Ivanov', '.Net Developer', 4, '2013-02-01 ', 3500.00, NULL),
(2, 'Petar ', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2014-03-02 ', 4000.00, NULL),
(3, 'Maria ', 'Petrova', 'Ivanova' , 'Intern', 5, '2016-08-28 ', 525.25, NULL),
(4, 'Georgi ', 'Terziev', 'Ivanov', 'CEO', 2, '2017-12-09 ', 3000.00, NULL),
(5, 'Peter ', 'Pan', 'Pan', 'Intern', 3, '2016-08-28 ', 599.88, NULL);

