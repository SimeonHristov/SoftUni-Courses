select peak_name, river_name, CONCAT(lower(peak_name),substring(lower(river_name),2)) as mix
from peaks, rivers
where right(lower(peak_name),1) = left(lower(river_name),1)
order by mix asc;