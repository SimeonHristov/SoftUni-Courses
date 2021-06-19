delimiter ##

CREATE PROCEDURE `udp_update_product_price` (address_name VARCHAR (50))
BEGIN

	update products z
    set z.price = 
					case
						when left(address_name,1) = 0 then z.price + 100
						else z.price + 200
					end
    where z.id in (
					SELECT ps.product_id from addresses a
					join stores s on s.address_id = a.id
					join products_stores ps on ps.store_id = s.id
					where a.name = address_name);
    

END ##
	
    CALL udp_update_product_price('1 Cody Pass');
