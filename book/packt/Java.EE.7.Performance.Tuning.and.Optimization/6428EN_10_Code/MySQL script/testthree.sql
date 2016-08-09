-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.44-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema testthree
--

CREATE DATABASE IF NOT EXISTS testthree;
USE testthree;

--
-- Definition of table `contact_details`
--

DROP TABLE IF EXISTS `contact_details`;
CREATE TABLE `contact_details` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `street` varchar(45) NOT NULL,
  `home` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `zip_code` varchar(45) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contact_details`
--

/*!40000 ALTER TABLE `contact_details` DISABLE KEYS */;
INSERT INTO `contact_details` (`id`,`street`,`home`,`city`,`country`,`phone`,`zip_code`) VALUES 
 (1,'100','Pelican','Cairo','Egypt','1213223243','123456'),
 (2,'343','Home','Cairo','Egypt','2323232323','121323'),
 (3,'32','My Name','Port Said','Egypt','1212123233','232323');
/*!40000 ALTER TABLE `contact_details` ENABLE KEYS */;


--
-- Definition of table `empolyee`
--

DROP TABLE IF EXISTS `empolyee`;
CREATE TABLE `empolyee` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `title` varchar(45) NOT NULL,
  `salary` int(10) unsigned NOT NULL,
  `role` varchar(45) NOT NULL,
  `rating` int(10) unsigned NOT NULL,
  `contact` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_empolyee_1` (`contact`),
  CONSTRAINT `FK_empolyee_1` FOREIGN KEY (`contact`) REFERENCES `contact_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `empolyee`
--

/*!40000 ALTER TABLE `empolyee` DISABLE KEYS */;
INSERT INTO `empolyee` (`id`,`name`,`title`,`salary`,`role`,`rating`,`contact`) VALUES 
 (1001,'Osama','Mr.',1000,'SW Eng',3,1),
 (1002,'Ahmed','Dr.',2000,'PM',4,2),
 (1003,'Rasha','Dr.',1500,'GM',9,3);
/*!40000 ALTER TABLE `empolyee` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
