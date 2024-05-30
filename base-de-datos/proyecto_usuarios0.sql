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
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `fechacreacion` date DEFAULT NULL,
  `idusuario` int NOT NULL AUTO_INCREMENT,
  `contraseña` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `idioma` varchar(255) DEFAULT NULL,
  `nivel` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `UK_cdmw5hxlfj78uf4997i3qyyw5` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('2024-05-19',17,'{\"iv\":\"5FrC4L2CyaAk2KUkODwpHQ==\",\"textoEncriptado\":\"413HGQZePT76T7HudeGSiA==\"}','manolo@manolo.com','Ingles','A1','manolo','user'),('2024-05-19',18,'{\"iv\":\"omLUTOMZ9tElDnv8akAOsQ==\",\"textoEncriptado\":\"pZ+RDT/kpAwYUJO3gthV6w==\"}','paco@paco.com','Ingles','A1','paco','user'),('2024-05-19',19,'{\"iv\":\"ajKHFWPeRFI0fEtz9/vK/g==\",\"textoEncriptado\":\"w+8CrThS5sZsOfwnPdhj9g==\"}','culo@culo.culo','Ingles','A2','culo','user'),('2024-05-19',20,'{\"iv\":\"/d9Gn6C1rpVlgtqMjyUV1A==\",\"textoEncriptado\":\"DgibuONyMEI6b+ICcnLWLA==\"}','test1@test.com','Ingles','A1','test','user'),('2024-05-24',21,'{\"iv\":\"rHvvfNC1c9pTAYFIkIbqtg==\",\"textoEncriptado\":\"hKcFFVmukGTyL2Z721SXVQ==\"}','admin@admin.com','Ingles','A1','admin','ADMIN'),('2024-05-29',22,'prueba1','prueba1@prueba.com',NULL,NULL,'prueba1','user'),('2024-05-29',27,'uwu','uwu@uwu.uwu','Ingles','A2','llara','ADMIN');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-30 17:33:37
