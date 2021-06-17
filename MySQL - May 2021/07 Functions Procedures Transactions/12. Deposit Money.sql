delimiter ##

create procedure usp_deposit_money (account_id int, money_amount decimal (10,4))
begin

	start transaction;
    if (select count(*) from accounts where id = account_id) = 0
		or (money_amount <= 0)
		then rollback;
    else
		update accounts
        set balance = balance + money_amount
        where id = account_id;
    end if;
	
end ##