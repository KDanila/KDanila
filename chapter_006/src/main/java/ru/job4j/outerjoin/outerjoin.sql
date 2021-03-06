Create table carbody(
id serial primary key,
name varchar(30)) ;
insert into carbody values
(1,'Купе'),
(2,'Универсал'),
(3,'Хэтчбэк'),
(4,'Седан');
create table engine(
id serial primary key,
name varchar(40));
insert into engine (name) values 
('1,4 Бензин'),('1,6 Бензин'),('2,0 Бензин'),('1,6 Дизель');
select*from engine;
create table transmission(
id serial primary key,
name varchar(30));
insert into transmission (name) values ('none');
create table auto (
id serial primary key,
name varchar(50),
motor_type integer references engine(id),
carbody_type integer references carbody(id),
transmission_type integer references transmission(id));
insert into auto values
(1,'bmw',4,1,3),
(2,'mercedes',2,1,1),
(3,'peugeout',1,4,1),
(4,'lada',2,2,2),
(5,'citroen',1,1,1),
(6,'audi',4,4,4),
(7,'nissan',2,1,3),
(8,'toyota',1,1,3);
--1. Вывести список всех машин и все привязанные к ним детали.
select a.id,a.name,e.name,c.name,t.name from auto a,engine e, carbody c, transmission t
where a.motor_type =e.id and a.carbody_type = c.id and a.transmission_type = t.id ;
--2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
select * from transmission;
select t.id,t.name from auto as a
right outer join transmission t on a.transmission_type = t.id
where a.id is null;