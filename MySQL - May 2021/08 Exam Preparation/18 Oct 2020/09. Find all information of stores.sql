select reverse(s.name) as reversed_name, concat_ws("-", upper(t.name), a.name) as full_address, count(e.id) as employees_count
from stores s
join addresses a on a.id = s.address_id
join towns t on t.id = a.town_id
join employees e on e.store_id = s.id
group by s.name
having employees_count >= 1
-- only > 1 employee
order by full_address;