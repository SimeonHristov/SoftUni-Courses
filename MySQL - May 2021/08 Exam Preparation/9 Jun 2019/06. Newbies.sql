select id, concat_ws(' ', first_name, last_name) as full_name, concat('$',salary), started_on
from employees
where salary >= 100000
and started_on >= '2018-01-01' 
order by salary desc, id;