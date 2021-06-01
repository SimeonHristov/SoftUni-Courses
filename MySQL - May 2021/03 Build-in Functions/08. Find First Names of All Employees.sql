select first_name from employees
where department_id in (3,10)
and YEAR(hire_date) between 1995 AND 2005
order by employee_id asc;