INSERT INTO category(id, name, inactive) VALUES
(1, 'PORÇÕES', FALSE),
(2, 'BEBIDAS', FALSE),
(3, 'Fritura', FALSE),
(4, 'PASTEL G', FALSE),
(5, 'Pizza', FALSE);

INSERT INTO product(id, sku, name, description, price, fk_category, inactive) VALUES
(1, 'BATF1', 'BATATA FRITA 500G', 'Porção de 500g de batata frita crocante.', 20.49, 1, FALSE),
(2, 'BATF2', 'BATATA FRITA 1KG', 'Porção de 1kg de batata frita crocante.', 45.99, 1, FALSE),
(3, '', 'COCA-COLA ZERO 600ML', 'Garrafa de 600ml de Coca-Cola Zero.', 5.99, 2, FALSE),
(4, '', 'COCA-COLA 600ML', 'Garrafa de 600ml de Coca-Cola Original.', 5.99, 2, FALSE),
(5, 'P81P', 'PASTEL 4 QUEIJOS', 'Delicioso pastel com recheio de 4 queijos.', 19.99, 3, FALSE),
(6, 'P81G', 'PASTEL 4 QUEIJOS', 'Delicioso pastel com recheio de 4 queijos.', 28.99, 4, TRUE),
(7, 'PIZ01', 'PIZZA CALABRESA', 'Deliciosa pizza de calabresa com cebola e azeitonas.', 49.99, 5, FALSE);

INSERT INTO product_image(fk_product, url) VALUES
(1, '/src/assets/batata.webp'),
(2, '/src/assets/batataG.webp'),
(3, '/src/assets/cocacola.webp'),
(4, '/src/assets/cocacola.webp'),
(5, '/src/assets/pastel.jpg'),
(6, '/src/assets/pastel.jpg'),
(7, '/src/assets/pizza.jpeg');

ALTER TABLE product ALTER COLUMN id RESTART WITH 8;