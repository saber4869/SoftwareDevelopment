CREATE DATABASE  IF NOT EXISTS `SoftwareDevelopment` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `SoftwareDevelopment`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: SoftwareDevelopment
-- ------------------------------------------------------
-- Server version	5.7.21

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
-- Table structure for table `equipmentTable`
--

DROP TABLE IF EXISTS `equipmentTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipmentTable` (
  `itemID` int(11) NOT NULL,
  `equipmentName` varchar(45) DEFAULT NULL,
  `moveAdd` int(11) DEFAULT NULL,
  `fightAdd` int(11) DEFAULT NULL,
  `armorAdd` int(11) DEFAULT NULL,
  `healthAdd` int(11) DEFAULT NULL,
  `shootAdd` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  PRIMARY KEY (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipmentTable`
--

LOCK TABLES `equipmentTable` WRITE;
/*!40000 ALTER TABLE `equipmentTable` DISABLE KEYS */;
INSERT INTO `equipmentTable` VALUES (1,'helmet',NULL,NULL,3,NULL,NULL,30),(2,'coat',NULL,NULL,5,NULL,NULL,50),(3,'shoes',2,NULL,NULL,NULL,NULL,30),(4,'sword',NULL,3,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `equipmentTable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemTable`
--

DROP TABLE IF EXISTS `itemTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemTable` (
  `itemID` int(11) NOT NULL AUTO_INCREMENT,
  `itemName` varchar(45) DEFAULT NULL,
  `itemDescription` varchar(45) DEFAULT NULL,
  `itemCost` varchar(45) DEFAULT NULL,
  `itemType` int(11) DEFAULT NULL,
  PRIMARY KEY (`itemID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemTable`
--

LOCK TABLES `itemTable` WRITE;
/*!40000 ALTER TABLE `itemTable` DISABLE KEYS */;
INSERT INTO `itemTable` VALUES (1,'helmet','add 3 armor','30',1),(2,'coat','add 5 armor','50',1),(3,'shoes','add 2 move','30',1),(4,'sword','add 3 fight','40',1),(5,'archer','can attack in a long distance','100',2),(6,'caster','can cast spell','100',2),(7,'tank','can protect the teammates','100',2),(8,'lancer','can attack in a short distance','100',2);
/*!40000 ALTER TABLE `itemTable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soldierTable`
--

DROP TABLE IF EXISTS `soldierTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soldierTable` (
  `itemID` int(11) NOT NULL,
  `soldierName` varchar(45) DEFAULT NULL,
  `move` int(11) DEFAULT NULL,
  `fight` int(11) DEFAULT NULL,
  `shoot` int(11) DEFAULT NULL,
  `armor` int(11) DEFAULT NULL,
  `morale` int(11) DEFAULT NULL,
  `health` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  PRIMARY KEY (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soldierTable`
--

LOCK TABLES `soldierTable` WRITE;
/*!40000 ALTER TABLE `soldierTable` DISABLE KEYS */;
INSERT INTO `soldierTable` VALUES (5,'archer',NULL,NULL,NULL,NULL,NULL,NULL,100),(6,'caster',NULL,NULL,NULL,NULL,NULL,NULL,100),(7,'tank',NULL,NULL,NULL,NULL,NULL,NULL,100),(8,'lancer',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `soldierTable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `userCredits` int(11) DEFAULT '500',
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user1','abc',NULL,4780),(2,'test','abc',NULL,10),(3,'saber','abc',NULL,5000),(4,'user2','abc',NULL,500),(5,'hello','123',NULL,500),(9,'helloworld','abc',NULL,500);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userCollection`
--

DROP TABLE IF EXISTS `userCollection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userCollection` (
  `collectionID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `itemName` varchar(45) DEFAULT NULL,
  `itemID` int(11) DEFAULT NULL,
  PRIMARY KEY (`collectionID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userCollection`
--

LOCK TABLES `userCollection` WRITE;
/*!40000 ALTER TABLE `userCollection` DISABLE KEYS */;
INSERT INTO `userCollection` VALUES (1,'user1','helmet',1),(2,'user1','archer',5),(3,'user1','lancer',8),(4,'user1','tank',7),(5,'user1','sword',4),(6,'user1','lancer',8),(7,'user1','lancer',8),(8,'user1','lancer',8),(9,'user1','sword',4),(10,'user1','coat',2),(11,'user1','shoes',3),(12,'test','helmet',1);
/*!40000 ALTER TABLE `userCollection` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-29 17:05:13
