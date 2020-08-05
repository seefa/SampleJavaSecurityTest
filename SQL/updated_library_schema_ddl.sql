create schema library collate utf8_bin;

create table Book_Count
(
	BookNo int default 0 null,
	UserID int not null
);

create table Books
(
	BookID int auto_increment
		primary key,
	BookName varchar(50) not null,
	Genre varchar(10) not null,
	Author varchar(30) null,
	Publisher varchar(30) null,
	Shelf varchar(5) not null,
	Row varchar(5) not null
)
charset=latin1;

create table FullName
(
	UserID int null,
	FirstName varchar(30) not null,
	LastName varchar(30) null
)
charset=latin1;

create table IssuedBook
(
	BookID int null,
	UserID int null,
	IssueDate date not null,
	ReturnDate date not null
)
charset=latin1;

create definer = root@localhost trigger IssuedBook_AFTER_INSERT
after INSERT on IssuedBook
for each row
BEGIN
    UPDATE Book_Count
    SET BookNo = BookNo+1
    where UserID = NEW.UserID;
END;

create definer = root@localhost trigger count
after DELETE on IssuedBook
for each row
BEGIN
    UPDATE Book_Count
    SET BookNo = BookNo-1
    where Book_Count.UserID = OLD.UserID;
END;

create table IssuedMagazine
(
	MagID int null,
	UserID int null,
	IssueDate date not null,
	ReturnDate date not null
)
charset=latin1;

create definer = root@localhost trigger IssuedMagazine_AFTER_DELETE
after DELETE on IssuedMagazine
for each row
BEGIN
    UPDATE Book_Count
    SET BookNo = BookNo
    where Book_Count.UserID = OLD.UserID;
END;

create definer = root@localhost trigger IssuedMagazine_AFTER_INSERT
after INSERT on IssuedMagazine
for each row
BEGIN
    UPDATE Book_Count
    SET BookNo = BookNo +1
    where Book_Count.UserID = NEW.UserID;
END;

create table Librarian
(
	LibrarianID int auto_increment
		primary key,
	FullName varchar(30) not null,
	UserName varchar(30) not null,
	Password varchar(30) not null,
	Email varchar(30) not null
)
charset=latin1;

create table Magazine
(
	MagID int auto_increment
		primary key,
	VolNo int not null,
	Mname varchar(30) not null,
	Magazine varchar(30) not null,
	MagazineShelf varchar(10) not null,
	Genre varchar(10) not null,
	Publisher varchar(10) not null
)
charset=latin1;

create table Publisher
(
	PublisherID int auto_increment
		primary key,
	PublisherName varchar(30) null
)
charset=latin1;

create table Users
(
	UserID int auto_increment
		primary key,
	UserPass varchar(100) not null,
	RegDate date not null,
	UserName varchar(100) not null,
	Email varchar(30) not null,
	FailedCount int default 0 null,
	LockedUntilDateTime date null
)
charset=latin1;

create definer = root@localhost trigger Users_AFTER_INSERT
after INSERT on Users
for each row
BEGIN
    INSERT INTO Book_Count
    values(0,New.UserID);
END;

