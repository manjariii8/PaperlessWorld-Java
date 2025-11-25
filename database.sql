-- Create DB and tables for Paperless World project
CREATE DATABASE IF NOT EXISTS paperless_world;
USE paperless_world;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100),
    role VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS documents (
    id INT AUTO_INCREMENT PRIMARY KEY,
    filename VARCHAR(255),
    owner_id INT,
    status VARCHAR(50),
    FOREIGN KEY (owner_id) REFERENCES users(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS signatures (
    id INT AUTO_INCREMENT PRIMARY KEY,
    document_id INT,
    signer_id INT,
    signature_text TEXT,
    signed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (document_id) REFERENCES documents(id) ON DELETE CASCADE,
    FOREIGN KEY (signer_id) REFERENCES users(id) ON DELETE SET NULL
);


SELECT * FROM users;
SELECT * FROM documents;
SELECT * FROM signatures;
