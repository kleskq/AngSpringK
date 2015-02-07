insert into User (UserName,Password,Enabled) values('user','user','1');
insert into User (UserName,Password,Enabled) values('admin','admin','1');
insert into Userrole (Role,UserId) values ('ROLE_ADMIN','2');
insert into Userrole (Role,UserId) values ('ROLE_USER','1');
insert into Category  (CategoryName) values ('fast note');
insert into Category  (CategoryName) values ('programming');
insert into News (NewsId,link,NewsTitle,NewsText,NewsImageUrl,CreateDate,UserId,news,MINUSRATING,PLUSRATING) values ('1','1233','title1','text','google.pl','2014-12-27 15:40:46.959','1','1','2','2');
