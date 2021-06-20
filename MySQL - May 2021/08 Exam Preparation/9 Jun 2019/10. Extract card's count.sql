delimiter ##

CREATE FUNCTION `udf_client_cards_count` (name VARCHAR(30)) 
RETURNS INTEGER
DETERMINISTIC
BEGIN

RETURN 
 		(SELECT count(c.id) as cards FROM clients cs 
		left join bank_accounts ba on ba.client_id = cs.id
		left join cards c on c.bank_account_id = ba.id
        where cs.full_name = name
		group by cs.id);
	
 END ##

select udf_client_cards_count('Baxy David');