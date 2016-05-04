create database buss;
use buss;

drop table bokning;
drop table resa;
drop table stad;
drop table kund;

create table Kund (
PersonNR integer,
Namn varchar(30) not null,
Email varchar(50) not null,
Adress varchar(50) not null,
Telefon varchar(20) not null,
primary key (PersonNR));

create table Stad (
namn varchar(40),
land varchar(40) not null,
valuta varchar(20) not null,
språk varchar(40) not null,
primary key (namn)
);

create table Resa (
resID integer auto_increment,
datum date not null,
vecka integer not null,
platser integer not null,
pris integer not null,
veckodag varchar(7) not null,
avgångstid time not null,
ankomstid time not null,
till varchar(40),
från varchar(40),
foreign key (till) references Stad(namn),
foreign key (från) references Stad(namn),
primary key (resID)
);



create table Bokning (
PersonNR integer,
resID integer,
platser integer not null,
primary key(resID, PersonNR),
foreign key (PersonNR) references Kund(PersonNR),
foreign key (resID) references Resa(resID)
);

