create table type(
id integer primary key,
name varchar(30));

create table product(
id integer primary key, 
name varchar(15), 
type_id integer references type(id), 
expired_date timestamp,
price decimal );

insert into type
values (3,'Вода');

insert into product
values (7, 'мороженное пер.', 2, '1999-01-08', 90.0);

--1. Написать запрос получение всех продуктов с типом "СЫР"
select* from product
where type_id = 1;

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select* from product
where name like( '%мороженное%' );

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select* from product
where expired_date<'2009-09-02';

--4. Написать запрос, который вывод самый дорогой продукт.
select* from product where price = (select max(price) from product);

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
select t.name, sum(p.ammount) from product p
inner join type t on t.id = p.type_id
group by t.name order by t.name;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
--select* from product
--where type_id = (select id from type where name = 'Сыр') 
--or type_id = (select id from type where name = 'Молоко') ;

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  
select t.name, sum(ammount) from product p 
inner join type t on t.id = p.type_id 
group by t.name 
having sum(ammount)>10 ;

--8. Вывести все продукты и их тип.
select p.name,t.name,p.type_id from product p inner join type t on p.type_id= t.id;