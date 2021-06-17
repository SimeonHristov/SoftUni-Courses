create table logs (
log_id int primary key auto_increment,
account_id int,
old_sum decimal (19,4),
new_sum decimal (19,4)
);

delimiter ##
create trigger tr_update_accounts
after update
on accounts
for each row
begin
	insert into `logs` (account_id, old_sum, new_sum)
    values (old.id, old.balance, new.balance);
end ##