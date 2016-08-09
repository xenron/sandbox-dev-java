-- MySQL dump 10.13  Distrib 5.6.11, for osx10.7 (x86_64)
--
-- Host: localhost    Database: productflow
-- ------------------------------------------------------
-- Server version	5.6.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `productflow`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `productflow` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `productflow`;

--
-- Table structure for table `APPROVER`
--

DROP TABLE IF EXISTS `APPROVER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `APPROVER` (
  `id` bigint(20) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `FK_USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ow4o3eu8k8he7bs8r55anwlp9` (`FK_USER_ID`),
  CONSTRAINT `FK_ow4o3eu8k8he7bs8r55anwlp9` FOREIGN KEY (`FK_USER_ID`) REFERENCES `USER_PROFILE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `APPROVER`
--

LOCK TABLES `APPROVER` WRITE;
/*!40000 ALTER TABLE `APPROVER` DISABLE KEYS */;
INSERT INTO `APPROVER` VALUES (12,'This promotion has been pre-approved.',6),(14,'This promotion has been pre-approved.',6),(16,'This promotion has been pre-approved.',6);
/*!40000 ALTER TABLE `APPROVER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CAMPAIGN`
--

DROP TABLE IF EXISTS `CAMPAIGN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CAMPAIGN` (
  `id` bigint(20) NOT NULL,
  `creationDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `FK_CREATED_USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_plj57bhj2gx6jq7pp6pnn0jr1` (`FK_CREATED_USER_ID`),
  CONSTRAINT `FK_plj57bhj2gx6jq7pp6pnn0jr1` FOREIGN KEY (`FK_CREATED_USER_ID`) REFERENCES `USER_PROFILE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CAMPAIGN`
--

LOCK TABLES `CAMPAIGN` WRITE;
/*!40000 ALTER TABLE `CAMPAIGN` DISABLE KEYS */;
INSERT INTO `CAMPAIGN` VALUES (8,'2015-02-25 02:28:41','simple marketing','Campaign 100',3),(9,'2015-02-25 02:28:41','another sales campaign','Advertising 200',3),(10,'2015-02-25 02:28:41','yet another direct marketing event','Marketing 300',3);
/*!40000 ALTER TABLE `CAMPAIGN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CAMPAIGN_PROMOTION`
--

DROP TABLE IF EXISTS `CAMPAIGN_PROMOTION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CAMPAIGN_PROMOTION` (
  `FK_CAMPAIGN_ID` bigint(20) NOT NULL,
  `FK_PROMOTION_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`FK_CAMPAIGN_ID`,`FK_PROMOTION_ID`),
  UNIQUE KEY `UK_1dpwvgbi1mlg17cgbvqg0ucu` (`FK_PROMOTION_ID`),
  CONSTRAINT `FK_6mof5akyl2jy9tuuwk9f9pf3s` FOREIGN KEY (`FK_CAMPAIGN_ID`) REFERENCES `CAMPAIGN` (`id`),
  CONSTRAINT `FK_1dpwvgbi1mlg17cgbvqg0ucu` FOREIGN KEY (`FK_PROMOTION_ID`) REFERENCES `PROMOTION` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CAMPAIGN_PROMOTION`
--

LOCK TABLES `CAMPAIGN_PROMOTION` WRITE;
/*!40000 ALTER TABLE `CAMPAIGN_PROMOTION` DISABLE KEYS */;
INSERT INTO `CAMPAIGN_PROMOTION` VALUES (8,11),(8,13),(8,15),(9,17),(9,18),(9,19),(9,20),(10,21),(10,22),(10,23),(10,24),(10,25);
/*!40000 ALTER TABLE `CAMPAIGN_PROMOTION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROMOTION`
--

DROP TABLE IF EXISTS `PROMOTION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROMOTION` (
  `id` bigint(20) NOT NULL,
  `approved` bit(1) NOT NULL,
  `creationDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `headline` varchar(255) DEFAULT NULL,
  `CAMPAIGN_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_b37kp1jfaf0yuy680rey7p5m9` (`CAMPAIGN_ID`),
  CONSTRAINT `FK_b37kp1jfaf0yuy680rey7p5m9` FOREIGN KEY (`CAMPAIGN_ID`) REFERENCES `CAMPAIGN` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROMOTION`
--

LOCK TABLES `PROMOTION` WRITE;
/*!40000 ALTER TABLE `PROMOTION` DISABLE KEYS */;
INSERT INTO `PROMOTION` VALUES (11,'\0','2015-02-25 02:28:41','promo description 1001','promo headline 1001',8),(13,'\0','2015-02-25 02:28:41','promo description 1002','promo headline 1002',8),(15,'\0','2015-02-25 02:28:41','promo description 1003','promo headline 1003',8),(17,'\0','2015-02-25 02:28:41','promo description 2001','promo headline 2001',9),(18,'\0','2015-02-25 02:28:41','promo description 2002','promo headline 2002',9),(19,'\0','2015-02-25 02:28:41','promo description 2003','promo headline 2003',9),(20,'\0','2015-02-25 02:28:41','promo description 2004','promo headline 2004',9),(21,'\0','2015-02-25 02:28:41','promo description 3001','promo headline 3001',10),(22,'\0','2015-02-25 02:28:41','promo description 3002','promo headline 3002',10),(23,'\0','2015-02-25 02:28:41','promo description 3003','promo headline 3003',10),(24,'\0','2015-02-25 02:28:41','promo description 3004','promo headline 3004',10),(25,'\0','2015-02-25 02:28:41','promo description 3005','promo headline 3005',10);
/*!40000 ALTER TABLE `PROMOTION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROMOTION_APPROVER`
--

DROP TABLE IF EXISTS `PROMOTION_APPROVER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROMOTION_APPROVER` (
  `FK_PROMOTION_ID` bigint(20) NOT NULL,
  `FK_APPROVER_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`FK_PROMOTION_ID`,`FK_APPROVER_ID`),
  UNIQUE KEY `UK_slreuwnqgvj71eygj4m3eqi3s` (`FK_APPROVER_ID`),
  CONSTRAINT `FK_32556q1hwl6pnx0sxyuoxhy5` FOREIGN KEY (`FK_PROMOTION_ID`) REFERENCES `PROMOTION` (`id`),
  CONSTRAINT `FK_slreuwnqgvj71eygj4m3eqi3s` FOREIGN KEY (`FK_APPROVER_ID`) REFERENCES `APPROVER` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROMOTION_APPROVER`
--

LOCK TABLES `PROMOTION_APPROVER` WRITE;
/*!40000 ALTER TABLE `PROMOTION_APPROVER` DISABLE KEYS */;
INSERT INTO `PROMOTION_APPROVER` VALUES (11,12),(13,14),(15,16);
/*!40000 ALTER TABLE `PROMOTION_APPROVER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SEQUENCE`
--

DROP TABLE IF EXISTS `SEQUENCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SEQUENCE` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SEQUENCE`
--

LOCK TABLES `SEQUENCE` WRITE;
/*!40000 ALTER TABLE `SEQUENCE` DISABLE KEYS */;
INSERT INTO `SEQUENCE` VALUES ('SEQ_GEN',0);
/*!40000 ALTER TABLE `SEQUENCE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_PROFILE`
--

DROP TABLE IF EXISTS `USER_PROFILE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_PROFILE` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `FK_USER_ROLE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tpso1ib5w6yf98xk42sqh3yya` (`FK_USER_ROLE_ID`),
  CONSTRAINT `FK_tpso1ib5w6yf98xk42sqh3yya` FOREIGN KEY (`FK_USER_ROLE_ID`) REFERENCES `USER_ROLE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_PROFILE`
--

LOCK TABLES `USER_PROFILE` WRITE;
/*!40000 ALTER TABLE `USER_PROFILE` DISABLE KEYS */;
INSERT INTO `USER_PROFILE` VALUES (3,'digital','user@products.com',1),(4,'digital','test@products.com',1),(5,'digital','developer@products.com',1),(6,'digital','admin@products.com',2),(7,'digital','manager@products.com',2);
/*!40000 ALTER TABLE `USER_PROFILE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_ROLE`
--

DROP TABLE IF EXISTS `USER_ROLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_ROLE` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_ROLE`
--

LOCK TABLES `USER_ROLE` WRITE;
/*!40000 ALTER TABLE `USER_ROLE` DISABLE KEYS */;
INSERT INTO `USER_ROLE` VALUES (1,'user'),(2,'manager');
/*!40000 ALTER TABLE `USER_ROLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (26);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-25  8:15:54
