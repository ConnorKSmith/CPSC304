create table Account (
	userID integer auto_increment,
	userName varchar(30) not null unique,
	password varchar(30) not null,
	description varchar(400),
	primary key(userID)
)

create table FriendsWith (
	userID1 integer,
	userID2 integer,
	foreign key(userID1) references Account(userID) on delete cascade on update cascade,
	foreign key(userID2) references Account(userID) on delete cascade on update cascade
)

create table FriendGroup(
    gID integer auto_increment,
    groupName varchar(30) not null unique,
    groupDesc varchar(400),
    creatorUserID integer,
    dateCreated Date not null,
    primary key(gID),
    foreign key(creatorUserID) references Account(userID) on delete cascade on update cascade 
)

create table WithinGroup(
    memberUserID integer,
    withinGroupID integer,
    foreign key(memberUserID) references Account(userID) on delete cascade on update cascade,
    foreign key(withinGroupID) references FriendGroup(gID) on delete cascade on update cascade
)

create table Player(
    playerID integer,
    primary key(playerID),
    foreign key(playerID) references Account(userID) on delete cascade on update cascade
)

create table Developer(
    developerID integer,
    primary key(developerID),
    foreign key(developerID) references Account(userID) on delete cascade on update cascade
)

create table Admin(
    adminID integer,
    primary key(adminID),
    foreign key(adminID) references Account(userID) on delete cascade on update cascade
)

create table Game (
    gameID integer auto_increment,
    gName varchar(30) not null unique,
    gDescription varchar(1000),
    creatorID integer,
    currentPrice integer not null,
    primary key(gameID),
    foreign key(creatorID) references Developer(developerID) on delete cascade on update cascade
)

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
)

create table Genre (
    genre varchar(30) unique,
    primary key(genre)
)

create table OwnsGame (
    ownerID integer,
    gameID integer,
    playHours integer not null default 0,
    priceBoughtAt integer not null,
    foreign key(ownerID) references Player(playerID) on delete cascade on update cascade,
    foreign key(gameID) references Game(gameID) on delete cascade on update cascade
)

create table HasGenre (
    gameID integer,
    genre varchar(30),
    foreign key(gameID) references Game(gameID) on delete cascade on update cascade,
    foreign key(genre) references Genre(genre) on delete cascade on update cascade
)

create table Achievement (
    aID integer auto_increment,
    aDesc varchar(200),
    aName varchar(30) not null,
    totalNeeded integer not null,
    gameID integer,
    foreign key (gameID) references Game(gameID) on delete cascade on update cascade,
    primary key(aID)
)

create table HasWorkTowards (
    playerID integer,
    aID integer,
    progress integer not null,
    isComplete Boolean default false,
    foreign key (playerID) references Player(playerID) on delete cascade on update cascade,
    foreign key (aID) references Achievement(aID) on delete cascade on update cascade
)

create table InAchievement (
    playerID integer,
    aID integer,
    gameID integer,
    foreign key(playerID) references Player(playerID) on update cascade on delete cascade,
    foreign key(aID) references Achievement(aID) on update cascade on delete cascade,
    foreign key(gameID) references Game(gameID) on update cascade on delete cascade
)
