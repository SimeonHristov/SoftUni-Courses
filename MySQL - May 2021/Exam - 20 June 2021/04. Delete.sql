delete from clients c
where c.id not in (select client_id from courses)