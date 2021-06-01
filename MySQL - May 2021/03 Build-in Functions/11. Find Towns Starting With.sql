select town_id, name from towns 
where (LOWER(name) like 'm%' or  LOWER(name) like 'k%' or LOWER(name) like 'b%' or LOWER(name) like 'e%')
order by name asc;