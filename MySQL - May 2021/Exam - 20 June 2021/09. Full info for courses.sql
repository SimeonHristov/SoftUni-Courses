select a.name, 
(case
	when hour(cs.start) between 06 and 20 then 'Day'
    else 'Night'
end) as day_time
, cs.bill, c.full_name, car.make, car.model, cat.name from courses cs
join clients c on c.id = cs.client_id
join cars car on car.id = cs.car_id
join addresses a on a.id = cs.from_address_id
join categories cat on cat.id = car.category_id
order by cs.id
