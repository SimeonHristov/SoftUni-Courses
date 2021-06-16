delimiter ##
CREATE PROCEDURE `usp_get_employees_by_salary_level` (level_salary varchar(10))
BEGIN
	select first_name, last_name 
    from employees
	where 
    (case 
    when level_salary = 'low' then 
    salary BETWEEN 0 and 29999 
    
    when level_salary = 'average' then   
    salary BETWEEN 30000 and 50000 
 
    when level_salary = 'high' then 
    salary > 50000
	END)
    order by first_name desc, last_name desc; 
END##


