delimiter $$

CREATE PROCEDURE `usp_get_employees_salary_above` (input decimal(10,4))
BEGIN
	select first_name, last_name from employees
    where salary >= input
    order by first_name, last_name, employee_id;
END $$
