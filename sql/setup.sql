/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Student99
 * Created: Jan 9, 2024
 */

drop database if exists example;

create database example;

use example;

CREATE TABLE Persons (
    PersonID int not null primary key,
    LastName varchar(255),
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255)
);

INSERT INTO persons (`PersonID`, `LastName`, `FirstName`, `Address`, `City`)
VALUES (1,'Maharjan','Amit','1425 College Height Rd', 'Kathmandu');

CREATE TABLE students (
    id int AUTO_INCREMENT not null primary key,
    last_name varchar(255),
    first_name varchar(255),
    address varchar(255),
    city varchar(255)
);

insert into students(last_name, first_name, address, city)
values ('Maharjan', 'Amit', 'KTM', 'Kathmandu');