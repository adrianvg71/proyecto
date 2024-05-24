-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyecto
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `preguntas`
--

DROP TABLE IF EXISTS `preguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preguntas` (
  `idejercicio` int DEFAULT NULL,
  `idpregunta` int NOT NULL AUTO_INCREMENT,
  `enunciado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idpregunta`),
  KEY `FKj4o191kpt5t8pv20crsxflaho` (`idejercicio`),
  CONSTRAINT `FKj4o191kpt5t8pv20crsxflaho` FOREIGN KEY (`idejercicio`) REFERENCES `ejercicios` (`idejercicio`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preguntas`
--

LOCK TABLES `preguntas` WRITE;
/*!40000 ALTER TABLE `preguntas` DISABLE KEYS */;
INSERT INTO `preguntas` VALUES (1,1,'Completa la frase: I go to the park _____ the afternoon.'),(1,2,'Traduce la siguiente palabra: Dog'),(1,3,'Elige la opción correcta: \"I _____ my homework last night.\"'),(1,4,'¿Cuál es la diferencia entre \'there\' y \'they\'re\'?'),(1,5,'Completa la frase: \"The teacher _____ the importance of studying English.\"'),(1,6,'Traduce la siguiente frase: I can\'t wait to see you tomorrow!'),(1,7,'Elige la opción que mejor complete el espacio en blanco: \"The company\'s new policy has had a _____ impact on employee morale.\"'),(1,8,'Traduce la siguiente frase: \"All roads lead to Rome.\"'),(1,9,'Completa la frase: \"In the face of adversity, she showed remarkable _____.\"'),(1,10,'Traduce la siguiente frase: \"It is a truth universally acknowledged that a single man in possession of a good fortune must be in want of a wife.\"'),(2,11,'¿Cuál es la traducción correcta de \"window\" al español?'),(2,12,'Elige la forma correcta del verbo \"to be\" en presente para el pronombre \"she\"?'),(2,13,'¿Cuál de las siguientes palabras es sinónimo de \"happy\"?'),(2,14,'Selecciona la opción correcta para completar la oración: \"I ____ to the park yesterday.\"'),(2,15,'Elige la preposición correcta para completar la oración: \"She is sitting ____ the table.\"'),(2,16,'¿Cuál de las siguientes es un verbo modal?'),(3,17,'¿Cuál es la traducción correcta de \"cat\" al español?'),(3,18,'¿Qué número sigue después de \"five\"?'),(3,19,'¿Qué significa \"goodbye\" en español?'),(3,20,'¿Cuál es el opuesto de \"big\"?'),(3,21,'¿Qué animal dice \"woof\"?'),(3,22,'¿Qué significa \"yes\" en español?'),(4,23,'¿Cuál es el antónimo de \"happy\"?'),(4,24,'Completa la siguiente frase correctamente: \"I ____ from Spain.\"'),(4,25,'¿Qué significa \"I have a headache\" en español?'),(4,26,'¿Cuál es la traducción correcta de \"blue\" al español?'),(4,27,'¿Qué significa \"to swim\" en español?'),(4,28,'Completa la siguiente frase correctamente: \"She ____ to school every day.\"'),(4,29,'¿Cuál es el antónimo de \"cold\"?'),(4,30,'¿Qué significa \"to cook\" en español?'),(4,31,'Completa la siguiente frase correctamente: \"They ____ brothers.\"'),(4,32,'¿Cuál es la traducción correcta de \"table\" al español?'),(5,33,'¿Cuál es la traducción correcta de \"computer\" al español?'),(5,34,'Completa la siguiente frase correctamente: \"She _____ to the store when it started raining.\"'),(5,35,'¿Qué significa \"to travel\" en español?'),(5,36,'¿Cuál es la traducción correcta de \"book\" al español?'),(5,37,'¿Qué significa \"to study\" en español?'),(5,38,'Completa la siguiente frase correctamente: \"I _____ to the gym every Monday.\"');
/*!40000 ALTER TABLE `preguntas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-24 22:15:51
