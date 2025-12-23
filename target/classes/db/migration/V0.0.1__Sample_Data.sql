-- --------------------------------------------------------
-- Sample Data for Library System
-- --------------------------------------------------------

-- 1. Insert Publishers
INSERT INTO Publisher (id, name) VALUES (1, 'Penguin Classics');
INSERT INTO Publisher (id, name) VALUES (2, 'Bloomsbury Publishing');
INSERT INTO Publisher (id, name) VALUES (3, 'Allen & Unwin');
INSERT INTO Publisher (id, name) VALUES (4, 'Time USA, LLC');
INSERT INTO Publisher (id, name) VALUES (5, 'Massachusetts Medical Society');

-- 2. Insert Authors
-- Note: Address fields are embedded directly in the Author table
INSERT INTO Author (ssn, name, street, city, zip)
VALUES ('111-22-333', 'Jane Austen', 'Chawton Cottage', 'Hampshire', 'GU34 1SJ');

INSERT INTO Author (ssn, name, street, city, zip)
VALUES ('777-88-999', 'Frank Herbert', '500 Dune Blvd', 'Tacoma', '98402');

INSERT INTO Author (ssn, name, street, city, zip)
VALUES ('222-33-444', 'J.K. Rowling', 'Edinburgh Castle', 'Edinburgh', 'EH1 2NG');

INSERT INTO Author (ssn, name, street, city, zip)
VALUES ('555-66-777', 'J.R.R. Tolkien', '20 Northmoor Road', 'Oxford', 'OX2 6UP');

-- 3. Insert Books
-- Types: NOVEL, BIOGRAPHY, TEXTBOOK, MAGAZINE, JOURNAL

-- Novel (Jane Austen)
INSERT INTO Book (isbn, title, publicationDate, text, type, publisher_id)
VALUES ('978-0141439518', 'Pride and Prejudice', '1813-01-28', 'It is a truth universally acknowledged...', 'NOVEL', 1);

-- Novel (Frank Herbert)
INSERT INTO Book (isbn, title, publicationDate, text, type, publisher_id)
VALUES ('978-0441172719', 'Dune', '1965-08-01', 'In the week before their departure to Arrakis...', 'NOVEL', 1);

-- Novel (J.K. Rowling)
INSERT INTO Book (isbn, title, publicationDate, text, type, publisher_id)
VALUES ('978-0747532743', 'Harry Potter and the Philosopher\'s Stone', '1997-06-26', 'Mr. and Mrs. Dursley, of number four, Privet Drive...', 'NOVEL', 2);

-- Novel (J.R.R. Tolkien)
INSERT INTO Book (isbn, title, publicationDate, text, type, publisher_id)
VALUES ('978-0618640157', 'The Fellowship of the Ring', '1954-07-29', 'When Mr. Bilbo Baggins of Bag End announced...', 'NOVEL', 3);

-- Magazine (Time)
INSERT INTO Book (isbn, title, publicationDate, text, type, publisher_id)
VALUES ('TIME-2023-10', 'Time Magazine: October 2023', '2023-10-01', 'Cover story: AI and the Future of Humanity...', 'MAGAZINE', 4);

-- Journal (NEJM)
INSERT INTO Book (isbn, title, publicationDate, text, type, publisher_id)
VALUES ('NEJM-389-15', 'New England Journal of Medicine Vol 389', '2023-10-12', 'Original Article: Semaglutide in patients with...', 'JOURNAL', 5);

-- 4. Link Authors to Books (Many-to-Many)

-- Pride and Prejudice -> Jane Austen
INSERT INTO Author_Book (authors_ssn, books_isbn) VALUES ('111-22-333', '978-0141439518');

-- Dune -> Frank Herbert
INSERT INTO Author_Book (authors_ssn, books_isbn) VALUES ('777-88-999', '978-0441172719');

-- Harry Potter -> J.K. Rowling
INSERT INTO Author_Book (authors_ssn, books_isbn) VALUES ('222-33-444', '978-0747532743');

-- Fellowship of the Ring -> J.R.R. Tolkien
INSERT INTO Author_Book (authors_ssn, books_isbn) VALUES ('555-66-777', '978-0618640157');