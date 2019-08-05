create table cars(
  id         bigserial     primary key,
  model      varchar(100)  not null,
  brand      varchar(100)  not null,
  year_build date          not null,
  price      bigint        not null,
  image_name varchar(1000)
);