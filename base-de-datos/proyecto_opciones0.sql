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
-- Table structure for table `opciones`
--

DROP TABLE IF EXISTS `opciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opciones` (
  `correcta` bit(1) DEFAULT NULL,
  `idopcion` int NOT NULL AUTO_INCREMENT,
  `idpregunta` int DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idopcion`),
  KEY `FK247cp6am8njvgrgkyc0409mwt` (`idpregunta`),
  CONSTRAINT `FK247cp6am8njvgrgkyc0409mwt` FOREIGN KEY (`idpregunta`) REFERENCES `preguntas` (`idpregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opciones`
--

LOCK TABLES `opciones` WRITE;
/*!40000 ALTER TABLE `opciones` DISABLE KEYS */;
INSERT INTO `opciones` VALUES (_binary '\0',1,1,'in'),(_binary '\0',2,1,'on'),(_binary '',3,1,'at'),(_binary '\0',4,1,'to'),(_binary '\0',5,2,'Gato'),(_binary '',6,2,'Perro'),(_binary '\0',7,2,'Caballo'),(_binary '\0',8,2,'Pájaro'),(_binary '',9,3,'did'),(_binary '\0',10,3,'do'),(_binary '\0',11,3,'does'),(_binary '\0',12,3,'doing'),(_binary '',13,4,'\"There\" indica lugar, mientras que \"they\'re\" es una contracción de \"they are\".'),(_binary '\0',14,4,'\"There\" se usa con sustantivos singulares, mientras que \"they\'re\" se usa con plurales.'),(_binary '\0',15,4,'\"There\" se usa en oraciones afirmativas, mientras que \"they\'re\" se usa en negativas.'),(_binary '\0',16,4,'\"There\" se usa antes de verbos, mientras que \"they\'re\" se usa después.'),(_binary '',17,5,'emphasized'),(_binary '\0',18,5,'emphasizes'),(_binary '\0',19,5,'emphasize'),(_binary '\0',20,5,'emphasizing'),(_binary '',21,6,'¡No puedo esperar a verte mañana!'),(_binary '\0',22,6,'¡No veo la hora de verte mañana!'),(_binary '\0',23,6,'¡Te espero mañana con impaciencia!'),(_binary '\0',24,6,'¡Hasta mañana!'),(_binary '\0',25,7,'significant'),(_binary '',26,7,'significantly'),(_binary '\0',27,7,'significance'),(_binary '\0',28,7,'signifying'),(_binary '',29,8,'Todos los caminos conducen a Roma.'),(_binary '\0',30,8,'Hay muchos caminos que llevan a Roma.'),(_binary '\0',31,8,'No importa el camino que tomes, llegarás a Roma.'),(_binary '\0',32,8,'El camino más largo siempre es el mejor.'),(_binary '',33,10,'Es una verdad universalmente reconocida que un soltero en posesión de una buena fortuna debe estar en busca de una esposa.'),(_binary '\0',34,10,'Es un hecho sabido que los hombres solteros con dinero buscan esposa.'),(_binary '\0',35,10,'Es una realidad innegable que los hombres ricos necesitan casarse.'),(_binary '\0',36,10,'Es una creencia popular que los solteros adinerados buscan pareja.'),(_binary '',37,9,'resilience'),(_binary '\0',38,9,'resistant'),(_binary '\0',39,9,'resist'),(_binary '\0',40,9,'resistance'),(_binary '\0',89,17,'Perro'),(_binary '',90,17,'Gato'),(_binary '\0',91,17,'Pájaro'),(_binary '\0',92,17,'Pez'),(_binary '\0',93,18,'Cuatro'),(_binary '',94,18,'Seis'),(_binary '\0',95,18,'Siete'),(_binary '\0',96,18,'Ocho'),(_binary '\0',97,19,'Hola'),(_binary '',98,19,'Adiós'),(_binary '\0',99,19,'Por favor'),(_binary '\0',100,19,'Gracias'),(_binary '',101,20,'Pequeño'),(_binary '\0',102,20,'Alto'),(_binary '\0',103,20,'Fuerte'),(_binary '\0',104,20,'Rápido'),(_binary '\0',105,21,'Gato'),(_binary '',106,21,'Perro'),(_binary '\0',107,21,'Pájaro'),(_binary '\0',108,21,'Pez'),(_binary '\0',109,22,'No'),(_binary '',110,22,'Sí'),(_binary '\0',111,22,'Tal vez'),(_binary '\0',112,22,'Quizás'),(_binary '',153,23,'Sad'),(_binary '\0',154,23,'Angry'),(_binary '\0',155,23,'Tired'),(_binary '\0',156,23,'Excited'),(_binary '',157,24,'am'),(_binary '\0',158,24,'is'),(_binary '\0',159,24,'are'),(_binary '\0',160,24,'be'),(_binary '\0',161,25,'Tengo hambre'),(_binary '\0',162,25,'Tengo sueño'),(_binary '',163,25,'Me duele la cabeza'),(_binary '\0',164,25,'Tengo calor'),(_binary '\0',165,26,'Verde'),(_binary '',166,26,'Azul'),(_binary '\0',167,26,'Rojo'),(_binary '\0',168,26,'Amarillo'),(_binary '\0',169,27,'Correr'),(_binary '',170,27,'Nadar'),(_binary '\0',171,27,'Bailar'),(_binary '\0',172,27,'Cantar'),(_binary '\0',173,28,'go'),(_binary '',174,28,'goes'),(_binary '\0',175,28,'going'),(_binary '\0',176,28,'went'),(_binary '',177,29,'Hot'),(_binary '\0',178,29,'Warm'),(_binary '\0',179,29,'Cool'),(_binary '\0',180,29,'Freezing'),(_binary '',181,30,'Cocinar'),(_binary '\0',182,30,'Comer'),(_binary '\0',183,30,'Beber'),(_binary '\0',184,30,'Dormir'),(_binary '\0',185,31,'am'),(_binary '\0',186,31,'is'),(_binary '',187,31,'are'),(_binary '\0',188,31,'be'),(_binary '\0',189,32,'Silla'),(_binary '',190,32,'Mesa'),(_binary '\0',191,32,'Cama'),(_binary '\0',192,32,'Armario'),(_binary '\0',193,33,'Teléfono'),(_binary '',194,33,'Computadora'),(_binary '\0',195,33,'Televisión'),(_binary '\0',196,33,'Radio'),(_binary '\0',197,34,'goes'),(_binary '\0',198,34,'go'),(_binary '',199,34,'went'),(_binary '\0',200,34,'gone'),(_binary '',201,35,'Viajar'),(_binary '\0',202,35,'Comer'),(_binary '\0',203,35,'Estudiar'),(_binary '\0',204,35,'Trabajar'),(_binary '\0',205,36,'Película'),(_binary '',206,36,'Libro'),(_binary '\0',207,36,'Canción'),(_binary '\0',208,36,'Revista'),(_binary '\0',209,37,'Jugar'),(_binary '',210,37,'Estudiar'),(_binary '\0',211,37,'Comer'),(_binary '\0',212,37,'Dormir'),(_binary '',213,38,'go'),(_binary '\0',214,38,'goes'),(_binary '\0',215,38,'going'),(_binary '\0',216,38,'went'),(_binary '\0',217,11,'Puerta'),(_binary '',218,11,'Ventana'),(_binary '\0',219,11,'Mesa'),(_binary '\0',220,11,'Silla'),(_binary '\0',221,12,'am'),(_binary '\0',222,12,'are'),(_binary '',223,12,'is'),(_binary '\0',224,12,'be'),(_binary '\0',225,13,'Enojado'),(_binary '\0',226,13,'Triste'),(_binary '\0',227,13,'Cansado'),(_binary '',228,13,'Contento'),(_binary '\0',229,14,'go'),(_binary '\0',230,14,'goes'),(_binary '',231,14,'went'),(_binary '\0',232,14,'going'),(_binary '\0',233,15,'in'),(_binary '\0',234,15,'where'),(_binary '',235,15,'on'),(_binary '\0',236,15,'at'),(_binary '\0',237,16,'Run'),(_binary '\0',238,16,'Play'),(_binary '',239,16,'Can'),(_binary '\0',240,16,'Jump');
/*!40000 ALTER TABLE `opciones` ENABLE KEYS */;
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
