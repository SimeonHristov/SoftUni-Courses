select replace(title, 'The', '***') as newtitle 
from books
where title like 'The%'
order by id asc;

