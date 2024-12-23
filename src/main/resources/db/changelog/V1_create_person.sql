--liquibase formatted sql

--changeset himan:1 context:main
create table person
(
    id         bigint not null auto_increment,
    first_name varchar(255),
    last_name  varchar(255),
    primary key (id)
);

-- rollback drop table person;