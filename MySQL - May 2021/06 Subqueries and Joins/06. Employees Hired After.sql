select  e.first_name, e.last_name, e.hire_date, d.name
from employees e
left join departments d on d.department_id = e.department_id
where e.hire_date > '1999/01/01'
and (d.name = 'Sales' or d.name = 'Finance')
order by e.hire_date;