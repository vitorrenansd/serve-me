CREATE TABLE category (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    inactive BOOLEAN DEFAULT FALSE
);

CREATE TABLE product (
    id IDENTITY PRIMARY KEY,
    sku VARCHAR(20),
    name VARCHAR(40) NOT NULL,
    price NUMERIC(15,2) NOT NULL,
    fk_category INT NOT NULL,
    inactive BOOLEAN DEFAULT FALSE,

    CONSTRAINT fk_product_category
        FOREIGN KEY (fk_category)
        REFERENCES category(id)
);

CREATE TABLE orders (
    id IDENTITY PRIMARY KEY,
    table_number INT NOT NULL,
    waiter VARCHAR(20) NOT NULL,
    total NUMERIC(15,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT 'PENDING', -- PENDING, IN_PROGRESS, COMPLETED or CANCELED
);

CREATE TABLE order_item (
    id IDENTITY PRIMARY KEY,
    fk_order INT NOT NULL,
    fk_product INT NOT NULL,
    unit_price NUMERIC(15,2) NOT NULL CHECK (unit_price >= 0),
    quantity INT NOT NULL CHECK (quantity > 0),
    total_price NUMERIC(15,2) NOT NULL CHECK (total_price >= 0)
    canceled BOOLEAN DEFAULT FALSE,

    CONSTRAINT fk_order_item_product
        FOREIGN KEY (fk_product)
        REFERENCES product(id),
    CONSTRAINT fk_order_item_orders
        FOREIGN KEY (fk_order)
        REFERENCES orders(id)
);