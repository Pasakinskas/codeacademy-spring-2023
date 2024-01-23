DROP TABLE IF EXISTS PRODUCT;

DROP TABLE IF EXISTS PRODUCT_CATEGORY;

CREATE TABLE PRODUCT_CATEGORY
(
    id         BIGINT primary key auto_increment,
    name       varchar(20) NOT NULL
);

CREATE TABLE PRODUCT (
     id BIGINT primary key auto_increment,
     product_id UUID NOT NULL,
     name varchar(60) NOT NULL,
     price decimal(20, 2) NOT NULL,
     amount int NOT NULL
);

CREATE TABLE PRODUCT_PRODUCT_CATEGORIES
(
    product_id BIGINT NOT NULL,
    product_categories_id BIGINT NOT NULL
);