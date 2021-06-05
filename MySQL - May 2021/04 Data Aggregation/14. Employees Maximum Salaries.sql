select department_id, max(salary) as max_salary
from employees
group by department_id
having max_salary < 30000 or max_salary > 70000
order by department_id asc;