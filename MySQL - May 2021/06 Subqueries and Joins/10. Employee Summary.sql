select e.employee_id, concat_ws(" ", e.first_name, e.last_name) as employee_name, (select concat_ws(" ", first_name, last_name) from employees t2 where t2.employee_id = e.manager_id) as manager_name, d.name
from employees e
join departments d on d.department_id = e.department_id
where e.manager_id is not null
order by e.employee_id
limit 5;