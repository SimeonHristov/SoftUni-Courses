select s.name , count(p.id) as product_count, round(avg(p.price),2) as avg
from stores s 
left join products_stores ps on ps.store_id = s.id
left join products p on p.id = ps.product_id
group by s.name
order by product_count desc, avg desc, s.id;

