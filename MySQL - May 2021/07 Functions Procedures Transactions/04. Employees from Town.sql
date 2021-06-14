delimiter $$

CREATE PROCEDURE `usp_get_employees_from_town` (town_name varchar(20))
BEGIN
	select e.first_name, e.last_name from employees e
    left join addresses a on a.address_id = e.address_id
    left join towns t on t.town_id = a.town_id
    where t.name = town_name
    order by e.first_name, e.last_name, e.employee_id;
END $$

	