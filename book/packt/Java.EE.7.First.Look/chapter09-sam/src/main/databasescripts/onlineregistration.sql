/*
SQLyog Community Edition- MySQL GUI v6.52
MySQL - 5.0.22-community-nt : Database - onlineregistration
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

create database if not exists `onlineregistration`;

USE `onlineregistration`;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `ID` varchar(32) NOT NULL,
  `NAME` varchar(30) default NULL,
  `NBRLEVEL` int(11) default NULL,
  `PHONE` varchar(10) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `department` */

insert  into `department`(`ID`,`NAME`,`NBRLEVEL`,`PHONE`) values ('GI','Computer Engineering',10,'9958321');

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `ID` varchar(32) NOT NULL,
  `FIRSTNAME` varchar(30) default NULL,
  `LASTNAME` varchar(30) default NULL,
  `USERLOGIN` varchar(10) default NULL,
  `USERROLE` varchar(10) default NULL,
  `TYPE` varchar(30) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `person` */

insert  into `person`(`ID`,`FIRSTNAME`,`LASTNAME`,`USERLOGIN`,`USERROLE`,`TYPE`) values ('PS1613379','Edmon','BERTOS LU','ebertos','FDK','APPUSER'),('PS8613079','Adwin','LEWIS CLEF','adwiner','ADMIN','APPUSER');

/*Table structure for table `realm_groups` */

DROP TABLE IF EXISTS `realm_groups`;

CREATE TABLE `realm_groups` (
  `GROUPID` varchar(20) NOT NULL,
  `DESCRIPTION` varchar(45) default NULL,
  PRIMARY KEY  (`GROUPID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `realm_groups` */

insert  into `realm_groups`(`GROUPID`,`DESCRIPTION`) values ('administrator','Administrator group');

/*Table structure for table `realm_users` */

DROP TABLE IF EXISTS `realm_users`;

CREATE TABLE `realm_users` (
  `USERID` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  PRIMARY KEY  (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `realm_users` */
/*The password 8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918 is equal to 'admin' in clear*/
insert  into `realm_users`(`USERID`,`PASSWORD`) values ('naf','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `ID` varchar(32) NOT NULL,
  `FIRSTNAME` varchar(30) default NULL,
  `LASTNAME` varchar(30) default NULL,
  `BIRTHDATE` date default NULL,
  `PHONE` varchar(10) default NULL,
  `EMAIL` varchar(60) default NULL,
  `DEPARTID` varchar(15) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student` */

insert  into `student`(`ID`,`FIRSTNAME`,`LASTNAME`,`BIRTHDATE`,`PHONE`,`EMAIL`,`DEPARTID`) values ('7315489','Bernard','SOYER','2013-07-15','9658421','bsoyer@hotmail.com','GI'),('8964723','Betoszos','LASCARIS','2013-07-18','96842347','lascaris@yahoo.fr','GE');

/*Table structure for table `users_groups` */

DROP TABLE IF EXISTS `users_groups`;

CREATE TABLE `users_groups` (
  `GROUPID` varchar(20) NOT NULL,
  `USERID` varchar(255) NOT NULL,
  PRIMARY KEY  (`GROUPID`,`USERID`),
  KEY `USERID` (`USERID`),
  KEY `GROUPID` (`GROUPID`),
  CONSTRAINT `GROUPID` FOREIGN KEY (`GROUPID`) REFERENCES `realm_groups` (`GROUPID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `USERID` FOREIGN KEY (`USERID`) REFERENCES `realm_users` (`USERID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `users_groups` */

insert  into `users_groups`(`GROUPID`,`USERID`) values ('administrator','naf');

/* Procedure structure for procedure `getStudentsName` */

/*!50003 DROP PROCEDURE IF EXISTS  `getStudentsName` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`sonar`@`%localhost` PROCEDURE `getStudentsName`()
BEGIN
      SELECT ID,LASTNAME FROM STUDENT ORDER BY LASTNAME ASC;
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
