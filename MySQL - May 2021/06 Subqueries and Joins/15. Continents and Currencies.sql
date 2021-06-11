select c.continent_code, c.currency_code, count(country_name) as currency_usage
from countries c
group by c.continent_code, currency_code
having currency_usage = (
select count(currency_code) as count
from countries c2
where c2.continent_code = c.continent_code
group by c2.currency_code
order by count desc
limit 1
) and currency_usage > 1
order by c.continent_code, c.currency_code

