select c.country_code, m.mountain_range, p.peak_name, p.elevation
from countries c
join mountains_countries mc on mc.country_code = c.country_code
join mountains m on m.id = mc.mountain_id
join peaks p on p.mountain_id = m.id
where c.country_code = 'BG'
and p.elevation > 2835
order by p.elevation desc;