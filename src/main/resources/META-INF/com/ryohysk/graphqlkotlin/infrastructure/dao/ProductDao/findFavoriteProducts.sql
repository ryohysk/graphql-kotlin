SELECT ufp.user_id,
       ufp.product_id,
       p.name,
       p.price,
       p.category_id
FROM users_favorite_products AS ufp
INNER JOIN products p ON ufp.product_id = p.id
WHERE ufp.user_id IN /*userIds*/(1)