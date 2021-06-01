select name from towns
where length(name) in (5,6)
order by name asc;