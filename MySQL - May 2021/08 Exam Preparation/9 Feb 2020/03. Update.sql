UPDATE coaches as c
SET c.coach_level = c.coach_level + 1
WHERE
(SELECT count(coach_id) FROM players_coaches  -- 10
WHERE c.id = coach_id)

>0 AND c.first_name LIKE 'A%';
