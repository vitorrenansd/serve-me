CREATE TABLE category (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    inactive BOOLEAN DEFAULT FALSE
);

CREATE TABLE product (
    id IDENTITY PRIMARY KEY,
    sku VARCHAR(20),
    name VARCHAR(40) NOT NULL,
    price NUMERIC(12,2) NOT NULL,
    fk_category INT NOT NULL,
    inactive BOOLEAN DEFAULT FALSE,

    CONSTRAINT fk_product_category
        FOREIGN KEY (fk_category)
        REFERENCES category(id)
);