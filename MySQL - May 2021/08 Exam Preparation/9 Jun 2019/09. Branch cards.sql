SELECT b.name , count(c.id) as count_of_cards FROM branches b
left join employees e on e.branch_id = b.id
left join employees_clients ec on ec.employee_id = e.id
left join clients cs on cs.id = ec.client_id
left join bank_accounts ba on ba.client_id = cs.id
left join cards c on c.bank_account_id = ba.id
group by b.id
order by count_of_cards  desc, b.name;