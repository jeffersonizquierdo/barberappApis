create database barberapp;
use BarberApp;


create table username (
	id_username int unsigned primary key not null,
	type_username int not null,
	email varchar(200) unique not null,
	password varchar (16) not null,
	name varchar(45) not null,
    nickname  varchar (45) not null,
	cellphone_number varchar (10) not null
);

create table barber (
	id_user int unsigned primary key not null,
	age TinyInt (2) not null,
	last_name varchar (45) not null,
	date_of_birth date not null,
	description varchar (300),
	certificates char(20),
	gender  char(1) not null,
	qualification double not null,
	city varchar (45) not null,
	linked_barbershops varchar (200),
    id_catalogue int unsigned
);



create table customer (
	id_user int unsigned primary key not null,
	email varchar(200) not null,
	name_client varchar (45) not null,
	lastname varchar (20),
	age TinyInt (2) not null,
	gender char(1) not null
);

create table barbershop (
	id_user int unsigned primary key not null,
	location varchar(200) not null,
	qualification double  not null,
	linked_barbers int unsigned,
    id_catalogue int unsigned
);

create table catalogue (

id_catalogue int unsigned auto_increment primary key,
id_username int unsigned,
id_hairstyle int unsigned
);

create table hairstyles (
id_hairstyle int unsigned primary key auto_increment not null,
name varchar (50),
descripcion  varchar (50),
url_hairstyles blob 
);

create table appointment (
	id_appointment int unsigned auto_increment primary key not null,
    id_booking int unsigned not null,
	id_username int unsigned  not null,
	id_customer int unsigned not null,
    reservation_date datetime  not null,
	acceptatance_status boolean,
    completed boolean
);

create table booking (
	id_booking int unsigned primary key auto_increment,
	reservation_date datetime  not null,
	id_barbershop int unsigned not null,
	id_customer int unsigned not null,
	acceptatance_status boolean,
    completed boolean
);

create table promotion(
	id_username int unsigned auto_increment primary key,
	url_promotion blob not null, 
    duration char(10) not null ,
    email varchar(200) not null,
    date datetime not null
);

create table cut(
id_username int unsigned primary key auto_increment,
typeFormat blob not null,
url_cut blob, 
duration  char(10) not null 
);

create table barbershop_barber (
id_barber int unsigned not null,
id_barbershop int unsigned not null
);

/* Relacion de usarios con tipos de usuarios*/
alter table barber add constraint fk_username_barber foreign key (id_user) references username (id_username);
alter table barbershop add constraint fk_username_barbershop foreign key (id_user) references username (id_username);
alter table customer add constraint fk_username_customer foreign key (id_user) references username (id_username);

/* Relacion de reserva con cliente */
alter table booking add constraint fk_booking_customer foreign key (id_booking) references customer (id_user);

/* Relacion de cita con barbero */
alter table appointment add constraint fk_appointment_barber foreign key (id_appointment) references barber (id_user);

/* Relacion de cita con reserva */
alter table appointment add constraint fk_appointment_booking foreign key (id_booking) references booking (id_booking);

/* Relacion de cita con usario servidor */
alter table appointment add constraint fk_appointment_username foreign key (id_username) references username (id_username);

/* Relacion de promocion con usario*/
alter table promotion add constraint fk_promotion_username foreign key (id_username) references username (id_username);

/* Relacion de cut con usario*/
alter table cut add constraint fk_cut_username foreign key (id_username) references username (id_username);

/* Relacion de muchos a muchos de barberos y barberias vinculados*/
alter table barbershop_barber add constraint fk_barbershop_barber_barberia foreign key (id_barbershop) references barbershop (id_user);
alter table barbershop_barber add constraint fk_barbershop_barber_barbershop foreign key (id_barber) references barber (id_user);

/* Relacion de catalogo y usuario*/
alter table catalogue add constraint fk_catalogue_barbershop foreign key (id_username) references username (id_username);

/* Relacion de hairstyles con catalogue*/
alter table catalogue add constraint fk_hairstyles_catalogue foreign key (id_hairstyle) references hairstyles (id_hairstyle);

