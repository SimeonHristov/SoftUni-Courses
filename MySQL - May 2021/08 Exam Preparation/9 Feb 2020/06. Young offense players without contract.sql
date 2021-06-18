SELECT  p.id, concat_ws(" ", p.first_name, p.last_name), p.age, p.position, p.hire_date 
FROM players p 
join skills_data s on s.id = p.skills_data_id
where p.hire_date is null
and p.position = 'a'
and p.age < 23
and s.strength > 50
order by p.salary asc, age;