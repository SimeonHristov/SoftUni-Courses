CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category` VARCHAR (50) NOT NULL,
`daily_rate` FLOAT (5, 2),
`weekly_rate` FLOAT (5, 2),
`monthly_rate` FLOAT (5, 2),
`weekend_rate` FLOAT (5,2)
);

CREATE TABLE `cars` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`plate_number` VARCHAR (10) NOT NULL,
`make` VARCHAR (30) NOT NULL,
`model` VARCHAR (30) NOT NULL,
`car_year` DATE,
`category_id` INT,
`doors` INT,
`picture` BLOB,
`car_condition` TEXT,
`available` BOOLEAN
);

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR (25) NOT NULL,
`last_name` VARCHAR (25) NOT NULL,
`title` CHAR (3),
`notes` TEXT
);

CREATE TABLE `customers` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`driver_license_number` INT NOT NULL,
`full_name` VARCHAR (25) NOT NULL,
`address` VARCHAR (30),
`city` VARCHAR (30),
`zip_code` VARCHAR (10),
`notes` TEXT
);

CREATE TABLE `rental_orders` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`employee_id` INT NOT NULL,
`customer_id` INT NOT NULL,
`car_id` INT NOT NULL,
`car_condition` TEXT,
`tank_level` INT,
`kilometrage_start` INT,
`kilometrage_end` INT,
`total_kilometrage` INT,
`start_date` DATE,
`end_date` DATE,
`total_days` INT,
`rate_applied` FLOAT,
`tax_rate` FLOAT,
`order_status` VARCHAR (10),
`notes` TEXT
);


INSERT INTO `categories` VALUES
(1, 'c1', 2, 5, 25, 3),
(2, 'c2', 2, 5, 25, 3),
(3, 'c3', 2, 5, 25, 3);

INSERT INTO `cars` VALUES
(1, 'qwe', 'make', 'model', '2020-12-01', 1, 4, NULL, NULL, true),
(2, 'qwe', 'make', 'model', '2020-12-01', 1, 4, NULL, NULL, true),
(3, 'qwe', 'make', 'model', '2020-12-01', 1, 4, NULL, NULL, true);

INSERT INTO `employees` VALUES
(1, 'fn', 'ln', 'mr', NULL),
(2, 'fn', 'ln', 'mr', NULL),
(3, 'fn', 'ln', 'mr', NULL);

INSERT INTO `customers` VALUES
(1, 12341, 'fullname', 'address', 'city', 'zipcode', 'notes'),
(2, 12341, 'fullname', 'address', 'city', 'zipcode', 'notes'),
(3, 12341, 'fullname', 'address', 'city', 'zipcode', 'notes');

INSERT INTO `rental_orders` VALUES
(1, 1, 1, 1, 'good', 5, 123123, 123222, 99, '2020-12-01', '2020-12-02', 1, 4, 0.2, 'completed', NULL),
(2, 1, 1, 1, 'good', 5, 123123, 123222, 99, '2020-12-01', '2020-12-02', 1, 4, 0.2, 'completed', NULL),
(3, 1, 1, 1, 'good', 5, 123123, 123222, 99, '2020-12-01', '2020-12-02', 1, 4, 0.2, 'completed', NULL);