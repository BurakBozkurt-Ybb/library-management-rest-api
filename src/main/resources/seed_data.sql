-- Yazarları Ekle
INSERT INTO authors (id, name, birth_date, country)
VALUES (1, 'J.K. Rowling', '1965-07-31', 'United Kingdom'),
       (2, 'J.R.R. Tolkien', '1892-01-03', 'United Kingdom'),
       (3, 'Victor Hugo', '1802-02-26', 'France'),
       (4, 'George Orwell', '1903-06-25', 'United Kingdom');

-- Yayınevlerini Ekle
INSERT INTO publishers (id, name, establishment_year, address)
VALUES (1, 'Yapı Kredi Yayınları', 1945, 'İstanbul'),
       (2, 'Metis Yayınları', 1982, 'İstanbul'),
       (3, 'Can Yayınları', 1981, 'İstanbul'),
       (4, 'İthaki Yayınları', 1997, 'İstanbul');

-- Kategorileri Ekle
INSERT INTO categories (id, name, description)
VALUES (1, 'Fantastik', 'Hayal gücü ve sihir içeren kitaplar'),
       (2, 'Distopya', 'Baskıcı rejimleri konu alan kitaplar'),
       (3, 'Klasik', 'Edebi değeri yüksek, klasikleşmiş eserler');

-- Kitapları Ekle
INSERT INTO books (id, name, publication_year, stock, author_id, publisher_id)
VALUES (1, 'Harry Potter ve Felsefe Taşı', 1997, 10, 1, 1),
       (2, 'Yüzüklerin Efendisi', 1954, 5, 2, 2),
       (3, 'Sefiller', 1862, 3, 3, 3),
       (4, '1984', 1949, 8, 4, 4);

-- Kitap-Kategori İlişkilerini Ekle
INSERT INTO book_categories (book_id, category_id)
VALUES (1, 1), -- Harry Potter -> Fantastik
       (2, 1), -- Yüzüklerin Efendisi -> Fantastik
       (3, 3), -- Sefiller -> Klasik
       (4, 2), -- 1984 -> Distopya
       (4, 3);  -- 1984 -> Klasik
