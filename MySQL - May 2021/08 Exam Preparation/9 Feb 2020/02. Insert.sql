insert into coaches (first_name, last_name, salary, coach_level)
select first_name, last_name, salary * 2, length(first_name) from players
where players.age > 44