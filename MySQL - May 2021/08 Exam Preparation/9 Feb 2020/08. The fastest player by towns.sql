select MAX(s.speed) as max_speed, too.name as town_name
from players p
 join skills_data s on s.id = p.skills_data_id
 right join teams t on t.id = p.team_id
 join stadiums st on st.id = t.stadium_id
 join towns too on too.id = st.town_id
where t.name != 'devify'
group by too.name
order by max_speed desc, too.name;

-- select * 
-- from players p
-- join skills_data s on s.id = p.skills_data_id
-- join teams t on t.id = p.team_id;