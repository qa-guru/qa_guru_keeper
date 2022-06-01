create database qa_guru_keeper
    with owner postgres;

create table account
(
    id    serial
        constraint account_pk
            primary key,
    name  varchar,
    value integer
);

alter table account
    owner to postgres;

create unique index account_id_uindex
    on account (id);

create table spend
(
    id             serial
        constraint spend_pk
            primary key,
    account_id     integer
        constraint spend_account_id_fk
            references account,
    spend_category varchar,
    description    varchar,
    spend          integer
);

alter table spend
    owner to postgres;

create unique index spend_id_uindex
    on spend (id);
