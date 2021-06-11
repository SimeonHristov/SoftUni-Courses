select e.employee_id, e.first_name, e.manager_id, (select first_name from employees t2 where t2.employee_id = e.manager_id) as manager_name
from employees e
where e.manager_id in (3,7)
order by e.first_name;