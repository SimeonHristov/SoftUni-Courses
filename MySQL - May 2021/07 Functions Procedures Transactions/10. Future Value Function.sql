delimiter ##

CREATE FUNCTION `ufn_calculate_future_value` (sum decimal (10,4), y_rate double (3,2), years int)
RETURNS decimal (10,4)
DETERMINISTIC
BEGIN
	declare future_value decimal (10,4);
    
    set future_value := sum *(power((1 + y_rate),years)); 
    
RETURN future_value;
END ##



select ufn_calculate_future_value (1000,0.5,5);