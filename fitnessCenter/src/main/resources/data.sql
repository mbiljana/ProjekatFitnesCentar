insert into ADMINISTRATOR(id,aktivan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (1,true,'1999-05-02','mbiljana99@gmail.com','Biljana','mbiljana','biljana1','Marinkov','2554554',0);
insert into ADMINISTRATOR(id,aktivan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (2,true,'1997-01-01','markoal@gmail.com','Marko','almarko','123456','Aleksic','065487577',0);
insert into ADMINISTRATOR(id,aktivan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (3,true,'1994-02-03','marijana@gmail.com','Marijana','pmarijana','mp1212','Peric','062545875',0);
insert into CLAN(id,aktivan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (9,true,'1992-01-01','pavlebugarski@gmail.com','Pavle','pavlebugarski','fotoaparat','Bugarski','064587777',2);
insert into CLAN(id,aktivan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (10,true,'1999-06-01','ksenijas@gmail.com','Ksenija','ksenijas','ksenija','Stojkov','06845165',2);
insert into CLAN(id,aktivan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (11,true,'1999-04-21','branislavar999@gmail.com','Branislava','branislavar','radisic123','Radisic','068465865',2);
insert into CLAN(id,aktivan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (12,true,'1995-01-01','milanad@gmail.com','Milana','draganovm','draganovmilana1','Draganov','0644865115',2);
insert into FITNESS_CENTAR(id,adresa_centra,broj_telefona_centrale, email_centra,naziv_centra)
values (21,'Branka Radicevica 15','02548755','fitnesscentar1@gmail.com','Be fit 1');
insert into FITNESS_CENTAR(id,adresa_centra,broj_telefona_centrale, email_centra,naziv_centra)
values (22,'Danila Kisa 26','02548756','fitnesscentar2@gmail.com','Be fit 2');
insert into FITNESS_CENTAR(id,adresa_centra,broj_telefona_centrale, email_centra,naziv_centra)
values (23,'Maksima Gorkog 12','02548757','fitnesscentar3@gmail.com','Be fit 3');
insert into TRENING(id,naziv,opis,tip_treninga,trajanje,trener_id)
values (25,'Yoga za zene','Opustajuci trening za rastezanje tela i oslobadjannje od stresa',0,'60 min',45);
insert into TRENING(id,naziv,opis,tip_treninga,trajanje,trener_id)
values (26,'Cardio za zene','Kratki treninzi za gubljenje masnih naslaga',2,'30 min',43);
insert into TRENER(id,aktivan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga,prosecna_ocena,fitness_centar_id)
values (43,true,'1999-05-23','trener1@gmail.com','Miroslav','trener1','16843','Mirkovic','124554',1,4.2,21);
insert into TRENER(id,aktivan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga,prosecna_ocena,fitness_centar_id)
values (44,true,'1998-05-25','trener2@gmail.com','Ana','trener2','anaana','Aleksic','84655445',1,4.5,22);
insert into TRENER(id,aktivan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga,prosecna_ocena,fitness_centar_id)
values (45,true,'1995-01-21','trener3@gmail.com','Aleksandar','trener3','hhyyjhg','Jankovic','05545245',1,3.5,23);

insert into LISTA_TRENINGA(id,broj_prijavljenih)
values (31,16);
insert into LISTA_TRENINGA(id,broj_prijavljenih)
values (32,24);
insert into LISTA_TRENINGA(id,broj_prijavljenih)
values (33,9);

insert into OCENA_TRENINGA(id,ocena,trenig_id)
values (101,5.0,25);
insert into OCENA_TRENINGA(id,ocena,trenig_id)
values (102,4.0,26);
