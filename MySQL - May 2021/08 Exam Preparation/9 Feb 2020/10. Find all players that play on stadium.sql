 delimiter ##

CREATE FUNCTION `udf_stadium_players_count` (stadium_name varchar(30))
RETURNS INTEGER
DETERMINISTIC
BEGIN
	
RETURN (select count(*) as count from players p 
	join teams t on t.id = p.team_id
	join stadiums s on s.id = t.stadium_id
	where s.name = stadium_name);
END ##


select udf_stadium_players_count('Jaxworks');