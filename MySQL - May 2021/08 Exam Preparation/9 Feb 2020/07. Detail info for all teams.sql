select t.`name`, t.established, t.fan_base, (select count(id) from players p where p.team_id = t.id) as players_count
from teams t
order by players_count desc, t.fan_base desc;
