select e.first_name, e.last_name, e.department_id
from employees e
where e.salary > 
(
select avg(e2.salary) 
from employees e2
where e2.department_id = e.department_id
) 
order by e.department_id, e.employee_id
limit 10;
