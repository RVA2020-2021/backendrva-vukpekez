--DROP TABLES
drop table if exists radnik cascade;
drop table if exists obrazovanje cascade;
drop table if exists sektor cascade;
drop table if exists preduzece cascade;

--DROP SEQUENCES
drop sequence if exists preduzece_seq;
drop sequence if exists obrazovanje_seq;
drop sequence if exists sektor_seq;
drop sequence if exists radnik_seq;

--CREATE TABLES
create table preduzece (
	id integer,
	naziv varchar(100),
	pib integer,
	sediste varchar(100),
	opis varchar(500)
);

create table obrazovanje (
	id integer,
	naziv varchar(100),
	stepen_strucne_spreme varchar(10),
	opis varchar(500)
);

create table sektor (
	id integer,
	naziv varchar(100),
	oznaka varchar(10),
	preduzece integer not null
);

create table radnik (
	id integer,
	ime varchar(50),
	prezime varchar(50),
	broj_lk integer,
	obrazovanje integer not null,
	sektor integer not null
);

--PRIMARY KEYS
alter table preduzece add constraint pk_preduzece primary key(id);
alter table obrazovanje add constraint pk_obrazovanje primary key(id);
alter table sektor add constraint pk_sektor primary key(id);
alter table radnik add constraint pk_radnik primary key(id);

create index idxpk_preduzece on preduzece(id);
create index idxpk_obrazovanje on obrazovanje(id);
create index idxpk_sektor on sektor(id);
create index idxpk_radnik on radnik(id);

--FOREIGN KEYS
alter table sektor add constraint fk_sektor_preduzece foreign key(preduzece) references preduzece on delete cascade;
alter table radnik add constraint fk_radnik_sektor foreign key(sektor) references sektor on delete cascade;
alter table radnik add constraint fk_radnik_obrazovanje foreign key(obrazovanje) references obrazovanje on delete cascade;

create index idxfk_sektor_preduzece on sektor(preduzece);
create index idxfk_radnik_sektor on radnik(sektor);
create index idxfk_radnik_obrazovanje on radnik(obrazovanje);

--CREATE SEQUENCES
create sequence preduzece_seq increment 1;
create sequence obrazovanje_seq increment 1;
create sequence sektor_seq increment 1;
create sequence radnik_seq increment 1;
