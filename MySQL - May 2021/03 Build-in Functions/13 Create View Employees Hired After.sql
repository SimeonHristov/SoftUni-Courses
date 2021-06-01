create view v_employees_hired_after_2000 as
select first_name, last_name 
from employees
where year(hire_date) > 2000;