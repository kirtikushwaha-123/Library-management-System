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
CREATE TABLE BOOK(
bookId int primary key,
bookName varchar(255),
bookAuthor varchar(255),
bookPublisher varchar(255),
yaer int,
quantity int,
available varchar(10)
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

select *from book;
drop table book;
select *from login;
select *from signUp;

select *from user;

