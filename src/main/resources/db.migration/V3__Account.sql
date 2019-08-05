create table accountingEntry(
    id       bigserial      primary key,
    user_id  bigint         not null references users,
    amount   decimal(14, 2) not null,
    is_debit boolean        not null,
    date     timestamp      not null default now()
);