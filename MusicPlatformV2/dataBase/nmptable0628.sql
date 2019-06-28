/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17 : Database - mysql
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mysql` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mysql`;

/*Table structure for table `music_table` */

DROP TABLE IF EXISTS `music_table`;

CREATE TABLE `music_table` (
  `mid` bigint(32) NOT NULL AUTO_INCREMENT,
  `mname` varchar(64) NOT NULL,
  `author` varchar(32) NOT NULL,
  `style` int(3) DEFAULT '0',
  `uploader` bigint(32) NOT NULL,
  `playtimes` int(11) DEFAULT '0',
  `uploaddate` date NOT NULL,
  `lyric` varchar(64) DEFAULT NULL,
  `status` int(1) DEFAULT '0',
  PRIMARY KEY (`mid`),
  KEY `uploader` (`uploader`),
  CONSTRAINT `music_table_ibfk_1` FOREIGN KEY (`uploader`) REFERENCES `user_table` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `music_table` */

insert  into `music_table`(`mid`,`mname`,`author`,`style`,`uploader`,`playtimes`,`uploaddate`,`lyric`,`status`) values (1,'测试音乐.mp3','胥珂铭',2,101,0,'2019-06-28',NULL,0),(2,'测试音乐2.mp3','胥珂铭2',2,101,0,'2019-06-28',NULL,1);

/*Table structure for table `musiclist_ music_relat_table` */

DROP TABLE IF EXISTS `musiclist_ music_relat_table`;

CREATE TABLE `musiclist_ music_relat_table` (
  `mlid` bigint(32) NOT NULL,
  `mid` bigint(32) NOT NULL,
  PRIMARY KEY (`mlid`,`mid`),
  KEY `mid` (`mid`),
  CONSTRAINT `musiclist_ music_relat_table_ibfk_1` FOREIGN KEY (`mlid`) REFERENCES `musiclist_table` (`mlid`),
  CONSTRAINT `musiclist_ music_relat_table_ibfk_2` FOREIGN KEY (`mid`) REFERENCES `music_table` (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `musiclist_ music_relat_table` */

/*Table structure for table `musiclist_table` */

DROP TABLE IF EXISTS `musiclist_table`;

CREATE TABLE `musiclist_table` (
  `mlid` bigint(32) NOT NULL AUTO_INCREMENT,
  `uid` bigint(32) NOT NULL,
  `mlname` varchar(32) NOT NULL,
  `detail` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`mlid`),
  KEY `uid` (`uid`),
  CONSTRAINT `musiclist_table_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user_table` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `musiclist_table` */

/*Table structure for table `under_evaluate_music_table` */

DROP TABLE IF EXISTS `under_evaluate_music_table`;

CREATE TABLE `under_evaluate_music_table` (
  `evid` bigint(32) NOT NULL,
  `mid` bigint(32) NOT NULL,
  `status` int(1) NOT NULL,
  `result` varchar(32) NOT NULL,
  PRIMARY KEY (`evid`),
  KEY `mid` (`mid`),
  CONSTRAINT `under_evaluate_music_table_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `music_table` (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `under_evaluate_music_table` */

/*Table structure for table `user_table` */

DROP TABLE IF EXISTS `user_table`;

CREATE TABLE `user_table` (
  `uid` bigint(32) NOT NULL AUTO_INCREMENT,
  `uname` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `sex` int(1) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

/*Data for the table `user_table` */

insert  into `user_table`(`uid`,`uname`,`password`,`sex`,`phone`,`email`,`status`) values (101,'流浪的小狗','123456',1,'15577757997','wanderingDog@163.com',1),(102,'测试账号','123456',1,'15111111111','testUser@qq.com',1),(103,'testAccount','123456',1,'15122255555','testAccount@gmail.com',0),(104,'Jacob','123456',0,'13674825566','jacobWorkEmail@gmail.com',0),(105,'keming','123',1,'15111422198','keming_xu@163.com',1),(106,'testAccount2','123456',0,'15111411198','testAccount2@163.com',1),(107,'testAccount3','123456',0,'15111411298','testAccount3@qq.com',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
