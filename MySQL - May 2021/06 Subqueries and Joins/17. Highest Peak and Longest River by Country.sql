SELECT c.country_name, MAX(p.elevation) as highest_peak_elevation ,MAX(r.length) as longest_rive_length 
from countries c
join mountains_countries mc on mc.country_code = c.country_code
join peaks p on p.mountain_id = mc.mountain_id
join countries_rivers cr on cr.country_code = c.country_code
join rivers r on r.id = cr.river_id
group by c.country_name
order by highest_peak_elevation desc, longest_rive_length desc, c.country_name
limit 5;