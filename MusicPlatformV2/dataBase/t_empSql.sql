/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `t_emp` (
	`empno` int (10),
	`ename` varchar (90),
	`job` varchar (60),
	`phone` char (33),
	`email` varchar (60),
	`hiredate` date ,
	`deptno` bigint (20)
); 
insert into `t_emp` (`empno`, `ename`, `job`, `phone`, `email`, `hiredate`, `deptno`) values('1003','李颖','产品','15211111111','gradyLee@gmail.com','2019-06-15','30');
insert into `t_emp` (`empno`, `ename`, `job`, `phone`, `email`, `hiredate`, `deptno`) values('1004','陈凯峰','运营','15811111111','chenkf@qq.com','2019-06-15','40');
insert into `t_emp` (`empno`, `ename`, `job`, `phone`, `email`, `hiredate`, `deptno`) values('1005','全利剑','研发','13122222222','bob@mail.com','2019-05-29','20');
insert into `t_emp` (`empno`, `ename`, `job`, `phone`, `email`, `hiredate`, `deptno`) values('1006','胥珂铭','研发','15111533991','keming_xu@163.com','2019-05-28','10');
insert into `t_emp` (`empno`, `ename`, `job`, `phone`, `email`, `hiredate`, `deptno`) values('1007','梁非凡','产品','15252637426','feifanguo@163.com','2019-06-03','10');
insert into `t_emp` (`empno`, `ename`, `job`, `phone`, `email`, `hiredate`, `deptno`) values('1008','马云','研发','15111111111','mayun@qq.com','2019-06-15','50');
insert into `t_emp` (`empno`, `ename`, `job`, `phone`, `email`, `hiredate`, `deptno`) values('1009','余冰','产品','15122257666','yubing@163.com','2019-06-15','20');
