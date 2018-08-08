create database umlClient;

create table role(
	id serial primary key,	
	role_type varchar(2000)
);
create table comment(
	id serial primary key,	
	comment_text varchar(2000)
);

create table attach(
	id serial primary key,	
	attach varchar(200)
);

create table category(
	id serial primary key,	
	category varchar(2000)
);

create table state(
	id serial primary key,	
	st varchar(2000)
);

create table item(
	id serial primary key,
	comments_id int references comment(id),
	attachs_id int references attach(id),
	category_id int references category(id),
	state_id int references state(id)
);

create table users(
	id serial primary key,
	item_id int references item(id)
);

create table role_users(
	role_id int references role(id),
	user_id int references users(id)
);