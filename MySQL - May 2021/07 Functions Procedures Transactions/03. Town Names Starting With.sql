delimiter $$

CREATE PROCEDURE `usp_get_towns_starting_with` (input text)
BEGIN
	select name as town_name from towns
    where name like 'input%'
    order by name;
END $$
