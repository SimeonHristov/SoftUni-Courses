select r.starting_point, r.end_point, r.leader_id, concat_ws(" ", c.first_name, c.last_name)
from routes r
left join campers c on c.id	 = r.leader_id;