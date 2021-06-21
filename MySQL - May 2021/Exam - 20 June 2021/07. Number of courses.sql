-- select c.id, c.make, c.mileage, count(cs.id) as count_of_courses, round(avg(bill),2) as avg_bill from cars c
-- right join courses cs on cs.car_id = c.id
-- group by c.id
-- having count_of_courses != 2
-- order by count_of_courses desc, c.id

select c.id, c.make, c.mileage, count(cs.id) as count_of_courses, round(avg(bill),2) as avg_bill from courses cs 
right join cars c on c.id = cs.car_id
group by c.id
having count_of_courses != 2
order by count_of_courses desc, c.id