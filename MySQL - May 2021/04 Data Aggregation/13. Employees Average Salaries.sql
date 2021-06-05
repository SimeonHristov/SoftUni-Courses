CREATE table emp_new (
select * from employees 
where salary > 30000
);

delete from emp_new 
where manager_id = 42;

update emp_new 
set salary = salary + 5000
where department_id = 1;

select department_id, avg(salary) as avg_salary
from emp_new
group by department_id
order by department_id;