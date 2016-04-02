DROPPING ALL THE TABLES OVER FOREIGN KEY CONSTRAINTS:

SET FOREIGN_KEY_CHECKS = 0;
Drop table if exists Account;
Drop table if exists Achievement;
Drop table if exists Admin;
Drop table if exists Developer;
Drop table if exists FriendGroup;
Drop table if exists FriendsWith;
Drop table if exists Game;
Drop table if exists Genre;
Drop table if exists HasGenre;
Drop table if exists HasWorkTowards;
Drop table if exists InAchievement;
Drop table if exists OwnsGame;
Drop table if exists Player;
Drop table if exists Review;
Drop table if exists WithinGroup;
SET FOREIGN_KEY_CHECKS = 1;

INSERTING INTO TABLES

insert into Genre values ("Action");
insert into Genre values ("Adventure");
insert into Genre values ("Miscellaneous");
insert into Genre values ("Puzzle");
insert into Genre values ("Racing");
insert into Genre values ("Role-Playing");
insert into Genre values ("Shooter");
insert into Genre values ("Simulation");
insert into Genre values ("Sports");
insert into Genre values ("Strategy");
insert into Genre values ("Horror");

insert into Account values(1,"player1","1234","player");
insert into Account values(2,"player2","1234","player");
insert into Account values(3,"player3","1234","player");
insert into Account values(4,"player4","1234","player");
insert into Account values(5,"player5","1234","player");
insert into Account values(6,"dev1","1234","developer");
insert into Account values(7,"dev2","1234","developer");
insert into Account values(8,"dev3","1234","developer");
insert into Account values(9,"dev4","1234","developer");
insert into Account values(10,"dev5","1234","developer");
insert into Account values(11,"admin","1234","admin");

insert into Player values(1);
insert into Player values(2);
insert into Player values(3);
insert into Player values(4);
insert into Player values(5);
insert into Developer values(6);
insert into Developer values(7);
insert into Developer values(8);
insert into Developer values(9);
insert into Developer values(10);
insert into Admin values(11);

insert into FriendsWith values(1,6);
insert into FriendsWith values(2,7);
insert into FriendsWith values(3,8);
insert into FriendsWith values(4,9);
insert into FriendsWith values(1,10);

insert into FriendGroup values(1,"group1","first group",1,"2016/1/1");
insert into FriendGroup values(2,"group2","second group",6,"2016/2/3");
insert into FriendGroup values(3,"group3","third group",2,"2016/3/3");
insert into FriendGroup values(4,"group4","fourth group",7,"2016/4/4");
insert into FriendGroup values(5,"group5","fifth group",10,"2016/5/5");
insert into WithinGroup values(1,1);
insert into WithinGroup values(6,2);
insert into WithinGroup values(2,3);
insert into WithinGroup values(7,4);
insert into WithinGroup values(10,5);
insert into WithinGroup values(3,1);
insert into WithinGroup values(4,1);
insert into WithinGroup values(5,3);

insert into Game values(1,"game1","first game",6,50.99);
insert into Game values(2,"game2","second game",7,60.99);
insert into Game values(3,"game3","third game",8,70.99);
insert into Game values(4,"game4","fourth game",9,80.99);
insert into Game values(5,"game5","fifth game",6,90.99);
insert into HasGenre values(1,"Action");
insert into HasGenre values(2,"Adventure");
insert into HasGenre values(3,"Puzzle");
insert into HasGenre values(4,"Racing");
insert into HasGenre values(5,"Sprots");

insert into OwnsGame values(1,1,0,50.99);
insert into OwnsGame values(2,2,0,60.99);
insert into OwnsGame values(2,4,0,80.99);
insert into OwnsGame values(3,4,0,80.99);
insert into OwnsGame values(4,5,0,90.99);
insert into OwnsGame values(5,5,0,90.99);

insert into Review values(1,"Good Game",5,"2016/2/2",1,1);
insert into Review values(2,"bad Game",1,"2016/3/2",2,2);
insert into Review values(1,"Perfect Game",10,"2016/4/2",2,4);
insert into Review values(1,"Good",8,"2016/5/2",3,4);
insert into Review values(1,"Ok Game",8,"2016/6/2",4,5);

insert into Achievement values(1,"Kill everyone","kill",100,1);
insert into Achievement values(2,"Find everyone","Find",10,2);
insert into Achievement values(3,"Solve Everyting","Solve",100,3);
insert into Achievement values(4,"Overtake everyone","Overtake",100,4);
insert into Achievement values(5,"Win championship","win",100,5);
insert into HasWorkTowards values(1,1,50,false);
insert into HasWorkTowards values(2,2,10,true);
insert into HasWorkTowards values(3,3,60,false);
insert into HasWorkTowards values(4,4,100,true);
insert into HasWorkTowards values(5,5,50,false);
insert into InAchievement values(1,1,1);
insert into InAchievement values(2,2,2);
insert into InAchievement values(3,3,3);
insert into InAchievement values(4,4,4);
insert into InAchievement values(5,5,5);



