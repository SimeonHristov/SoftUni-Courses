select user_name, 
substring(email, 1 + locate("@",email) , length(email)) as 'email_provider'
from users
order by email_provider ,user_name;


