select m.mountain_range, p.peak_name, p.elevation from mountains m 
left join peaks p on p.mountain_id = m.id
where mountain_range like 'Rila'
order by p.elevation desc;