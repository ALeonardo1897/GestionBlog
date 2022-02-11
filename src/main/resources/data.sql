--AUTHOR
INSERT INTO AUTHORS(name,email,phone,birth_date) VALUES ('Alvaro Leonardo','ALeonardoG18@gmail.com','+51939681613','1997-11-18');
INSERT INTO AUTHORS(name,email,phone,birth_date) VALUES ('Martin Gutierrez','gutierrez1897@gmail.com','+51939681613','2010-11-18');


--BLOG
INSERT INTO BLOGS(description,name,status,url,author_id) values ('Blog personal de mi cachorra','Masha','ACTIVE','www.masha.com',1);
INSERT INTO BLOGS(description,name,status,url,author_id) values ('Blog personal de mi cachorra','Aisha','INACTIVE','www.aisha.com',1);

--POST
INSERT INTO POSTS(title,date,status,content,blog_id) values ('Mi primer baño','2020-02-10 01:00:00', 'PUBLISHED','Les comparto mi primer baño.',1);
INSERT INTO POSTS(title,date,status,content,blog_id) values ('Mi segundo baño','2020-02-10 01:00:00', 'DRAFT','Les comparto mi segundo baño.',1);