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

create table Account (
	userID integer auto_increment,
	userName varchar(30) not null unique,
	password varchar(30) not null,
	description varchar(400),
	primary key(userID),
    check (description<=400)
);

create table FriendsWith (
	userID1 integer,
	userID2 integer,
	foreign key(userID1) references Account(userID) on delete cascade on update cascade,
	foreign key(userID2) references Account(userID) on delete cascade on update cascade
);

create table FriendGroup(
    gID integer auto_increment,
    groupName varchar(30) not null unique,
    groupDesc varchar(400),
    creatorUserID integer,
    dateCreated Date not null,
    primary key(gID),
    foreign key(creatorUserID) references Account(userID) on delete cascade on update cascade 
);

create table WithinGroup(
    memberUserID integer,
    withinGroupID integer,
    foreign key(memberUserID) references Account(userID) on delete cascade on update cascade,
    foreign key(withinGroupID) references FriendGroup(gID) on delete cascade on update cascade
);

create table Player(
    playerID integer,
    primary key(playerID),
    foreign key(playerID) references Account(userID) on delete cascade on update cascade
);

create table Developer(
    developerID integer,
    primary key(developerID),
    foreign key(developerID) references Account(userID) on delete cascade on update cascade
);

create table Admin(
    adminID integer,
    primary key(adminID),
    foreign key(adminID) references Account(userID) on delete cascade on update cascade
);

create table Game (
    gameID integer auto_increment,
    gName varchar(30) not null unique,
    gDescription varchar(1000),
    creatorID integer,
    currentPrice integer not null,
    primary key(gameID),
    foreign key(creatorID) references Developer(developerID) on delete cascade on update cascade
);

create table Review (
    reviewID integer auto_increment,
    reviewDesc varchar(400) not null,
    rating integer not null,
    datePosted Date not null,
    reviewerID integer,
    gameReviewedID integer,
    primary key(reviewID),
    foreign key(reviewerID) references Account(userID) on delete cascade on update cascade,
    foreign key(gameReviewedID) references Game(gameID) on delete cascade on update cascade
);

create table Genre (
    genre varchar(30) unique,
    primary key(genre)
);

create table OwnsGame (
    ownerID integer,
    gameID integer,
    playHours integer not null default 0,
    priceBoughtAt integer not null,
    foreign key(ownerID) references Player(playerID) on delete cascade on update cascade,
    foreign key(gameID) references Game(gameID) on delete cascade on update cascade
);

create table HasGenre (
    gameID integer,
    genre varchar(30),
    foreign key(gameID) references Game(gameID) on delete cascade on update cascade,
    foreign key(genre) references Genre(genre) on delete cascade on update cascade
);

create table Achievement (
    aID integer auto_increment,
    aDesc varchar(200),
    aName varchar(30) not null,
    totalNeeded integer not null,
    gameID integer,
    foreign key (gameID) references Game(gameID) on delete cascade on update cascade,
    primary key(aID)
);

create table HasWorkTowards (
    playerID integer,
    aID integer,
    progress integer not null,
    isComplete Boolean default false,
    foreign key (playerID) references Player(playerID) on delete cascade on update cascade,
    foreign key (aID) references Achievement(aID) on delete cascade on update cascade
);

create table InAchievement (
    playerID integer,
    aID integer,
    gameID integer,
    foreign key(playerID) references Player(playerID) on update cascade on delete cascade,
    foreign key(aID) references Achievement(aID) on update cascade on delete cascade,
    foreign key(gameID) references Game(gameID) on update cascade on delete cascade
);

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

insert into Account values(1,"jimmy","1234","player");
insert into Account values(2,"jin","1234","player");
insert into Account values(3,"connor","1234","player");
insert into Account values(4,"thomas","1234","player");
insert into Account values(5,"carlos","1234","player");
insert into Account values(6,"tom","1234","developer");
insert into Account values(7,"jerry","1234","developer");
insert into Account values(8,"tiffany","1234","developer");
insert into Account values(9,"christina","1234","developer");
insert into Account values(10,"joy","1234","developer");
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

insert into FriendGroup values(1,"apple","group apple",1,"2016/1/1");
insert into FriendGroup values(2,"banana","banana yes",6,"2016/2/3");
insert into FriendGroup values(3,"love database","yeah 304",2,"2016/3/3");
insert into FriendGroup values(4,"waffles","group waffles",7,"2016/4/4");
insert into FriendGroup values(5,"vancouver","people from vancouver",10,"2016/5/5");
insert into WithinGroup values(1,1);
insert into WithinGroup values(6,2);
insert into WithinGroup values(2,3);
insert into WithinGroup values(7,4);
insert into WithinGroup values(10,5);
insert into WithinGroup values(3,1);
insert into WithinGroup values(4,1);
insert into WithinGroup values(5,3);

insert into Game values(1,"Street Fighters","This is an action game",6,50.99);
insert into Game values(2,"Adventure in Monkey Island","adventure with your monkey",7,60.99);
insert into Game values(3,"Sudoku","try our sudoku game",8,70.99);
insert into Game values(4,"forza","racing game",9,100);
insert into Game values(5,"NBA Live","lastest version of NBA Live",6,90.99);
insert into HasGenre values(1,"Action");
insert into HasGenre values(2,"Adventure");
insert into HasGenre values(3,"Puzzle");
insert into HasGenre values(4,"Racing");
insert into HasGenre values(5,"Sports");

insert into OwnsGame values(1,1,0,50.99);
insert into OwnsGame values(1,5,100,82.99);
insert into OwnsGame values(2,2,0,60.99);
insert into OwnsGame values(2,4,0,80.99);
insert into OwnsGame values(2,5,0,79.99);	
insert into OwnsGame values(3,3,0,75.99);
insert into OwnsGame values(3,4,0,80.99);
insert into OwnsGame values(4,4,0,40.20);
insert into OwnsGame values(4,5,0,90.99);
insert into OwnsGame values(5,5,0,90.99);

insert into Review values(1,"Good Game",5,"2016/2/2",1,1);
insert into Review values(2,"bad Game",1,"2016/3/2",2,2);
insert into Review values(3,"Perfect Game",10,"2016/4/2",2,4);
insert into Review values(4,"Good",8,"2016/5/2",3,4);
insert into Review values(5,"Ok Game",8,"2016/6/2",4,5);

insert into Achievement values(1,"Kill everyone","kill",100,1);
insert into Achievement values(2,"Find everyone","Find",10,2);
insert into Achievement values(3,"Solve Everyting","Solve",100,3);
insert into Achievement values(4,"Overtake everyone","Overtake",100,4);
insert into Achievement values(5,"Win championship","Win",100,5);
insert into Achievement values(6,"Dunk 10 times","Dunk",10,5);
insert into HasWorkTowards values(1,1,50,false);
insert into HasWorkTowards values(2,2,10,true);
insert into HasWorkTowards values(3,3,60,false);
insert into HasWorkTowards values(4,4,100,true);
insert into HasWorkTowards values(5,5,50,false);
insert into HasWorkTowards values(2,6,8,false);	
insert into HasWorkTowards values(5,6,10,true);	

insert into InAchievement values(1,1,1);
insert into InAchievement values(2,2,2);
insert into InAchievement values(3,3,3);
insert into InAchievement values(4,4,4);
insert into InAchievement values(5,5,5);
insert into InAchievement values(2,6,5);	
