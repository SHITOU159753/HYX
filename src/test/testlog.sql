-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: testlog
-- ------------------------------------------------------
-- Server version	5.7.24

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
-- Table structure for table `commodity`
--

DROP TABLE IF EXISTS `commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '产品名称',
  `type` varchar(30) DEFAULT NULL COMMENT '产品型号',
  `sellingPrice` int(11) NOT NULL DEFAULT '0' COMMENT '产品售价（价格除1000为实际值）',
  `purchasingPrice` int(11) NOT NULL DEFAULT '0' COMMENT '产品进价（价格除1000为实际值）',
  `sales` int(11) NOT NULL DEFAULT '0' COMMENT '销量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity`
--

LOCK TABLES `commodity` WRITE;
/*!40000 ALTER TABLE `commodity` DISABLE KEYS */;
INSERT INTO `commodity` VALUES (1,'被子','大',12000,10000,3),(10,'床单','大',13000,140000,5),(11,'床单','中',13000,140000,123),(12,'床单','小',13000,140000,235),(13,'被子','中',13000,10000,34),(14,'被子','小',13000,10000,6),(15,'被子','不大不小',13000,10000,6),(16,'被子','不大不小',13000,10000,6),(17,'被子','不大不小',13000,10000,6),(18,'被子','不大不小',13000,10000,6),(19,'被子','不大不小',13000,10000,6),(20,'被子','不大不小',13000,10000,6);
/*!40000 ALTER TABLE `commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `salt` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (1,'admin','9999@hua.com','928384','434835'),(2,'zhangsan','1124124@asdasd.com','asd6688','asd6688'),(3,'chenlvhua','234324@asda.com','qw12312','123');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomrateagent`
--

DROP TABLE IF EXISTS `roomrateagent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roomrateagent` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `AgentCode` varchar(50) DEFAULT NULL,
  `HotelCode` varchar(50) DEFAULT NULL,
  `RatePlanCode` varchar(50) DEFAULT NULL,
  `CreateDate` datetime NOT NULL,
  `ModifyDate` datetime NOT NULL,
  `ModifyUser` varchar(50) DEFAULT NULL,
  `IsDeleted` bit(1) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `idx_ModifyDate` (`ModifyDate`),
  KEY `idx_agentCode` (`AgentCode`),
  KEY `idx_agentCode_hotelCode` (`AgentCode`,`HotelCode`),
  KEY `idx_hotelCode` (`HotelCode`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomrateagent`
--

LOCK TABLES `roomrateagent` WRITE;
/*!40000 ALTER TABLE `roomrateagent` DISABLE KEYS */;
INSERT INTO `roomrateagent` VALUES (1,'asda123','1321321','lalalala','2019-01-10 12:00:08','2019-01-10 11:47:47','',_binary '\0'),(2,'asda123','1321321','lalalala','2019-01-10 12:00:08','2019-01-10 11:47:47','',_binary '\0'),(3,'asda123','1321321','lalalala','2019-01-10 12:00:08','2019-01-10 11:47:47','',_binary '\0'),(4,'asda123','1321321','lalalala','2019-01-10 12:00:08','2019-01-10 11:52:09','',_binary '\0'),(5,'12312321','12312312','123123123','2019-01-10 11:57:16','2019-01-10 11:57:16',NULL,_binary '\0');
/*!40000 ALTER TABLE `roomrateagent` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-24 15:47:09
