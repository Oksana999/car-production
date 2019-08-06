create table transactions(
    id bigserial  primary key,
    user_id bigint  not null references users,
    car_id bigint   not null references cars,
    transaction_date timestamp not null default now()
);