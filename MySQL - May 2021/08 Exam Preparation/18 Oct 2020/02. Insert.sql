-- SELECT * FROM products p
-- where p.id not in (select ps.product_id from products_stores ps);

insert into products_stores (product_id, store_id)
(select p.id, 1 from products p
where p.id not in (select product_id from products_stores));


