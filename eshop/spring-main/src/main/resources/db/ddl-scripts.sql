DROP TABLE IF EXISTS PRODUCT;

DROP TABLE IF EXISTS PRODUCT_CATEGORY;

CREATE TABLE PRODUCT_CATEGORY
(
    id   BIGINT primary key auto_increment,
    name varchar(20) NOT NULL
);

CREATE TABLE PRODUCT
(
    id         BIGINT primary key auto_increment,
    product_id UUID           NOT NULL,
    name       varchar(60)    NOT NULL,
    price      decimal(20, 2) NOT NULL,
    amount     int            NOT NULL
);

CREATE TABLE PRODUCT_PRODUCT_CATEGORIES
(
    product_id            BIGINT NOT NULL,
    product_categories_id BIGINT NOT NULL
);

DROP TABLE IF EXISTS users_authorities;
DROP TABLE IF EXISTS authority;
DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id           BIGINT primary key auto_increment,
    name         VARCHAR(20)  NOT NULL,
    surname      VARCHAR(50)  NOT NULL,
    email        VARCHAR(100) NOT NULL,
    password     VARCHAR(500) NOT NULL,
    zip_code     VARCHAR(10)  NOT NULL,
    phone_number VARCHAR(12)  NOT NULL,
    CONSTRAINT users_email_key UNIQUE (email),
    CONSTRAINT users_phone_number_key UNIQUE (phone_number)
);

CREATE TABLE authority
(
    id          BIGINT primary key auto_increment,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(2000),
    CONSTRAINT authority_key UNIQUE (name)
);

CREATE TABLE users_authorities
(
    user_id      BIGINT,
    authorities_id BIGINT,
    CONSTRAINT users_authorities_key UNIQUE (user_id, authorities_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (authorities_id) REFERENCES authority(id)
);

DROP TABLE IF EXISTS files;
CREATE TABLE files
(
    id           BIGINT primary key auto_increment,
    name         VARCHAR(255)  NOT NULL,
    extension    VARCHAR(25),
    size         BIGINT,
    timestamp    TIMESTAMP DEFAULT current_timestamp
);