delete from employees e
where e.id not in (select employee_id from employees_clients);