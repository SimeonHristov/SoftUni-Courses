select t1.department_id, 
(
select distinct salary
 from employees t2
where t2.department_id = t1.department_id
order by salary desc
limit 1 offset 2
) as third_highest_salary 
from employees t1
group by t1.department_id
having third_highest_salary is not null
order by department_id;


