select concat_ws(' ', e.first_name, e.last_name) as name, e.started_on, count(ec.client_id) as count_of_clients
from employees e
join employees_clients ec on ec.employee_id = e.id
group by e.id
order by count_of_clients desc, e.id
limit 5;