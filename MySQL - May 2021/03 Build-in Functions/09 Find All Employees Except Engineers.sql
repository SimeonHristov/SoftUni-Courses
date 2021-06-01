select employee_id, first_name, job_title from employees
where job_title not like '%engineer%'
order by employee_id asc;