create database libraryList;

use libraryList;

create table listTamil(
bookID int not null,
bookname varchar(60)

);

select *from  listTamil; 

insert into listTamil  values(1,'Seevaka chinthamani');
 insert into listTamil values(2,'Silappathikaram');
 insert into listTamil values(3,'Manimekalai');
 insert into listTamil values(4,'Kundalakesi');
 insert into listTamil values(5,'Valayapathi');
  insert into listTamil values(6,'Ramayanam');
   insert into listTamil values(7,'Kambaramayanam');
      insert into listTamil values(8,'Ponniyin selvan');
    insert into listTamil values(9,'Karuvaachi kaaviyam');
     insert into listTamil values(10,'Thanneer desam');




create table listEnglish(
bookID int not null,
bookname varchar(60)

);

select *from  listEnglish; 

insert into listEnglish  values(1,'Sherlock holmes');
 insert into listEnglish values(2,'Half girlfriend');
 insert into listEnglish values(4,'Rebel Nation');
 insert into listEnglish values(5,'Rich dad Poor dad');
  insert into listEnglish values(6,'Beyond the ordinary');
   insert into listEnglish values(7,'Harry potter');
      insert into listEnglish values(8,'Alice the wonderland');
    insert into listEnglish values(9,'The Great Gatsby');
     insert into listEnglish values(10,'The Lord of the Rings');
