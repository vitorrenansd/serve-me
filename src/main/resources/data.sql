INSERT INTO category(id, name, inactive) VALUES
(1, 'Porções', FALSE),
(2, 'Bebidas', FALSE);

INSERT INTO product(id, name, price, fk_category, inactive) VALUES
(1, 'Batata frita', 20.49, 1, FALSE),
(2, 'Coca-cola Zero 600ml', 5.99, 2, FALSE),
(3, 'Coca-cola 600ml', 5.99, 2, FALSE),
(4, 'Pastel 4 queijos', 28.99, 1, TRUE);