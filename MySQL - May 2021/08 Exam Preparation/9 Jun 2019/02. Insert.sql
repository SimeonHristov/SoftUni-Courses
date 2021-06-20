insert into cards (card_number, card_status, bank_account_id)
SELECT reverse(c.full_name), 'Active', c.id
FROM clients c
where c.id between 191 and 200
