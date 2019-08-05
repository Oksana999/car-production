create table users(
id bigserial primary key,
user_name varchar(100) not null unique,
password varchar (100) not null
);

insert into users(user_name, password)
values ('Oksana', '$2a$10$XmtWixcSIQVNuX.j3SY7ZegiojYcKp.yE1MtqgF7VAy6e1GclZITm');