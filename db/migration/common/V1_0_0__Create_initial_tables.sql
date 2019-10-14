CREATE TABLE users
(
    id   INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
) COMMENT 'ユーザーテーブル';

CREATE TABLE categories
(
    id   INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
) COMMENT 'カテゴリテーブル';

CREATE TABLE products
(
    id          INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(200)           NOT NULL,
    price       INT UNSIGNED DEFAULT 0 NOT NULL,
    category_id INT UNSIGNED           NOT NULL,
    CONSTRAINT products_categories_id_fk FOREIGN KEY (category_id) REFERENCES categories (id)
) COMMENT '商品テーブル';

CREATE TABLE users_favorite_products
(
    user_id    INT UNSIGNED NOT NULL,
    product_id INT UNSIGNED NOT NULL,
    CONSTRAINT users_favorite_products_uk UNIQUE (user_id, product_id),
    CONSTRAINT users_favorite_products_products_id_fk FOREIGN KEY (product_id) REFERENCES products (id),
    CONSTRAINT users_favorite_products_users_id_fk FOREIGN KEY (user_id) REFERENCES users (id)
) COMMENT 'ユーザーのお気に入り商品中間テーブル';