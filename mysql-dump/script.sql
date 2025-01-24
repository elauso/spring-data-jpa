USE product_db;

CREATE TABLE owner (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,
    owner_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (owner_id) REFERENCES owner(id) ON DELETE CASCADE
);

INSERT INTO owner (name, email) VALUES
('Alice Johnson', 'alice@example.com'),
('Bob Smith', 'bob@example.com'),
('Charlie Brown', 'charlie@example.com');

INSERT INTO product (name, description, price, owner_id) VALUES
('Laptop', 'High-end gaming laptop', 1500.00, 1),
('Smartphone', 'Latest model smartphone', 800.00, 2),
('Headphones', 'Noise-cancelling headphones', 200.00, 3),
('Monitor', '4K Ultra HD Monitor', 500.00, 1),
('Keyboard', 'Mechanical keyboard', 100.00, 2);