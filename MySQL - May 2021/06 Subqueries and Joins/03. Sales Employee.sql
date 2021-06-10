select e.employee_id, e.first_name, e.last_name, d.name
from employees e
left join departments d on d.department_id = e.department_id
where d.name = 'Sales'
order by e.employee_id desc;


-- select * from departments;