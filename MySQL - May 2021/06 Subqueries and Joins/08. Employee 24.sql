select e.employee_id, e.first_name, 
(case 
	when YEAR(p.start_date) > 2004 then ''
	else p.name
end) as project_name
from employees e
left join employees_projects ep on e.employee_id = ep.employee_id
left join projects p on ep.project_id = p.project_id
where e.employee_id = 24
order by project_name;
