--
-- ���� ������������ � ������� SQLiteStudio v3.4.4 � �� ��� 15 19:01:01 2024
--
-- �������������� ��������� ������: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- �������: books
CREATE TABLE IF NOT EXISTS books (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR2 (30) NOT NULL UNIQUE, date_relis INTEGER, autor VARCHAR2 (30) DEFAULT ('��� ������'), genre_id INTEGER REFERENCES genres (id));
INSERT INTO books (id, name, date_relis, autor, genre_id) VALUES (1, '����� � ���', 1870, '��� �������', NULL);
INSERT INTO books (id, name, date_relis, autor, genre_id) VALUES (2, '����� � ���. ��� 2', 1870, '��� �������', NULL);
INSERT INTO books (id, name, date_relis, autor, genre_id) VALUES (3, '������������ � ���������', 1865, '����� �����������', NULL);

-- �������: genres
CREATE TABLE IF NOT EXISTS genres (id INTEGER PRIMARY KEY AUTOINCREMENT, genre varchar2 (30) UNIQUE NOT NULL);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
