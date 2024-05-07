create database register;
use register;
create table register1(
userName varchar(30)unique,
pass  varchar(30)unique,
phone varchar(30)unique


);

select * from register;
drop table register;
truncate register;
Select userName,pass from register1 where userName="akash" and pass="123";
desc register;

insert into register1 values("akash","123","12345");

