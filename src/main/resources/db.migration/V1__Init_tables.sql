drop table if exists hall, film, film_session;

-- create sequence hibernate_sequence start 2 increment 1;

create table hall (
    id int8 primary key not null,
    name varchar(255),
    seats_num int not null
);

create table film (
    id int8 primary key not null,
    title varchar(255) not null,
    year int not null,
    age int not null,
    filename varchar(255),
    description varchar(2048)
);

create table film_session (
    id int8 primary key not null,
    h_id int8 not null,
    f_id int8 not null,
    price float8 not null,
    time timestamp not null,
    foreign key (h_id) references hall (id) ON DELETE CASCADE,
    foreign key (f_id) references film (id) ON DELETE CASCADE
);


ALTER SEQUENCE hall_seq RESTART WITH 1;
UPDATE hall SET id=nextval('hall_seq');

ALTER SEQUENCE film_seq RESTART WITH 1;
UPDATE film SET id=nextval('film_seq');
