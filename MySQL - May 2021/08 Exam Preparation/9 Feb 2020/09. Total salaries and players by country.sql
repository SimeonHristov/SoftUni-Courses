-- select c.name, count(*) as total_count_of_players, sum(salary) as total_sum_of_salaries
-- from players p
-- left join teams t on t.id = p.team_id
-- left join stadiums s on s.id = t.stadium_id
-- left join towns on towns.id = s.town_id
-- left join countries c on c.id = towns.country_id
-- group by c.name
-- order by total_count_of_players desc, c.name;

select c.name, count(p.id) as total_count_of_players, sum(p.salary) as total_sum_of_salaries
from countries c
left join towns tn on tn.country_id = c.id
left join stadiums s on s.town_id = tn.id
left join teams t on t.stadium_id = s.id
left join players p on p.team_id = t.id
group by c.name
order by total_count_of_players desc, c.name;