select e.employee_id, e.first_name, e.salary, d.name
from employees e
left join departments d on d.department_id = e.department_id
-- where e.salary > 15000
having salary > 15000
order by e.department_id desc

limit 5;