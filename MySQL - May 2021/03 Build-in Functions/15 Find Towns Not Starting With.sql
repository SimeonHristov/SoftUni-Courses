select town_id, name from towns 
where (LOWER(name) not like 'b%' and LOWER(name) not like 'r%' and LOWER(name) not like 'd%')
order by name asc;