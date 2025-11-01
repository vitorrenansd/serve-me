CREATE TABLE category (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    inactive BOOLEAN
);

CREATE TABLE product (
    id IDENTITY PRIMARY KEY,
    sku VARCHAR(20),
    name VARCHAR(40) NOT NULL,
    price NUMERIC(12,2) NOT NULL,
    fk_category INT,
    inactive BOOLEAN,

    CONSTRAINT fk_product_category
        FOREIGN KEY (fk_category)
        REFERENCES category(id)
);