DROP TABLE IF EXISTS product;

CREATE TABLE product (
     id SERIAL primary key,
     product_id UUID NOT NULL,
     name VARCHAR(60) NOT NULL,
     price DECIMAL(20, 2) NOT NULL ,
     amount INTEGER NOT NULL
);