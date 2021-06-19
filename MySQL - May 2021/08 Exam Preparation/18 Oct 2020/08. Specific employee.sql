select concat_ws(" ", e.first_name, e.last_name) as Full_name, s.name as Store_name, a.name as address, e.salary
from employees e
join stores s on s.id = e.store_id
join addresses a on a.id = s.address_id
where e.salary < 4000
and a.name like '%5%'
and length(s.name) > 8
and right(e.last_name, 1) = 'n' 
