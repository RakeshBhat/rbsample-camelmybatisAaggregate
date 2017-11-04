--CREATE SCHEMA APP_USER AUTHORIZATION SA;
--SET SCHEMA APP_USER;

Drop Table User if exists;

CREATE TABLE User(
GID INT GENERATED BY DEFAULT AS IDENTITY (START WITH 100, INCREMENT BY 1),
fname VARCHAR(10),
lname VARCHAR(10),
age int,
title VARCHAR(10),
country VARCHAR(10),
city VARCHAR(10) );

CREATE INDEX r_age ON User(age);
CREATE INDEX r_jobTitle ON User(title);
CREATE INDEX r_country ON User(country);
CREATE INDEX r_city ON User(city);