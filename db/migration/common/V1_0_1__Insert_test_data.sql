INSERT INTO service.users (id, name) VALUES (1, 'Ryo');
INSERT INTO service.users (id, name) VALUES (2, 'Tom');
INSERT INTO service.users (id, name) VALUES (3, 'Mark');
INSERT INTO service.users (id, name) VALUES (4, 'Emma');
INSERT INTO service.users (id, name) VALUES (5, 'Chloe');

INSERT INTO service.categories (id, name) VALUES (1, '書籍');
INSERT INTO service.categories (id, name) VALUES (2, '映画');
INSERT INTO service.categories (id, name) VALUES (3, 'ゲーム');
INSERT INTO service.categories (id, name) VALUES (4, '電化製品');
INSERT INTO service.categories (id, name) VALUES (5, '音楽');
INSERT INTO service.categories (id, name) VALUES (6, '食品');

INSERT INTO service.products (id, name, price, category_id) VALUES (1, 'Kotlinイン・アクション', 4000, 1);
INSERT INTO service.products (id, name, price, category_id) VALUES (2, 'Kotlin Webアプリケーション 新しいサーバサイドプログラミング', 3300, 1);
INSERT INTO service.products (id, name, price, category_id) VALUES (3, '君の名は。', 500, 2);
INSERT INTO service.products (id, name, price, category_id) VALUES (4, 'モンスターハンター:ワールド', 6000, 3);
INSERT INTO service.products (id, name, price, category_id) VALUES (5, 'ドラゴンクエストXI', 6500, 3);
INSERT INTO service.products (id, name, price, category_id) VALUES (6, 'Nintendo Switch', 30000, 3);

INSERT INTO service.users_favorite_products (user_id, product_id) VALUES (1, 1);
INSERT INTO service.users_favorite_products (user_id, product_id) VALUES (1, 4);
INSERT INTO service.users_favorite_products (user_id, product_id) VALUES (1, 5);