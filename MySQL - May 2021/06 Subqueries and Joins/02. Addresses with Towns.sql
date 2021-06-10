select e.first_name, e.last_name, t.name, a.address_text 
from employees e
left join addresses a on a.address_id = e.address_id
left join towns t on t.town_id = a.town_id
order by e.first_name, e.last_name
limit 5;