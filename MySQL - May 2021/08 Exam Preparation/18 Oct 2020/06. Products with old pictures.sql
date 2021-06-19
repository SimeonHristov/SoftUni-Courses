select p.`name` as product_name, p.price, p.best_before, concat(left(p.description,10),"...") as short_description, z.url 
from products p
left join pictures z on z.id = p.picture_id
where length(p.description) > 100
and year(z.added_on) < 2019
and p.price > 20
order by price desc;