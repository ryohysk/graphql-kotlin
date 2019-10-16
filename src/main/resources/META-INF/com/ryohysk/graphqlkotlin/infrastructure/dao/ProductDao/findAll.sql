SELECT /*%expand*/*
FROM products AS p
WHERE
/*%if categoryId != null */
    p.category_id = /* categoryId */1
/*%end*/