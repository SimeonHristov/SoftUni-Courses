delimiter $$
CREATE FUNCTION `ufn_get_salary_level` (emp_salary decimal (10,2))
RETURNS varchar (20)
DETERMINISTIC
BEGIN

RETURN CASE 
		when emp_salary < 30000 then 'Low'
        when emp_salary <= 50000 then 'Average' 
        else 'High'
	END;
END$$


call ufn_get_salary_level (925500.00);

	