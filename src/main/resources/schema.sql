CREATE TABLE product (
    id INT PRIMARY KEY,
    name VARCHAR(40),
    price NUMERIC(12,2),
    category VARCHAR(50),
    inactive BOOLEAN
); // EDITAR DEPOIS: Passar a utilizar category como uma chave de outra tabela
