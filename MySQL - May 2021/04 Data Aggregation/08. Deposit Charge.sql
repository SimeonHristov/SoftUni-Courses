select deposit_group, magic_wand_creator, MIN(deposit_charge) 
from wizzard_deposits
group by deposit_group, magic_wand_creator
order by magic_wand_creator, deposit_group