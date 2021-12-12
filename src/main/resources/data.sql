DROP TABLE IF EXISTS Product;
CREATE TABLE Product(
    id_product BIGINT PRIMARY KEY AUTO_INCREMENT,
    name_product VARCHAR(250) NOT NULL,
    manufacturer_product VARCHAR(250) NOT NULL,
    price_product BIGINT NOT NULL,
    photo_product VARCHAR(300),
    image_product BLOB
);

INSERT INTO Product(name_product,manufacturer_product, price_product, photo_product) values ('Laptop Lenovo Ideapad Gaming 3', 'Lenovo', 25900000, 'lenovo.jpg');
INSERT INTO Product(name_product,manufacturer_product, price_product, photo_product) values ('Sony WXMH-1000', 'Sony', 4500000, 'sonywxh100.jpeg');
INSERT INTO Product(name_product,manufacturer_product, price_product, photo_product) values ('Aris Pro', 'Vinsmart', 4000000, 'arispro.jpg');
INSERT INTO Product(name_product,manufacturer_product, price_product, photo_product) values ('Logitech MX Master 2S', 'Logitech', 3000000, 'mx-master-2s.jpg');
