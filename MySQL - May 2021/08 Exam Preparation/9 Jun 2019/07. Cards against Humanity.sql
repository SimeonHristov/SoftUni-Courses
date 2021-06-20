select c.id, concat_ws(' : ', c.card_number, cs.full_name) from cards c
join bank_accounts b on b.id = c.bank_account_id
join clients cs on cs.id = b.client_id
order by c.id desc;