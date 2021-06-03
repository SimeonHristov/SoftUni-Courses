SELECT name, 
(
	case
		when hour(start) BETWEEN 0 and 11 THEN 'Morning'
        when hour(start) BETWEEN 12 and 17 THEN 'Afternoon'
        when hour(start) BETWEEN 18 and 23 THEN 'Evening'
    end
) as part_of_the_day,
(
case
	when duration is null then 'Extra Long'
    when duration <= 3 then 'Extra Short'
    when duration <= 6 then 'Short'
    when duration <= 10 then 'Long'
    when duration > 10 then 'Extra Long'
end
) as duration
from games;
