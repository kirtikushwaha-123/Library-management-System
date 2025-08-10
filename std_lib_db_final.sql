create database library;

drop database library;
use library;
create table user(
name varchar(40),
userId int auto_increment primary key,
password int,
gender varchar(3),
role ENUM('admin', 'student') NOT NULL
);
drop table user;
create table admin(
name varchar(40),
userId int auto_increment primary key,
password int,
gender varchar(3),
role ENUM('admin', 'student') NOT NULL
);


create table student(
stdId int primary key,
stdName varchar(255) ,
stdcourse varchar(255) ,
stdsem varchar(255) ,
stdmobile varchar(255) ,
stdemail varchar(255) 
);


select *from student;

CREATE TABLE BOOK(
bookId int primary key,
bookName varchar(255),
bookAuthor varchar(255),
bookPublisher varchar(255),
yaer int,
quantity int
);

create table login(
username varchar(255) unique,
role varchar(255),
passworld varchar(255)
);
create table signUp(
name varchar(255),
userId varchar(255),
pass varchar(255),
gender varchar(255),
role varchar(255)
);


CREATE TABLE issued_book (
    bookId INT,
    stdId INT,
    issuedDate DATE,
    returnDate DATE,
    PRIMARY KEY (bookId, stdId),
    FOREIGN KEY (bookId) REFERENCES book(bookId),
    FOREIGN KEY (stdId) REFERENCES student(stdId)
);
select *from issued_book;


select *from book;
drop table book;
select *from login;
select *from signUp;

select *from user;

