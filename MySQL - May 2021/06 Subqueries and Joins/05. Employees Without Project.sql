select e.employee_id, e.first_name 
from employees e
left join employees_projects ep on ep.employee_id = e.employee_id
left join projects p on p.project_id = ep.project_id
-- where e.employee_id != ep.employee_id;
where p.project_id is null
order by e.employee_id desc
limit 3;