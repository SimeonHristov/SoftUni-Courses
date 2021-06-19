delimiter ##

CREATE FUNCTION `udf_top_paid_employee_by_store` (store_name varchar (50))
RETURNS varchar(100)
 
BEGIN
-- 	   declare full_name varchar(50);
--     declare xp int;
--     declare full_info varchar(100);
--     
--     set full_name := (select concat(e.first_name, " ", e.middle_name, ".  ", e.last_name) 
-- 					from employees e
--                     join stores s on s.id = e.store_id
-- 					where s.name = store_name
-- 					order by salary desc 
-- 					limit 1);
-- 	set xp := (SELECT TIMESTAMPDIFF(YEAR, hire_date, CURDATE()) AS difference 
-- 				from employees 
-- 				where (select concat(first_name, " ", middle_name, ". ", last_name) 
-- 				from employees) = full_name;
--                     
--     set full_info := concat(full_name, " ", "works in the store for",  " years");
    
RETURN (select concat(e.first_name, ' ', e.middle_name, '. ', e.last_name, ' works in store for ', 2020 - year(hire_date), ' years')
			from employees e
            join stores s on s.id = e.store_id
            where s.name = store_name
            order by e.salary desc 
            limit 1);
END ##


 select udf_top_paid_employee_by_store('Stronghold') as full_info;


