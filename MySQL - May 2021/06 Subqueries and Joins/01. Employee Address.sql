select e.employee_id, e.job_title, e.address_id, a.address_text 
from employees e
left join addresses a on a.address_id = e.address_id
order by e.address_id
limit 5;