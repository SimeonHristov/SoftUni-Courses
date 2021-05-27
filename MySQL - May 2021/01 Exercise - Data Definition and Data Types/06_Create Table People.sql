

CREATE TABLE `people` (
`id` INT UNIQUE PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` FLOAT (5,2),
`weight`FLOAT (5,2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT UNICODE
);


INSERT INTO `people`
VALUES
(1, 'Pesho1', NULL, 180, 80,'m', '1984-11-22', 'qwe'),
(2, 'Pesho2', NULL, 180, 80,'m', '1984-11-22', 'qwe'),
(3, 'Pesho3', NULL, 180, 80,'m', '1984-11-22', 'qwe'),
(4, 'Pesho4', NULL, 180, 80,'m', '1984-11-22', 'qwe'),
(5, 'Pesho5', NULL, 180, 80,'m', '1984-11-22', 'qwe');