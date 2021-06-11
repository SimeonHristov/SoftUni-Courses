select c.country_code, count(m.mountain_range) as mountain_range
from countries c
join mountains_countries mc on mc.country_code = c.country_code
join mountains m on m.id = mc.mountain_id
where (c.country_code =  'bg' or c.country_code =  'ru' or c.country_code =  'us') 
group by c.country_code
order by mountain_range desc;

