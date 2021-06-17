CREATE table `logs`(
log_id INT PRIMARY KEY AUTO_INCREMENT, 
account_id INT, 
old_sum  DECIMAL(20,4), 
new_sum DECIMAL(20,4));
CREATE TRIGGER account_logs
AFTER UPDATE
ON accounts 
FOR EACH ROW
BEGIN
	INSERT INTO `logs` (account_id, old_sum, new_sum)
	VALUES(NEW.id, OLD.balance, NEW.balance);
END;
CREATE TABLE notification_emails (
    id INT PRIMARY KEY AUTO_INCREMENT,
    recipient INT,
    subject VARCHAR(200),
    body VARCHAR(200)
);


CREATE TRIGGER new_email_for_each_log
AFTER UPDATE 
ON `logs`
FOR EACH ROW
BEGIN
    INSERT INTO notification_emails(recipient, subject, body)
    VALUES(NEW.account_id, concat('Balance change for account: ','', NEW.account_id), 
    concat_ws(' ','On',NOW(), 'your balance was changed from', NEW.old_sum, NEW.new_sum));
END;