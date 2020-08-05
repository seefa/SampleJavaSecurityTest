INSERT INTO library.Book_Count (BookNo, UserID) VALUES (1, 1);
INSERT INTO library.Book_Count (BookNo, UserID) VALUES (2, 2);
INSERT INTO library.Book_Count (BookNo, UserID) VALUES (0, 3);
INSERT INTO library.Book_Count (BookNo, UserID) VALUES (0, 4);
INSERT INTO library.Book_Count (BookNo, UserID) VALUES (0, 5);
INSERT INTO library.Book_Count (BookNo, UserID) VALUES (0, 6);
INSERT INTO library.Book_Count (BookNo, UserID) VALUES (0, 7);
INSERT INTO library.Book_Count (BookNo, UserID) VALUES (0, 8);
INSERT INTO library.Book_Count (BookNo, UserID) VALUES (0, 9);
INSERT INTO library.Book_Count (BookNo, UserID) VALUES (0, 10);
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (3, 'Harry Potter and Goblet of Fire', 'Fiction', 'J. K. Rowling', 'Pottermore', '12', 'B');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (4, 'Harry Potter and Deathly Hallow', 'Fiction', 'J. K. Rowling', 'Pottermore', 'D', '23');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (5, 'Famous Five', 'sd', 'ds', 'dsd', 'A', '3');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (6, 'akhjkd', 'hdfdj', 'jkshdkjh', 'hkjdfh', 'hj', 'd');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (13, 'The da Vinci Code', 'Thriller', 'Dan Brown', 'Doubleday', 'r', '5');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (14, 'Pride and Prejudice', 'Romantic', 'Alexander Dumas', 'Pearson', 'a', '9');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (15, 'To Kill A Mocking Bird', 'Emotional', 'Harper Lee', 'McGraw', 'z', '8');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (16, 'The Perks Of being A Wallflower', 'Drama', 'Stephen Chbosky', 'Klett', 'g', '1');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (17, 'The Hunger Games', 'Action', 'Suzanne Collins', 'Pearson', 't', '7');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (18, 'Madhushala', 'Life', 'H R Bacchan', 'Pushpalata', 'h', '6');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (19, 'V for Vendetta ', 'Action', 'Alan Moore', 'Cambridge', 'a', '9');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (20, 'Sample', 'Comic', 'sample', 'sample', '1', '1');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (21, '', '', '', '', '', '');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (22, '', '', '', '', '', '');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (23, ''';drop books;', '', '', '', '', '');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (24, '`drop books;`', '', '', '', '', '');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (25, '', '', '', '', '', '');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (26, '', '', '', '', '', '');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (27, '', '', '', '', '', '');
INSERT INTO library.Books (BookID, BookName, Genre, Author, Publisher, Shelf, Row) VALUES (28, '', '', '', '', '', '');
INSERT INTO library.IssuedBook (BookID, UserID, IssueDate, ReturnDate) VALUES (5, 1, '2016-11-17', '2016-12-02');
INSERT INTO library.IssuedBook (BookID, UserID, IssueDate, ReturnDate) VALUES (12, 2, '2016-11-17', '2016-12-02');
INSERT INTO library.IssuedBook (BookID, UserID, IssueDate, ReturnDate) VALUES (6, 2, '2016-11-17', '2016-12-02');
INSERT INTO library.Librarian (LibrarianID, FullName, UserName, Password, Email) VALUES (1, 'Enco Sier', 'Encosier', '1234', 'enco.cs.doc@gmail.com');
INSERT INTO library.Librarian (LibrarianID, FullName, UserName, Password, Email) VALUES (2, 'Leloush Britannia', 'Zero', '9876', 'leloush.zero@bitannia.com');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (1, 'hjkhdkj');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (2, 'Pottermore');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (3, 'dsd');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (4, 'Whittaker');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (5, 'ewhkje');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (6, 'dhskj');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (7, 'hkjdfh');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (8, 'gsjf');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (9, 'dshh');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (10, 'gdsh');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (11, 'Water');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (12, 'ew');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (13, 'dgjs');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (14, 'SGAJ');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (15, 'WHOKNOW');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (16, 'Doubleday');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (17, 'Pearson');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (18, 'McGraw');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (19, 'Klett');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (20, 'Pushpalata');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (21, 'Cambridge');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (22, 'TMH');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (23, '');
INSERT INTO library.Publisher (PublisherID, PublisherName) VALUES (24, 'sample');
INSERT INTO library.Users (UserID, UserPass, RegDate, UserName, Email, FailedCount, LockedUntilDateTime) VALUES (1, '1234', '2012-05-15', 'Deco', 'deco@gmail.com', 0, null);
INSERT INTO library.Users (UserID, UserPass, RegDate, UserName, Email, FailedCount, LockedUntilDateTime) VALUES (2, '12345678', '2016-11-07', 'Piyush', 'pkalkute@gmail.com', 0, null);
INSERT INTO library.Users (UserID, UserPass, RegDate, UserName, Email, FailedCount, LockedUntilDateTime) VALUES (3, '012345', '2016-11-25', 'NewHero', 'newhero@gmail.com', 0, null);
INSERT INTO library.Users (UserID, UserPass, RegDate, UserName, Email, FailedCount, LockedUntilDateTime) VALUES (4, 'Delfani', '2020-07-14', 'Saman', 'sami', 0, null);
INSERT INTO library.Users (UserID, UserPass, RegDate, UserName, Email, FailedCount, LockedUntilDateTime) VALUES (5, '', '2020-07-14', '', '', 0, null);
INSERT INTO library.Users (UserID, UserPass, RegDate, UserName, Email, FailedCount, LockedUntilDateTime) VALUES (6, '', '2020-07-14', '`drop Users;`', '', 0, null);
INSERT INTO library.Users (UserID, UserPass, RegDate, UserName, Email, FailedCount, LockedUntilDateTime) VALUES (7, '', '2020-07-14', ''';drop all Users;', '', 0, null);
INSERT INTO library.Users (UserID, UserPass, RegDate, UserName, Email, FailedCount, LockedUntilDateTime) VALUES (8, 'klmlmlklm', '2020-07-21', ',klkmlkqlkmq', 'lkmlmlm', 0, null);
INSERT INTO library.Users (UserID, UserPass, RegDate, UserName, Email, FailedCount, LockedUntilDateTime) VALUES (9, '$2a$10$MExjLllDagEjvQiocvIkTuvZnCfTTVLAS3r9Hpyilb.1NzWQSQ1kW', '2020-08-04', 'sami', 'sami@gmail.com', 4, '2020-08-06');
INSERT INTO library.Users (UserID, UserPass, RegDate, UserName, Email, FailedCount, LockedUntilDateTime) VALUES (10, '$2a$10$z4lMKFOWkw4TU.8xtKNadOrGRNKZWCzEvd4dpyX8kZem3kvm3LSR6', '2020-08-05', 'Test', 'test@gmail.com', 0, null);