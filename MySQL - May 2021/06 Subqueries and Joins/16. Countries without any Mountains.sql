SELECT *, count(c.country_code)
from countries c
left join mountains_countries mc on mc.country_code = c.country_code
 where mc.mountain_id is null
