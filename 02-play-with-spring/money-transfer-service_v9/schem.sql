create database bankdb;
use bankdb;

create table accounts(
    number varchar(12) primary key,
    balance decimal(10,2) not null,
    holder_name varchar(100) not null
);

insert into accounts values('1234-5', 1000.00, 'John Doe');
insert into accounts values('1234-6', 2000.00, 'Jane Doe');