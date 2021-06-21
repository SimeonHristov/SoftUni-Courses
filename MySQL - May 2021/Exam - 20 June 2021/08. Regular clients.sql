select c.full_name, count(car_id) as count_of_cars, sum(bill) as total_sum from clients c
join courses cs on cs.client_id = c.id
where left(c.full_name,2) like  '%a'
group by c.id
having count_of_cars > 1
order by c.full_name


