delimiter ##

create procedure usp_transfer_money (from_account_id int, to_account_id int, amount decimal (19,4))
begin

	start transaction;
		if (select count(*) from accounts where id = from_account_id) != 1
		or (select count(*) from accounts where id = to_account_id) != 1
		or (amount <= 0)
        or (select balance from accounts where id = from_account_id) < amount
        or from_account_id = to_account_id
		then rollback;
    else
		update accounts
        set balance = balance + amount
        where id = to_account_id;
        update accounts
        set balance = balance - amount
        where id = from_account_id;
    end if;
	
end ##


-- drop procedure usp_transfer_money;