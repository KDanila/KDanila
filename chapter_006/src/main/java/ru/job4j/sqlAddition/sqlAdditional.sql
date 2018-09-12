CREATE TABLE company
(
id integer NOT NULL,
name character varying,
CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
id integer NOT NULL,
name character varying,
company_id integer,
CONSTRAINT person_pkey PRIMARY KEY (id)
);
insert into company values (1,'Samsung'),
(2,'Apple'),
(3,'Meizu'),
(4,'Xiaomi'),
(5,'Nokia');
select* from company;

insert into person values
(1,'Anton',1),
(2,'Boris',1),
(3,'Greg',2),
(4,'Semen',2),
(5,'Boris',2),
(6,'Boris',3),
(7,'Greg',3),
(8,'Semen',3),
(9,'Boris',4),
(11,'Vasya',5),
(12,'Petr',5),
(13,'Conor',5);
(14,'Arkadii',1);
--1.
--Retrieve in a single query:
--// - names of all persons that are NOT in the company with id = 5
--// - company name for each person
select p.name,c.name from person p inner join company c on p.company_id= c.id and not company_id = 5;
--2.
-- Select the name of the company with the maximum number of persons + number of persons in this company
--select company_id, max(
	select c.name, count(company_id) as numberOfEmployee from person p
	inner join company c on p.company_id= c.id
	group by c.name
	order by numberOfEmployee desc
	limit 1;
