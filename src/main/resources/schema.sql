create schema netology;

CREATE TABLE netology.persons (
  Name varchar(60),
  Surname varchar (60),
  Age varchar (3),
  PhoneNumber varchar (12),
  City varchar (50),
  PRIMARY KEY (Name, Surname, Age)
);

insert into netology.persons
values ('Viktor', 'Perminov', '25', '89658567485', 'Moscow');

insert into netology.persons
values ('Natalia', 'Trifonova', '27', '89658567485', 'Kirov');

insert into netology.persons
values ('Anton', 'Vachevske', '28', '89658567485', 'Vladivostok');

insert into netology.persons
values ('Andrey', 'Suvorov', '30', '89658567485', 'Moscow');