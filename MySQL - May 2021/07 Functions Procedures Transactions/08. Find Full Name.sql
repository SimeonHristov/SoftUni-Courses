delimiter ##
CREATE PROCEDURE `usp_get_holders_full_name` ()
BEGIN	
	select concat_ws(" ", first_name, last_name) as full_name from employees
    order by full_name, employee_id;
END##
