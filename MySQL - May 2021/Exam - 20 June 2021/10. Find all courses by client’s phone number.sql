delimiter ##

CREATE FUNCTION `udf_courses_by_client` (phone_num VARCHAR (20))
RETURNS INTEGER
DETERMINISTIC
BEGIN
		
RETURN 

(select count(cs.id) as count from clients c
join courses cs on cs.client_id = c.id
where c.phone_number = phone_num
group by c.id);

END ##

select udf_courses_by_client('(831) 1391236');

