/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `user_table` (
	`uid` int (8),
	`uname` varchar (96),
	`password` varchar (96),
	`sex` int (1),
	`phone` varchar (33),
	`email` varchar (192)
); 
insert into `user_table` (`uid`, `uname`, `password`, `sex`, `phone`, `email`) values('101','流浪的小狗','123456','1','15577757997','wanderingDog@163.com');
insert into `user_table` (`uid`, `uname`, `password`, `sex`, `phone`, `email`) values('102','测试账号','123456','1','15111111111','testUser@qq.com');
