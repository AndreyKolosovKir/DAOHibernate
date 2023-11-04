create schema netology;

CREATE TABLE netology.persons
(
    id          serial PRIMARY KEY,
    Name        varchar(60),
    Surname     varchar(60),
    Age         INTEGER,
    PhoneNumber varchar(12),
    City        varchar(50)
);

insert into netology.persons
values (1, 'Viktor', 'Perminov', 25, '89658567485', 'Moscow');

insert into netology.persons
values (2, 'Natalia', 'Trifonova', 27, '89658567485', 'Kirov');

insert into netology.persons
values (3, 'Anton', 'Vachevske', 28, '89658567485', 'Vladivostok');

insert into netology.persons
values (4, 'Andrey', 'Suvorov', 30, '89658567485', 'Moscow');