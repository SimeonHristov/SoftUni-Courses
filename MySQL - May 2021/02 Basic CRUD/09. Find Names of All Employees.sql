select CONCAT(`first_name`," ",`middle_name`," ",`last_name`) as 'Full Name'from employees
where salary in (12500, 14000, 23600, 25000);

