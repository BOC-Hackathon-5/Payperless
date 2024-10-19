create table country
(
    id          bigserial primary key,
    name        varchar,
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

insert into country
    (name, show_on_ui, auto_reject)
values ('Cyprus', true, false),
       ('Albania', true, true),
       ('Andorra', true, true),
       ('Armenia', true, true),
       ('Austria', true, true),
       ('Azerbaijan', true, true),
       ('Belarus', true, true),
       ('Belgium', true, true),
       ('Bosnia and Herzegovina', true, true),
       ('Bulgaria', true, true),
       ('Croatia', true, true),
       ('Czech Republic', true, true),
       ('Denmark', true, true),
       ('Estonia', true, true),
       ('Finland', true, true),
       ('France', true, true),
       ('Georgia', true, true),
       ('Germany', true, true),
       ('Greece', true, true),
       ('Hungary', true, true),
       ('Iceland', true, true),
       ('Ireland', true, true),
       ('Italy', true, true),
       ('Kazakhstan', true, true),
       ('Kosovo', true, true),
       ('Latvia', true, true),
       ('Liechtenstein', true, true),
       ('Lithuania', true, true),
       ('Luxembourg', true, true),
       ('Malta', true, true),
       ('Moldova', true, true),
       ('Monaco', true, true),
       ('Montenegro', true, true),
       ('Netherlands', true, true),
       ('North Macedonia', true, true),
       ('Norway', true, true),
       ('Poland', true, true),
       ('Portugal', true, true),
       ('Romania', true, true),
       ('Russia', true, true),
       ('San Marino', true, true),
       ('Serbia', true, true),
       ('Slovakia', true, true),
       ('Slovenia', true, true),
       ('Spain', true, true),
       ('Sweden', true, true),
       ('Switzerland', true, true),
       ('Turkey', true, true),
       ('Ukraine', true, true),
       ('United Kingdom', true, true),
       ('Vatican City', true, true)
;