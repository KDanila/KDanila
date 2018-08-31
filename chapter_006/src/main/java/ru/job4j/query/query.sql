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
values (3,'����');

insert into product
values (7, '���������� ���.', 2, '1999-01-08', 90.0);

--1. �������� ������ ��������� ���� ��������� � ����� "���"
select* from product
where type_id = 1;

--2. �������� ������ ��������� ���� ���������, � ���� � ����� ���� ����� "����������"
select* from product
where name like( '%����������%' );

--3. �������� ������, ������� ������� ��� ��������, ���� �������� ������� ������������� � ��������� ������.
select* from product
where expired_date<'2009-09-02';

--4. �������� ������, ������� ����� ����� ������� �������.
select* from product where price = (select max(price) from product);

--5. �������� ������, ������� ������� ���������� ���� ��������� ������������� ����.
select t.name, sum(p.ammount) from product p
inner join type t on t.id = p.type_id
group by t.name order by t.name;

--6. �������� ������ ��������� ���� ��������� � ����� "���" � "������"
--select* from product
--where type_id = (select id from type where name = '���') 
--or type_id = (select id from type where name = '������') ;

--7. �������� ������, ������� ������� ��� ���������, ������� �������� ������ 10 ����.  
select t.name, sum(ammount) from product p 
inner join type t on t.id = p.type_id 
group by t.name 
having sum(ammount)>10 ;

--8. ������� ��� �������� � �� ���.
select p.name,t.name,p.type_id from product p inner join type t on p.type_id= t.id;