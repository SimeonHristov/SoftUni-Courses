
CREATE TABLE `directors` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR (50) NOT NULL,
`notes` TEXT
);

CREATE TABLE `genres` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR (50) NOT NULL,
`notes` TEXT
);

CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR (50) NOT NULL,
`notes` TEXT
);

CREATE TABLE `movies` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR (50) NOT NULL,
`director_id` INT,
`copyright_year` DATE,
`lenght` TIMESTAMP,
`genre_id` INT,
`category_id` INT,
`rating` FLOAT (2,1),
`notes` TEXT
);

INSERT INTO `directors`
VALUES
(1, 'd1', NULL),
(2, 'd2', NULL),
(3, 'd3', NULL),
(4, 'd4', NULL),
(5, 'd5', NULL);

INSERT INTO `genres`
VALUES
(1, 'g1', NULL),
(2, 'g2', NULL),
(3, 'g3', NULL),
(4, 'g4', NULL),
(5, 'g5', NULL);

INSERT INTO `categories`
VALUES
(1, 'c1', NULL),
(2, 'c2', NULL),
(3, 'c3', NULL),
(4, 'c4', NULL),
(5, 'c5', NULL);

INSERT INTO `movies`
VALUES
(1, 'm1', 5, '2020-12-01', NULL, 5, 1, 9.5, NULL),
(2, 'm1', 4, '2020-12-01', NULL, 4, 2, 7.5, NULL),
(3, 'm1', 3, '2020-12-01', NULL, 3, 3, 6.5, NULL),
(4, 'm1', 2, '2020-12-01', NULL, 2, 4, 5.5, NULL),
(5, 'm1', 1, '2020-12-01', NULL, 1, 5, 4.5, NULL);

