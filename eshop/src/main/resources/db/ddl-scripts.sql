DROP TABLE IF EXISTS PRODUCT;

CREATE TABLE PRODUCT (
     id int primary key auto_increment,
     product_id UUID NOT NULL,
     name varchar(60) NOT NULL,
     price decimal(20, 2) NOT NULL ,
     amount int NOT NULL
);