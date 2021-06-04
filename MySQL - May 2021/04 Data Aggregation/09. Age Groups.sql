select 
(
CASE 
	when age between 0 and 10 then '[0-10]'
    when age between 11 and 20 then '[11-20]'
    when age between 21 and 30 then '[21-30]'
    when age between 31 and 40 then '[31-40]'
    when age between 41 and 50 then '[41-50]'
    when age between 51 and 60 then '[51-60]'
    when age >= 61 then '[61+]'
END
) as age_group, COUNT(id) as wizard_count
from wizzard_deposits
group by age_group
order by age_group;

