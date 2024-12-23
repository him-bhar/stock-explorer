--liquibase formatted sql

--changeset himan:2 context:test
insert into person (id, first_name, last_name) VALUES (1, 'H', 'B');

-- rollback delete from person;