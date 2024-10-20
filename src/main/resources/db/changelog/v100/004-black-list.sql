create table black_list
(
    id                  bigserial primary key,
    country             varchar,
    registration_number varchar,
    reason              varchar
);
