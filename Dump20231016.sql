-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: scriptone
-- ------------------------------------------------------
-- Server version	8.0.33
use scriptone;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `action`
--

DROP TABLE IF EXISTS `action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `action` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `scene_id` bigint DEFAULT NULL,
  `sce_seq_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKldadkihxt97sxrayvhytw6chd` (`scene_id`),
  KEY `FK4wr1jq2b8ovn2a4j3vpqt6af9` (`sce_seq_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action`
--

LOCK TABLES `action` WRITE;
/*!40000 ALTER TABLE `action` DISABLE KEYS */;
INSERT INTO `action` VALUES (52,'eating apple',50,51),(54,'seeing tv',50,53),(62,'eating bannana',60,61),(64,'seeing moblie',60,63),(72,'eating bannana',70,71),(74,'seeing moblie',70,73),(82,'eating bannana',80,81),(84,'seeing moblie',80,83),(103,'suchi',101,102),(110,'jyoshna',108,109);
/*!40000 ALTER TABLE `action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dialogue`
--

DROP TABLE IF EXISTS `dialogue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dialogue` (
  `id` bigint NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `parantical` varchar(255) DEFAULT NULL,
  `sce_id` bigint DEFAULT NULL,
  `sce_seq_id` bigint DEFAULT NULL,
  `scch_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKish37ffqwldvf9mxm64w5k1mt` (`sce_id`),
  KEY `FKpxm1obrq854rq5txrisby5q26` (`sce_seq_id`),
  KEY `FK4wbx00wufa0ppk86l5f5v2kmn` (`scch_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dialogue`
--

LOCK TABLES `dialogue` WRITE;
/*!40000 ALTER TABLE `dialogue` DISABLE KEYS */;
INSERT INTO `dialogue` VALUES (56,'hi hello how are you','next moment',50,55,13),(58,'I am fine','next moment',50,57,16),(67,'hi hello how are you','next moment',60,66,65),(69,'I am fine','next moment',60,68,16),(76,'hi hello how are you','next moment',70,75,65),(78,'I am fine','next moment',70,77,16),(86,'hi hello','this moment',80,85,65),(88,'I am fine','this moment',80,87,16),(106,'hi hello','way',101,105,104),(112,'hi ','ways',108,111,104);
/*!40000 ALTER TABLE `dialogue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (119);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `loc_type_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsok2r8pligboaiiy2qgru3ub` (`loc_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (7,'hyderabad',2),(59,'bangloor',2),(79,'hyderbad',2),(100,'ammu',1),(107,'sruthi',1);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_type`
--

DROP TABLE IF EXISTS `location_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location_type` (
  `id` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_type`
--

LOCK TABLES `location_type` WRITE;
/*!40000 ALTER TABLE `location_type` DISABLE KEYS */;
INSERT INTO `location_type` VALUES (2,'interior'),(92,'chandana'),(93,'exterior'),(116,'ways'),(117,'interiordesigh'),(118,'exteriordesigh');
/*!40000 ALTER TABLE `location_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scene`
--

DROP TABLE IF EXISTS `scene`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scene` (
  `id` bigint NOT NULL,
  `loc_id` bigint DEFAULT NULL,
  `sc_id` bigint DEFAULT NULL,
  `time_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbetk6u3of4j99lxeuyxtm7gbw` (`loc_id`),
  KEY `FKq0gi2l2r1auwpr402bx89wbia` (`sc_id`),
  KEY `FKl865ni5u1qnavin2dk0tnyylp` (`time_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scene`
--

LOCK TABLES `scene` WRITE;
/*!40000 ALTER TABLE `scene` DISABLE KEYS */;
INSERT INTO `scene` VALUES (50,7,1,12),(60,59,1,12),(70,59,1,12),(80,79,1,12),(101,100,2,4),(108,107,19,4);
/*!40000 ALTER TABLE `scene` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scene_element_order`
--

DROP TABLE IF EXISTS `scene_element_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scene_element_order` (
  `id` bigint NOT NULL,
  `sequence_order_number` int DEFAULT NULL,
  `sce_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnhi0pamhkaobum2dc56anf1eq` (`sce_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scene_element_order`
--

LOCK TABLES `scene_element_order` WRITE;
/*!40000 ALTER TABLE `scene_element_order` DISABLE KEYS */;
INSERT INTO `scene_element_order` VALUES (9,1,8),(11,4,8),(14,3,8),(17,3,8),(51,1,50),(53,4,50),(55,3,50),(57,3,50),(61,9,60),(63,4,60),(66,3,60),(68,3,60),(71,9,70),(73,4,70),(75,3,70),(77,3,70),(81,9,80),(83,4,80),(85,3,80),(87,3,80),(102,9,101),(105,3,101),(109,55,108),(111,3,108);
/*!40000 ALTER TABLE `scene_element_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `script`
--

DROP TABLE IF EXISTS `script`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `script` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `script`
--

LOCK TABLES `script` WRITE;
/*!40000 ALTER TABLE `script` DISABLE KEYS */;
INSERT INTO `script` VALUES (1,'script1'),(19,'script2'),(89,'chandana'),(90,'chandana'),(91,'bhuvana'),(2,'script2'),(113,'sruthi'),(114,'pavi'),(115,'sailaja');
/*!40000 ALTER TABLE `script` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `script_charector`
--

DROP TABLE IF EXISTS `script_charector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `script_charector` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sc_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc3ufmdv0vbkmptqsdtdij9g0i` (`sc_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `script_charector`
--

LOCK TABLES `script_charector` WRITE;
/*!40000 ALTER TABLE `script_charector` DISABLE KEYS */;
INSERT INTO `script_charector` VALUES (13,'chandana',1),(16,'rukku',1),(65,'ruku',1),(98,'hello',1),(99,'hi',2),(104,'pavi',2);
/*!40000 ALTER TABLE `script_charector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time`
--

DROP TABLE IF EXISTS `time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time` (
  `id` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time`
--

LOCK TABLES `time` WRITE;
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
INSERT INTO `time` VALUES (4,'morning'),(5,'evening'),(96,'hi');
/*!40000 ALTER TABLE `time` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-16 11:22:40
