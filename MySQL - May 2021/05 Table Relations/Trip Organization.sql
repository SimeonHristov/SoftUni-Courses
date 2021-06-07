select d.id, v.vehicle_type, concat_ws(" ", d.first_name, d.last_name)
from campers d
join vehicles v on v.driver_id = d.id