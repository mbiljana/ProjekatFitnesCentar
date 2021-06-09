insert into ADMINISTRATOR(id,aktivan,da_li_je_registrovan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (1,'true','true','1999-05-02','mbiljana99@gmail.com','Biljana','mbiljana','biljana1','Marinkov','2554554',0);
insert into ADMINISTRATOR(id,aktivan,da_li_je_registrovan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (2,'true','true','1997-01-01','markoal@gmail.com','Marko','almarko','123456','Aleksic','065487577',0);
insert into ADMINISTRATOR(id,aktivan,da_li_je_registrovan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (3,'true','true','1994-02-03','marijana@gmail.com','Marijana','pmarijana','mp1212','Peric','062545875',0);

insert into CLAN(id,aktivan,da_li_je_registrovan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (10,'true','true','1994-02-03','marijana@gmail.com','Marijana','pmarijana','mp1212','Peric','062545875',2);
insert into CLAN(id,aktivan,da_li_je_registrovan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (11,'true','true','1994-02-03','biljana@gmail.com','Biljana','mbiljna','bbbb','Marinkov','062545875',2);

insert into TRENER(id,aktivan,da_li_je_registrovan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (20,'true','true','1994-02-03','trener1@gmail.com','Aleksa','aleksam','alex','Mirkov','062545875',1);
insert into TRENER(id,aktivan,da_li_je_registrovan,DATUMRODJENJA,email,ime,korisnickoime,lozinka,prezime,telefon,uloga)
values (21,'true','true','1994-02-03','trener2@gmail.com','Milena','milenad ','md','Dragic','062545875',1);

insert into TRENING(id,naziv,opis,tiptreninga,trajanje)
values (30,'Kardio','Kardio trening za zene','KARDIO','30 min');
insert into TRENING(id,naziv,opis,tiptreninga,trajanje)
values (31,'Joga','Joga za zene','JOGA','60 min');
insert into TRENING(id,naziv,opis,tiptreninga,trajanje)
values (32,'Pilates','Pilates lagani trening','PILATES','70 min');
insert into TRENING(id,naziv,opis,tiptreninga,trajanje)
values (33,'Crossfit','Tezak trening','CROSSFIT','70 min');
insert into TRENING(id,naziv,opis,tiptreninga,trajanje)
values (34,'Crossfit','Lagani crossfit','CROSSFIT','30 min');
insert into TRENING(id,naziv,opis,tiptreninga,trajanje)
values (35,'Joga','Jutarnja joga','JOGA','30 min');

insert into FITNESS_CENTAR(id,naziv_centra,adresa_centra,broj_telefona_centrale,email_centra)
values (101,'BeFit','Vojvodjanskih Brigada 10','0698574584','befit1@yahoo.com');



