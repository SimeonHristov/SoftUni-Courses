select deposit_group
from wizzard_deposits
group by deposit_group
order by MIN(magic_wand_size) asc
limit 1;