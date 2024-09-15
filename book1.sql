--
-- Файл сгенерирован с помощью SQLiteStudio v3.4.4 в Вс сен 15 19:01:01 2024
--
-- Использованная кодировка текста: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Таблица: books
CREATE TABLE IF NOT EXISTS books (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR2 (30) NOT NULL UNIQUE, date_relis INTEGER, autor VARCHAR2 (30) DEFAULT ('Без автора'), genre_id INTEGER REFERENCES genres (id));
INSERT INTO books (id, name, date_relis, autor, genre_id) VALUES (1, 'Война и мир', 1870, 'Лев Толстой', NULL);
INSERT INTO books (id, name, date_relis, autor, genre_id) VALUES (2, 'Война и мир. Том 2', 1870, 'Лев Толстой', NULL);
INSERT INTO books (id, name, date_relis, autor, genre_id) VALUES (3, 'Преступление и наказание', 1865, 'Федор Достоевский', NULL);

-- Таблица: genres
CREATE TABLE IF NOT EXISTS genres (id INTEGER PRIMARY KEY AUTOINCREMENT, genre varchar2 (30) UNIQUE NOT NULL);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
