/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `music_table` (
	`mid` int (11),
	`mname` varchar (192),
	`author` varchar (96),
	`style` int (3),
	`uploader` int (8),
	`playtimes` int (11),
	`uploaddate` date ,
	`lyric` varchar (192),
	`status` int (1)
); 
