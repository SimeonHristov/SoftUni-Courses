delimiter ##
 CREATE PROCEDURE `udp_clientinfo` (full_name varchar(30))
 BEGIN
		select c.full_name, c.age, b.account_number, concat('$',balance) from clients c
    left join bank_accounts b on b.client_id = c.id
    where c.full_name = full_name;
 END ##


call udp_clientinfo('hunter wesgate');