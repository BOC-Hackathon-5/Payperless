create table country
(
    id          bigserial primary key,
    name        varchar,
    iso_2       varchar,
    iso_3       varchar,
    iso_numeric numeric,
    show_on_ui  boolean,
    auto_reject boolean
);


create table company
(
    id                    bigserial primary key,
    name                  varchar,
    country_id            bigint
        constraint fk_country_id_to_country references country,
    registration_number   varchar,
    registration_location varchar,
    entity_type           varchar,
    registration_date     date,
    city                  varchar,
    state                 varchar,
    zip                   varchar
);
