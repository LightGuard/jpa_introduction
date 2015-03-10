-- Database: docker
BEGIN;

  DROP TABLE IF EXISTS book;
  CREATE TABLE book(
    id BIGSERIAL PRIMARY KEY,
    isbn CHAR(13) UNIQUE NOT NULL,
    title CHAR(255) NOT NULL,
    publication_date DATE NOT NULL
  );

  DROP TABLE IF EXISTS address;
  CREATE TABLE address(
    id BIGSERIAL PRIMARY KEY,
    line_1 CHAR(255) NOT NULL,
    line_2 CHAR(255),
    line_3 CHAR(255),
    city CHAR(100) NOT NULL,
    postcode CHAR(10) NOT NULL,
    province CHAR(20) NOT NULL,
    country CHAR(3) NOT NULL
  );

  DROP TABLE IF EXISTS member;
  CREATE TABLE member(
    id BIGSERIAL PRIMARY KEY,
    gender CHAR(1),
    first_name CHAR(20) NOT NULL,
    last_name CHAR(30) NOT NULL,
    address_id BIGINT REFERENCES address (id) MATCH FULL
  );

  DROP TABLE IF EXISTS library;
  CREATE TABLE library(
    id BIGSERIAL PRIMARY KEY,
    libary_name CHAR(50) NOT NULL,
    address_id BIGINT REFERENCES address(id)
  );

  DROP TABLE IF EXISTS book_at_library;
  CREATE TABLE book_at_library(
    quantity INTEGER,
    library_id BIGINT REFERENCES library(id),
    book_id BIGINT REFERENCES book(id)
  );

  DROP TABLE IF EXISTS author;
  CREATE TABLE author(
    id BIGSERIAL PRIMARY KEY,
    first_name CHAR(20) NOT NULL,
    last_name CHAR(30) NOT NULL
  );

  DROP TABLE IF EXISTS book_by_author;
  CREATE TABLE book_by_author(
    author_id BIGINT REFERENCES author(id),
    book_id BIGINT REFERENCES book(id)
  );

  DROP TABLE IF EXISTS category;
  CREATE TABLE category(
    id BIGSERIAL PRIMARY KEY,
    category_name CHAR(50) NOT NULL
  );

  DROP TABLE IF EXISTS book_by_category;
  CREATE TABLE book_by_category(
    category_id BIGINT REFERENCES category(id),
    book_id BIGINT REFERENCES book(id)
  );
END;
