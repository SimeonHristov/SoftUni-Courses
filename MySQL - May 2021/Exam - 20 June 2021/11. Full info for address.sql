-- delimiter ##

 CREATE PROCEDURE `udp_courses_by_address` (address_name varchar(100))
 BEGIN
 	select a.name, c.full_name, 
		(case
			when cs.bill <= 20 then 'Low'
			when cs.bill <= 30 then 'Medium'
			else 'High'
		end) as level_of_bill, 
		cars.make, cars.condition ,cats.name from addresses a
		join courses cs on cs.from_address_id = a.id
		join clients c on c.id = cs.client_id
		join cars on cars.id = cs.car_id
		join categories cats on cats.id = cars.category_id
		where a.name = address_name
		order by cars.make, c.full_name;
 END ##



