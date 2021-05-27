

CREATE TABLE `users` (
`id` INT UNIQUE PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time`TIMESTAMP,
`is_deleted` BOOLEAN
);


INSERT INTO `users`
VALUES
(1, 'Pesho1', 'pass1', NULL, current_timestamp(), false),
(2, 'Pesho2', 'pass2', NULL, current_timestamp(), false),
(3, 'Pesho3', 'pass3', NULL, current_timestamp(), false),
(4, 'Pesho4', 'pass4', NULL, current_timestamp(), false),
(5, 'Pesho5', 'pass5', NULL, current_timestamp(), false);