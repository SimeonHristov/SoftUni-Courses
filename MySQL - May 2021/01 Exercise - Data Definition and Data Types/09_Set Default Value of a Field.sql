-- 9. Set Default Value of a Field

ALTER TABLE `users` 
CHANGE COLUMN `last_login_time` `last_login_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ;
