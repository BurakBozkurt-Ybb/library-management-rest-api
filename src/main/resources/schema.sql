-- Tüm tabloları temizle (varsa)
DROP TABLE IF EXISTS book_categories CASCADE;
DROP TABLE IF EXISTS book_borrowings CASCADE;
DROP TABLE IF EXISTS books CASCADE;
DROP TABLE IF EXISTS authors CASCADE;
DROP TABLE IF EXISTS publishers CASCADE;
DROP TABLE IF EXISTS categories CASCADE;

-- Tabloları oluştur
CREATE TABLE authors (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_date DATE,
    country VARCHAR(255)
);

CREATE TABLE publishers (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    establishment_year INT,
    address VARCHAR(255)
);

CREATE TABLE categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    description VARCHAR(255)
);

CREATE TABLE books (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    publication_year INT,
    stock INT,
    author_id BIGINT REFERENCES authors(id),
    publisher_id BIGINT REFERENCES publishers(id)
);

CREATE TABLE book_borrowings (
    id BIGSERIAL PRIMARY KEY,
    borrower_name VARCHAR(255) NOT NULL,
    borrowing_date DATE NOT NULL,
    return_date DATE,
    book_id BIGINT REFERENCES books(id)
);

CREATE TABLE book_categories (
    book_id BIGINT REFERENCES books(id),
    category_id BIGINT REFERENCES categories(id),
    PRIMARY KEY (book_id, category_id)
);
