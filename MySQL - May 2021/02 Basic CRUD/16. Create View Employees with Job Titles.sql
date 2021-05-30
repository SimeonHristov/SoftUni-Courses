CREATE VIEW v_employees_job_titles AS
select CONCAT (first_name, IFNULL(CONCAT(" ", middle_name), ""), " ", last_name) as 'full_name', job_title 
from employees; 
 