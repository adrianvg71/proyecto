-- MySQL dump 10.13  Distrib 8.0.36, for macos14 (x86_64)
--
-- Host: localhost    Database: proyecto
-- ------------------------------------------------------
-- Server version	8.4.0

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
-- Table structure for table `usuarioejercicio`
--

DROP TABLE IF EXISTS `usuarioejercicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarioejercicio` (
  `aciertos` int DEFAULT NULL,
  `idejercicio` int DEFAULT NULL,
  `idusuario` int DEFAULT NULL,
  `idusuarioejercicio` int NOT NULL AUTO_INCREMENT,
  `fecharealizacion` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`idusuarioejercicio`),
  UNIQUE KEY `UKiknqxnnbm3tmkggstyla74yt5` (`idusuario`,`idejercicio`),
  KEY `FKbpm3tkyccdbtfmerno340uigb` (`idejercicio`),
  CONSTRAINT `FK7a79jq4kq2o3mdt3t2rv9my3p` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`) ON DELETE CASCADE,
  CONSTRAINT `FKbpm3tkyccdbtfmerno340uigb` FOREIGN KEY (`idejercicio`) REFERENCES `ejercicios` (`idejercicio`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarioejercicio`
--

LOCK TABLES `usuarioejercicio` WRITE;
/*!40000 ALTER TABLE `usuarioejercicio` DISABLE KEYS */;
INSERT INTO `usuarioejercicio` VALUES (3,2,18,21,'2024-05-19 16:35:56.107652'),(3,2,19,22,'2024-05-19 17:08:41.069267'),(6,3,19,23,'2024-05-19 17:10:24.511320'),(10,4,19,24,'2024-05-19 17:11:28.542720'),(6,5,19,25,'2024-05-19 17:12:08.374812'),(4,2,20,26,'2024-05-19 19:53:00.654639'),(5,2,21,27,'2024-05-24 23:15:51.274705');
/*!40000 ALTER TABLE `usuarioejercicio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-30 17:33:36
