CREATE TABLE category (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    inactive BOOLEAN
); // EDITAR DEPOIS: Passar a utilizar category como uma chave de outra tabela
