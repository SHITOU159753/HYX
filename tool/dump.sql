-- MySQL dump 10.13  Distrib 5.7.27, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: HYX
-- ------------------------------------------------------
-- Server version	5.7.27

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
  `sellingPrice` int(11) NOT NULL COMMENT '产品售价（价格除1000为实际值）',
  `purchasingPrice` int(11) NOT NULL COMMENT '产品进价（价格除1000为实际值）',
  `sales` int(11) NOT NULL DEFAULT '0' COMMENT '销量',
  `grossProfit` int(11) DEFAULT '0' COMMENT '商品总利润',
  `IndividualProfit` int(11) DEFAULT '0' COMMENT '商品单件利润',
  `firstClassification` int(11) DEFAULT '0' COMMENT '一级分类',
  `secondClassification` int(11) DEFAULT '0' COMMENT '二级分类',
  `thirdClassification` int(11) DEFAULT '0' COMMENT '三级分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity`
--

LOCK TABLES `commodity` WRITE;
/*!40000 ALTER TABLE `commodity` DISABLE KEYS */;
INSERT INTO `commodity` VALUES (1,'被子','大',12000,10000,3,2000,6000,0,0,0),(10,'床单','大',13000,140000,5,2000,6000,0,0,0),(11,'床单','中',13000,140000,123,2000,6000,0,0,0),(12,'床单','小',13000,140000,235,2000,6000,0,0,0),(13,'被子','中',13000,10000,34,2000,6000,0,0,0),(14,'被子','小',13000,10000,6,2000,6000,0,0,0),(15,'被子','不大不小',13000,10000,6,2000,6000,0,0,0),(16,'被子','不大不小',13000,10000,6,2000,6000,0,0,0),(17,'被子','不大不小',13000,10000,6,2000,6000,0,0,0),(18,'被子','不大不小',13000,10000,6,2000,6000,0,0,0),(19,'被子','不大不小',13000,10000,6,2000,6000,0,0,0),(20,'被子','不大不小',13000,10000,6,2000,6000,0,0,0),(21,'haha','da',13,12,0,0,0,1,0,0);
/*!40000 ALTER TABLE `commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `firstClassification`
--

DROP TABLE IF EXISTS `firstClassification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `firstClassification` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '一级分类id',
  `name` varchar(100) NOT NULL COMMENT '一级分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `firstClassification`
--

LOCK TABLES `firstClassification` WRITE;
/*!40000 ALTER TABLE `firstClassification` DISABLE KEYS */;
INSERT INTO `firstClassification` VALUES (1,'被子'),(2,'枕头');
/*!40000 ALTER TABLE `firstClassification` ENABLE KEYS */;
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

--
-- Table structure for table `secondClassification`
--

DROP TABLE IF EXISTS `secondClassification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secondClassification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstClassifcationID` int(11) NOT NULL COMMENT '一级分类ID',
  `name` varchar(100) NOT NULL COMMENT '二级分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secondClassification`
--

LOCK TABLES `secondClassification` WRITE;
/*!40000 ALTER TABLE `secondClassification` DISABLE KEYS */;
INSERT INTO `secondClassification` VALUES (1,1,'十孔羊毛'),(2,1,'7孔羊毛'),(3,2,'外件'),(4,2,'内件');
/*!40000 ALTER TABLE `secondClassification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thirdClassification`
--

DROP TABLE IF EXISTS `thirdClassification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thirdClassification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `secondClassificationID` int(11) NOT NULL COMMENT '二级分类ID',
  `name` varchar(100) NOT NULL COMMENT '三级分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thirdClassification`
--

LOCK TABLES `thirdClassification` WRITE;
/*!40000 ALTER TABLE `thirdClassification` DISABLE KEYS */;
INSERT INTO `thirdClassification` VALUES (1,1,'八宝被子'),(2,1,'h欧被子'),(3,2,'l阿被子'),(4,3,'枕套'),(5,4,'决明子枕芯'),(6,3,'玫瑰枕芯');
/*!40000 ALTER TABLE `thirdClassification` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-01 14:03:00
