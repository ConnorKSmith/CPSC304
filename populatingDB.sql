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

