select deposit_group, is_deposit_expired, AVG(deposit_interest) as average_interest
from wizzard_deposits
where  date(deposit_start_date) > '1985-01-01'
group by deposit_group, is_deposit_expired
order by deposit_group desc, is_deposit_expired asc;