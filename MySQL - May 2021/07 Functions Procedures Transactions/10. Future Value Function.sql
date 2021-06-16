CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(10,4), yearly_interest_rate DECIMAL(10,4), number_of_years INT)
RETURNS DECIMAL(10,4)
DETERMINISTIC
BEGIN
    DECLARE result DECIMAL(10,4);
    SET result := sum * (pow((yearly_interest_rate  + 1),  number_of_years));
	RETURN result;
END;

