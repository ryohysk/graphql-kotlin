SELECT /*%expand*/*
FROM users AS u
WHERE
/*%if id != null */
      u.id = /*id*/1
/*%end*/