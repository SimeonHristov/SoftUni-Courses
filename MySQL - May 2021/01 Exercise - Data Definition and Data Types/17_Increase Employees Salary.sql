UPDATE  `employees`
SET `salary` = (`salary` + (`salary`/ 10)) * 1.0
WHERE `id` >= 1;

