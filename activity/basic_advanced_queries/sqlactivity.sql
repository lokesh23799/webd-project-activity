create database sql_activityday4;
use sql_activityday4;
create table productions
(
Productionid int NOT NULL PRIMARY KEY,
Productioname varchar(30),
Address varchar(40),
Dateofstarted YEAR,
Ownername varchar(20),
CHECK (Productionid<10000)
);
INSERT INTO productions VALUES(9091,"Arkamediaworks","Hyderabad",2001,"Shobu Yarlagadda");
INSERT INTO productions VALUES(8892,"Lyca Productions","Chennai",2014,"Subaskaran");
INSERT INTO productions VALUES(1010,"Hari Om Entertainment","Mumbai",2008,"Akshay Kumar");
INSERT INTO productions VALUES(1988,"Red Chillies Entertainment","Mumbai",2003,"Shah Ruck");
INSERT INTO productions VALUES(1899,"Viacom 18 Studios","Mumbai",2008,"Ajit Andhare");
INSERT INTO productions VALUES(7882,"DVV Entertainments","Hyderabad",1993,"DVV Danayya");
INSERT INTO productions VALUES(6773,"Homable Films","Bangalore",1995,"Vijay");
INSERT INTO productions VALUES(7682,"Mythri Movie Makers","Hyderabad",2015,"Naveen Yerneni");
INSERT INTO productions VALUES(1854,"Junglee Pictures","Mumbai",2014,"Vineet Jain");
INSERT INTO productions VALUES(2341,"CRM","Bangalore",2017,"Manohar");
INSERT INTO productions VALUES(1111,"STP","Chennai",2018,"Sree");
select * from productions;

create table movie
(
Movieid int NOT NULL PRIMARY KEY,
Moviename varchar(30),
Heroname varchar(30),
Heroine varchar(30),
Releaseddate DATE,
Language varchar(15),
Length int,
Movietype varchar(25),
Productionid int,
FOREIGN KEY (Productionid) REFERENCES productions(Productionid),
CHECK (Movieid<10000),
CHECK (Length>9 OR Length<100)
);

INSERT INTO movie VALUES(201,"Bahubali-The Beginning","Prabhas","Tamannah",'2015-07-10',"Telugu",21,"Drama Fantasy",9091);
INSERT INTO movie VALUES(501,"2.0","Rajnikanth","Amy",'2018-11-29',"Tamil",20,"Scientific",8892);
INSERT INTO movie VALUES(577,"Aval","Siddharth","Andrea",'2017-11-03',"Tamil",14,"Horror",1899);
INSERT INTO movie VALUES(101,"Holiday","Akshay Kumar","Sonakshi",'2014-06-06',"Hindi",15,"Crime Thriller",1010);
INSERT INTO movie VALUES(151,"Zero","Shah Ruck","Katrina Kaif",'2018-12-21',"Hindi",16,"Scientific",1988);
INSERT INTO movie VALUES(131,"Padmavat","Shahid Kapoor","Deepika Padukone",'2018-01-25',"Hindi",21,"Drama Epic",1899);
INSERT INTO movie VALUES(146,"Andhadhun","Ayushmann","Radika Apte",'2018-10-05',"Hindi",16,"Crime Thriller",1899);
INSERT INTO movie VALUES(231,"Bharath Ane nenu","Mahesh Babu","Kiara",'2018-04-20',"Telugu",15,"Thriller",7882);
INSERT INTO movie VALUES(244,"Gruham","Siddharth","Andrea",'2018-11-17',"Telugu",14,"Horror",1899);
INSERT INTO movie VALUES(337,"KGF chapter 1","Yash","Srinithi Shetty",'2018-12-21',"Kannada",21,"Action Thriller",6773);
INSERT INTO movie VALUES(224,"Rangasthalam","Ram Charan","Samatha",'2018-03-30',"Telugu",17,"Drama Period",7682);
INSERT INTO movie VALUES(136,"Badhaai Ho","Ayushmann","Neena",'2018-10-18',"Hindi",14,"Drama Comedy",1854);
INSERT INTO movie VALUES(441,"The Villain","Sudeep","Amy",'2018-10-18',"Kannada",16,"Drama",2341);
INSERT INTO movie VALUES(206,"Maryada Ramanna","Sunil","Saloni",'2010-07-23',"Telugu",19,"Drama",9091);
INSERT INTO movie VALUES(211,"Khaidi No. 150","chiranjeevi","Kajal",'2017-01-17',"Telugu",20,"Drama Thriller",8892);
INSERT INTO movie VALUES(188,"Rangoon","Saif Ali Khan","Kangana",'2017-02-24',"Hindi",15,"Drama",1899);
INSERT INTO movie VALUES(189,"The House Next Door","Siddharth","Andrea",'2017-11-10',"Hindi",14,"Horror",1899);
INSERT INTO movie VALUES(267,"Anaganaga O Dheerudu","Siddharth","Shruthi",'2014-01-14',"Telugu",16,"Fantasy",9091);


select * from movie;

#1-------------------------
SELECT Moviename,Movietype
FROM movie
WHERE Movietype LIKE 'Drama%';

#2-------------------------
SELECT Moviename,Heroname
FROM movie
WHERE Heroname='Ayushmann'; 


#3----------------------
 SELECT count(Moviename)
FROM movie
WHERE Length>18;
------------------------

#4------------------------------   
SELECT Moviename,MIN(Length) as min_length from movie;


 #5-----------------------------
 SELECT *
FROM movie
WHERE Language LIKE 'T%';

 #6--------------------------------------------- 
 SELECT Moviename,Heroname,Heroine, MAX(Length) as max_length from movie;
 
 #7-----------------------------------------------------------------------------
 SELECT Moviename,Heroname,Heroine 
FROM movie
WHERE
Releaseddate > '2018-03-15';

#8---------------------------------
SELECT  Moviename,count(Moviename)
FROM movie
WHERE Movietype='Thriller';

#9----------------------------------------
SELECT COUNT(Moviename)
FROM movie
WHERE
Releaseddate < '2018-03-15';

#10------------------------------------
SELECT Releaseddate
FROM movie
WHERE Moviename='Zero';

#11-------------------------------------
SELECT Heroname FROM movie where Heroine='Amy';

#12---------------------------------------
SELECT COUNT(*) FROM movie WHERE MONTH(Releaseddate) = '10';

#13-------------------------------------
SELECT Moviename FROM movie group by Language having COUNT(language)>2;

#14---------------------------------
SELECT Moviename FROM movie WHERE YEAR(Releaseddate) = '2018';

#15---------------------------------
SELECT UPPER(Moviename) From movie;

#16----------------------------------
SELECT Moviename FROM movie ORDER BY MONTH(Releaseddate);

#17--------------------------------
SELECT Heroname
FROM movie WHERE Language=ALL(SELECT Language FROM movie);



#advancedsql

#1-----------------------------
SELECT productions.Productionid, productions.Productioname, COUNT(movie.Moviename) FROM movie INNER JOIN productions ON productions.Productionid = movie.Productionid GROUP BY productions.Productionid;

#2---------------------
SELECT productions.Productioname, productions.Ownername FROM movie INNER JOIN productions ON productions.Productionid = movie.Productionid GROUP BY productions.Productionid HAVING COUNT(movie.Productionid)>2;

#3------------------------
#SELECT productions.Productioname, productions.Ownername FROM movie INNER JOIN productions ON productions.Productionid = movie.Productionid group by productions.Productionid having MAX(COUNT(movie.Moviename));

#4--------------------------
SELECT movie.Moviename, movie.Heroname, productions.Productioname from movie inner join productions ON productions.Productionid = movie.Productionid where productions.Ownername = "Subaskaran";

#5----------------------------
SELECT movie.Moviename, movie.Heroname  from movie inner join productions ON productions.Productionid = movie.Productionid where movie.Productionid like "%82";

#6-----------------------------
SELECT productions.Productioname, productions.Ownername FROM movie INNER JOIN productions ON productions.Productionid = movie.Productionid GROUP BY productions.Productionid HAVING COUNT(movie.Productionid)="NULL";

#7-----------------------------------
SELECT productions.Productioname, productions.Ownername FROM movie INNER JOIN productions ON productions.Productionid = movie.Productionid GROUP BY movie.Language 













