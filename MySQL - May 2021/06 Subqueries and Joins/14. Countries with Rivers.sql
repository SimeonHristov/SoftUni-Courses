select c.country_name, r.river_name
from countries c
left join countries_rivers cr on cr.country_code = c.country_code
left join rivers r on r.id = cr.river_id
where c.continent_code = 'AF'
order by c.country_name
limit 5;