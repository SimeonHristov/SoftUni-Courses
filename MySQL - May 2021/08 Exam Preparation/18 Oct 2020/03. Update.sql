SET FOREIGN_KEY_CHECKS = 0; 

update employees
set manager_id = 3 and salary = salary - 500
where YEAR(hire_date) > 2003
and store_id not in (5, 14);
SET FOREIGN_KEY_CHECKS = 1; 
