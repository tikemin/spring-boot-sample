DROP TABLE IF EXISTS PRODUCTS;
CREATE TABLE IF NOT EXISTS PRODUCTS (
    id varchar(100) PRIMARY KEY,
    name varchar(100) NOT NULL,
    url varchar(200) NOT NULL,
    imgsrc varchar(300) NOT NULL,
    description varchar(200),
);