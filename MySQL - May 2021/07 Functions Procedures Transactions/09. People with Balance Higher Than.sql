DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(balance DECIMAL(19, 4))
BEGIN
   select a.first_name, a.last_name 
   from account_holders a
   join (select b.id, b.account_holder_id, sum(b.balance) as total_balance
   from accounts b
   group by b.account_holder_id
   having total_balance > balance) as c on c.account_holder_id = a.id
   order by a.id;

END $$
DELIMITER ;

CALL usp_get_holders_with_balance_higher_than(7000);



