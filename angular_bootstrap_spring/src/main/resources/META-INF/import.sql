insert into User (UserName,Password,Enabled) values('user','user','1');
insert into User (UserName,Password,Enabled) values('admin','admin','1');
insert into Userrole (Role,UserId) values ('ROLE_ADMIN','2');
insert into Userrole (Role,UserId) values ('ROLE_USER','1');
insert into Category  (CategoryName) values ('fast note');
insert into Category  (CategoryName) values ('programming');
insert into News (link,NewsTitle,NewsText,NewsImageUrl,CreateDate,UserId,news,MINUSRATING,PLUSRATING) values ('1233','Smieszny tytuł','Treść posta też bardzo zabawna, lorem ipsum dolor sit amed ounertnekr jewfsdkjf fds ffewr','https://pbs.twimg.com/media/B6eIhnkIYAAQdFz.jpg:large','2014-12-27 15:40:46.959','1','1','2','2');
insert into Rate(Rating,UserId,NewsId) values ('TRUE','1','1');