delete from employees e
where e.salary >= 6000
and e.manager_id is not null;