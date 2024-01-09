CREATE TABLE PRODUCT (
     id int primary key,
     product_id UUID NOT NULL,
     name varchar(60) NOT NULL,
     price decimal(20, 2) NOT NULL ,
     amount int NOT NULL
);