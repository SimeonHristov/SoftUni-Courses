delimiter ##

CREATE PROCEDURE `udp_find_playmaker` (min_dribble_points  int, team_name varchar (45))
BEGIN
	select concat_ws(" ", first_name, last_name) as full_name, p.age, p.salary, s.dribbling, s.speed, t.name
    from players p
    join skills_data s on s.id = p.skills_data_id
    join teams t on t.id = p.team_id
    where t.name = team_name 
    and s.dribbling >=  min_dribble_points
    order by s.speed desc
    limit 1;
END ##


call udp_find_playmaker (20, 'Skyble');

