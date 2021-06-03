select 
product_name,
order_date,
date_add(order_date, INTERVAL 3 DAY) as pay_due,
date_add(order_date, INTERVAL 1 MONTH) as deliver_due
from orders;