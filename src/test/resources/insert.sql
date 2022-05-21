insert into persons (id, name) values (1, 'Igor');
insert into persons (id, name) values (2, 'Andrey');

--машины Игоря
insert into cars (id, model, person_id) values (1, 'LADA Granta', 1);
insert into cars (id, model, person_id) values (2, 'Volkswagen Polo', 1);

--машины Андрея
insert into cars (id, model, person_id) values (3, 'Ford Focus', 2);
insert into cars (id, model, person_id) values (4, 'LADA Vesta', 2);
insert into cars (id, model, person_id) values (5, 'Mazda CX-5', 2);