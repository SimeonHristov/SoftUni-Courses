CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(20,4))
BEGIN 
   UPDATE  accounts as a
   JOIN `account_holders` as ah ON a.`account_holder_id` = ah.id
   SET a.balance = if((money_amount>0 and a.balance >= money_amount), ROUND(a.balance - money_amount,4), a.balance)
   WHERE a.id = account_id;
   END;