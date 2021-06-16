CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(10,4), yearly_interest_rate DECIMAL(10,4), number_of_years INT)
RETURNS DECIMAL(10,4)
DETERMINISTIC
BEGIN
    DECLARE result DECIMAL(10,4);
    SET result := sum * (pow((yearly_interest_rate  + 1),  number_of_years));
	RETURN result;
END;


CREATE PROCEDURE usp_calculate_future_value_for_account(account_id INT, interest DECIMAL(10,4))
BEGIN
   SELECT a.id, ah.first_name, ah.last_name, a.balance,
     (ufn_calculate_future_value(a.balance,interest,5))as balance_in_5_years 
 FROM accounts as a
 JOIN account_holders as ah ON a.account_holder_id = ah.id
 where a.id = account_id;
 END;
 
CALL usp_calculate_future_value_for_account(1, 0.1);