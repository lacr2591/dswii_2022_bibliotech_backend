CREATE DATABASE  IF NOT EXISTS `bd_bibliotech_1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_bibliotech_1`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_bibliotech_1
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `tb_autores`
--

DROP TABLE IF EXISTS `tb_autores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_autores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_autores`
--

LOCK TABLES `tb_autores` WRITE;
/*!40000 ALTER TABLE `tb_autores` DISABLE KEYS */;
INSERT INTO `tb_autores` VALUES (1,'Quiñones, Javier'),(2,'César Vallejo'),(3,'Massé, Armando'),(4,'Aguilar Tuesta, Silvana Lisset'),(5,'William Faulkner'),(6,'Oscar Wilde'),(7,'Franz Kafka'),(8,'William Shakespeare'),(9,'James Joyce'),(10,'Philip K. Dick'),(11,'Gabriel García Márquez'),(12,'Paulo Coelho'),(13,'George Orwell'),(14,'William Butler Yeats'),(15,'Fiódor Dostoievski'),(16,'Haruki Murakami'),(17,'Charles Dickens'),(18,'Aldous Huxley'),(19,'Ernest Hemmingway'),(20,'Truman Capote'),(21,'Marcel Proust'),(22,'Charles Darwin'),(23,'Mary Wollstonecraft'),(24,'Virginia Woolf'),(25,'Mary Shelley'),(26,'Simone de Beauvoir'),(27,'Roald Dahl'),(28,'Herman Melville');
/*!40000 ALTER TABLE `tb_autores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_biblioteca`
--

DROP TABLE IF EXISTS `tb_biblioteca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_biblioteca` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idInstitucionFK` int NOT NULL,
  `idLibroFK` int NOT NULL,
  `stockDisponible` int NOT NULL DEFAULT '0',
  `estado` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`),
  KEY `idLibroFK` (`idLibroFK`),
  KEY `idInstitucionFK` (`idInstitucionFK`),
  CONSTRAINT `tb_biblioteca_ibfk_1` FOREIGN KEY (`idLibroFK`) REFERENCES `tb_libros` (`id`),
  CONSTRAINT `tb_biblioteca_ibfk_2` FOREIGN KEY (`idInstitucionFK`) REFERENCES `tb_instituciones` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_biblioteca`
--

LOCK TABLES `tb_biblioteca` WRITE;
/*!40000 ALTER TABLE `tb_biblioteca` DISABLE KEYS */;
INSERT INTO `tb_biblioteca` VALUES (1,1,1,15,_binary ''),(2,1,2,15,_binary ''),(3,1,3,15,_binary ''),(4,1,4,15,_binary ''),(5,1,4,15,_binary ''),(6,1,5,15,_binary ''),(7,1,6,15,_binary ''),(8,1,7,15,_binary ''),(9,1,8,15,_binary ''),(10,1,9,15,_binary '');
/*!40000 ALTER TABLE `tb_biblioteca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_categorias`
--

DROP TABLE IF EXISTS `tb_categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_categorias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_categorias`
--

LOCK TABLES `tb_categorias` WRITE;
/*!40000 ALTER TABLE `tb_categorias` DISABLE KEYS */;
INSERT INTO `tb_categorias` VALUES (1,'Cuentos'),(2,'Historia'),(3,'Biologia'),(4,'Algebra'),(5,'Computacion'),(6,'Poema épico'),(7,'Epopeya'),(8,'Romance'),(9,'Fábula'),(10,'Leyenda'),(11,'Novela'),(12,'Drama'),(13,'Tragedia'),(14,'Comedia'),(15,'Melodrama'),(16,'Ciencias'),(17,'Literatura');
/*!40000 ALTER TABLE `tb_categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_configuraciones`
--

DROP TABLE IF EXISTS `tb_configuraciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_configuraciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cantDiasPrestamo` int NOT NULL DEFAULT '10',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_configuraciones`
--

LOCK TABLES `tb_configuraciones` WRITE;
/*!40000 ALTER TABLE `tb_configuraciones` DISABLE KEYS */;
INSERT INTO `tb_configuraciones` VALUES (1,10);
/*!40000 ALTER TABLE `tb_configuraciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_instituciones`
--

DROP TABLE IF EXISTS `tb_instituciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_instituciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) NOT NULL,
  `idUsuarioRepresentanteFK` int DEFAULT NULL,
  `idConfiguracionFK` int NOT NULL,
  `dominioInstitucion` varchar(60) DEFAULT NULL,
  `fecRegistro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `estado` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`),
  KEY `idUsuarioRepresentanteFK` (`idUsuarioRepresentanteFK`),
  KEY `idConfiguracionFK` (`idConfiguracionFK`),
  CONSTRAINT `tb_instituciones_ibfk_1` FOREIGN KEY (`idUsuarioRepresentanteFK`) REFERENCES `tb_usuarios` (`id`),
  CONSTRAINT `tb_instituciones_ibfk_2` FOREIGN KEY (`idConfiguracionFK`) REFERENCES `tb_configuraciones` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_instituciones`
--

LOCK TABLES `tb_instituciones` WRITE;
/*!40000 ALTER TABLE `tb_instituciones` DISABLE KEYS */;
INSERT INTO `tb_instituciones` VALUES (1,'CIBERTEC',20,1,'cibertec.edu.pe','2022-03-31 11:24:46',_binary '');
/*!40000 ALTER TABLE `tb_instituciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_libro_autor`
--

DROP TABLE IF EXISTS `tb_libro_autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_libro_autor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idAutorFK` int NOT NULL,
  `idLibroFK` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idLibroFK` (`idLibroFK`),
  KEY `idAutorFK` (`idAutorFK`),
  CONSTRAINT `tb_libro_autor_ibfk_1` FOREIGN KEY (`idLibroFK`) REFERENCES `tb_libros` (`id`),
  CONSTRAINT `tb_libro_autor_ibfk_2` FOREIGN KEY (`idAutorFK`) REFERENCES `tb_autores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_libro_autor`
--

LOCK TABLES `tb_libro_autor` WRITE;
/*!40000 ALTER TABLE `tb_libro_autor` DISABLE KEYS */;
INSERT INTO `tb_libro_autor` VALUES (1,1,1),(2,1,2),(3,3,3),(4,4,4),(5,4,5),(6,4,6),(7,4,7),(8,4,7),(9,4,8),(10,8,9);
/*!40000 ALTER TABLE `tb_libro_autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_libro_categoria`
--

DROP TABLE IF EXISTS `tb_libro_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_libro_categoria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idCategoriaFK` int NOT NULL,
  `idLibroFK` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idLibroFK` (`idLibroFK`),
  KEY `idCategoriaFK` (`idCategoriaFK`),
  CONSTRAINT `tb_libro_categoria_ibfk_1` FOREIGN KEY (`idLibroFK`) REFERENCES `tb_libros` (`id`),
  CONSTRAINT `tb_libro_categoria_ibfk_2` FOREIGN KEY (`idCategoriaFK`) REFERENCES `tb_categorias` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_libro_categoria`
--

LOCK TABLES `tb_libro_categoria` WRITE;
/*!40000 ALTER TABLE `tb_libro_categoria` DISABLE KEYS */;
INSERT INTO `tb_libro_categoria` VALUES (1,1,1),(2,2,1),(3,1,2),(4,1,3),(5,1,4),(6,5,5),(7,5,6),(8,5,7),(9,2,8),(10,2,9);
/*!40000 ALTER TABLE `tb_libro_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_libros`
--

DROP TABLE IF EXISTS `tb_libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_libros` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `title_long` varchar(160) DEFAULT NULL,
  `isbn` varchar(20) DEFAULT NULL,
  `isbn13` varchar(13) DEFAULT NULL,
  `dewey_decimal` varchar(100) DEFAULT NULL,
  `binding` varchar(100) DEFAULT NULL,
  `publisher` varchar(100) DEFAULT NULL,
  `language` varchar(100) DEFAULT NULL,
  `date_published` varchar(100) DEFAULT NULL,
  `edition` varchar(100) DEFAULT NULL,
  `pages` int DEFAULT NULL,
  `dimensions` varchar(100) DEFAULT NULL,
  `overview` varchar(100) DEFAULT NULL,
  `coverLink` varchar(300) DEFAULT NULL,
  `excerpt` varchar(100) DEFAULT NULL,
  `synopsys` varchar(500) DEFAULT NULL,
  `estado` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_libros`
--

LOCK TABLES `tb_libros` WRITE;
/*!40000 ALTER TABLE `tb_libros` DISABLE KEYS */;
INSERT INTO `tb_libros` VALUES (1,'Semanario de cuentos','Semanario de cuentos','978-612-48304-7-1','9786124830471',NULL,NULL,NULL,'español',NULL,'2021',70,'17x24cm.',NULL,'http://isbn.bnp.gob.pe/files/titulos/124656.jpg',NULL,'Ella estuvo molesta por días, no hablaba y tampoco respondía los mensajes.',_binary ''),(2,'El Gato De Hojalata','El Gato De Hojalata','9506032084','9506032084',NULL,NULL,NULL,'español',NULL,'2014',95,'17x24cm.',NULL,'https://images.gr-assets.com/authors/1612355898p8/524049.jpg',NULL,'La historia de un gato que no pudo saber quien era.',_binary ''),(3,'Mondadori','Mondadori','9788425329296','9788425329296',NULL,NULL,NULL,'español',NULL,'1996',120,'17x24cm.',NULL,'https://images.cdn1.buscalibre.com/fit-in/360x360/1a/5d/1a5dd8d26cffd38ae4d9a8dca5589590.jpg',NULL,'Cuentos que no son cuentos.',_binary ''),(4,'LATINBOOKS','LATINBOOKS','9974738024','9974738024',NULL,NULL,NULL,'español',NULL,'2021',120,'19x24cm.',NULL,'https://latinbooksint.com/img/tapitas_lb/1619722353-1-NoAbrasEsteLibr2.png',NULL,'Cuentos que no son cuentos.',_binary ''),(5,'Computacion','Computacion','9681864778','9681864778',NULL,NULL,NULL,'español',NULL,'1980',120,'19x24cm.',NULL,'https://images.isbndb.com/covers/35/61/9781591723561.jpg',NULL,'Curso amplio de computacion basica',_binary ''),(6,'Neurociencia Y Computacion Neuronal','Neurociencia Y Computacion Neuronal','8489728119','8489728119',NULL,NULL,NULL,'español',NULL,'1997',120,'19x24cm.',NULL,'https://images.isbndb.com/covers/81/10/9788489728110.jpg',NULL,'La neurociencia y la computacion a profundidad.',_binary ''),(7,'Critica (Grijalbo Mondadori)','Critica (Grijalbo Mondadori)','8484324443','8484324443',NULL,NULL,NULL,'español',NULL,'2004',120,'19x24cm.',NULL,'https://cdn.wallapop.com/images/10420/ar/f7/__/c10420p650720585/i2049633871.jpg?pictureSize=W640',NULL,'Conferencias Sobre Computacion',_binary ''),(8,'The Silence And The Scorpion:Venezuela','El silencio de venezuela','1568586868','1568586868',NULL,NULL,NULL,'english',NULL,'2009',384,'19x24cm.',NULL,'https://images.isbndb.com/covers/68/61/9781568586861.jpg',NULL,'On April 11, 2002, Nearly A Million Venezuelans Marched On The Presidential Palace',_binary ''),(9,'NDEH. Una historia apache','NDEH. Una historia apache','8441539456','8441539456',NULL,NULL,NULL,'english',NULL,'2017',120,'19x24cm.',NULL,'https://images.isbndb.com/covers/94/57/9788441539457.jpg',NULL,'Based on exhaustive research, this graphic novel offers a remarkable glimpse into the raw themes of cultural differences, the horrors of war',_binary '');
/*!40000 ALTER TABLE `tb_libros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_personas`
--

DROP TABLE IF EXISTS `tb_personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_personas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(70) NOT NULL,
  `apellidoMaterno` varchar(70) NOT NULL,
  `apellidoPaterno` varchar(70) NOT NULL,
  `fecNacimiento` date NOT NULL,
  `dni` varchar(15) NOT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `genero` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_personas`
--

LOCK TABLES `tb_personas` WRITE;
/*!40000 ALTER TABLE `tb_personas` DISABLE KEYS */;
INSERT INTO `tb_personas` VALUES (1,'Luis','Romero','Calderon','2022-03-31','12345678','1234567','m'),(2,'estudiante','prueba','1','2022-03-31','87654321','123456','m'),(3,'Meredith','Grey','Sony','2022-03-31','65874521','986541','f'),(4,'Raúl','Robles','Zapata','2022-03-31','85231466','785124','m'),(5,'Phoebe','Buffay','Linares','2022-03-31','15427862','652314','f'),(6,'Chandler','Bing','Gomez','2022-03-31','52341527','258745','m'),(7,'Ross','Geller','Corso','2022-03-31','25987514','965412','m'),(8,'Rachel','Green','Huaman','2022-03-31','42598574','963254','f'),(9,'Joey','Tribbiani','Kors','2022-03-31','87656702','465345','m'),(10,'Pablo','Pilsen','Araos','2022-03-31','34354609','878765','m'),(11,'Mauricio','Budweiser','Garro','2022-03-31','66789654','767689','m'),(12,'Simon','Kross','Linares','2022-03-31','54678556','656545','m'),(13,'Paola','Kunstmann','Torobayo','2022-03-31','73890436','345654','f'),(14,'Grace','Vasquez','Santiesteban','2022-03-31','15678435','567654','f'),(15,'Carlos','Caceres','Quispe','2022-03-31','76895632','343456','m'),(16,'Giovanna','Chicoma','Canales','2022-03-31','13425670','121212','f'),(17,'Eliot','Marquez','Pinto','2022-03-31','556784456','898989','m'),(18,'Isabela','Lucky','Strike','2022-03-31','98678234','787878','f'),(19,'Alejandro','Toledo','Manrique','2022-03-31','23456789','565656','m'),(20,'Alan','Garcia','Perez','2022-03-31','65786576','343434','m');
/*!40000 ALTER TABLE `tb_personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_prestamos`
--

DROP TABLE IF EXISTS `tb_prestamos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_prestamos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idUsuarioFK` int NOT NULL,
  `idLibroFK` int NOT NULL,
  `estado` char(1) NOT NULL DEFAULT 'p',
  `fechaPrestamo` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idLibroFK` (`idLibroFK`),
  KEY `idUsuarioFK` (`idUsuarioFK`),
  CONSTRAINT `tb_prestamos_ibfk_1` FOREIGN KEY (`idLibroFK`) REFERENCES `tb_libros` (`id`),
  CONSTRAINT `tb_prestamos_ibfk_2` FOREIGN KEY (`idUsuarioFK`) REFERENCES `tb_usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_prestamos`
--

LOCK TABLES `tb_prestamos` WRITE;
/*!40000 ALTER TABLE `tb_prestamos` DISABLE KEYS */;
INSERT INTO `tb_prestamos` VALUES (1,2,1,'p','2022-03-31 11:25:22'),(2,2,2,'p','2022-03-31 11:26:26'),(3,2,3,'p','2022-03-31 11:26:35'),(4,2,4,'p','2022-03-31 11:26:42'),(5,2,5,'p','2022-03-31 11:27:04'),(6,2,6,'p','2022-03-31 11:27:28'),(7,2,7,'p','2022-03-31 11:28:01'),(8,2,8,'p','2022-03-31 11:28:50');
/*!40000 ALTER TABLE `tb_prestamos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_rating_libros`
--

DROP TABLE IF EXISTS `tb_rating_libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_rating_libros` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idUsuarioFK` int NOT NULL,
  `idLibroFK` int NOT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `fechaComentario` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `puntuacion` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idLibroFK` (`idLibroFK`),
  KEY `idUsuarioFK` (`idUsuarioFK`),
  CONSTRAINT `tb_rating_libros_ibfk_1` FOREIGN KEY (`idLibroFK`) REFERENCES `tb_libros` (`id`),
  CONSTRAINT `tb_rating_libros_ibfk_2` FOREIGN KEY (`idUsuarioFK`) REFERENCES `tb_usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rating_libros`
--

LOCK TABLES `tb_rating_libros` WRITE;
/*!40000 ALTER TABLE `tb_rating_libros` DISABLE KEYS */;
INSERT INTO `tb_rating_libros` VALUES (1,2,1,'Muy recomendado','2022-03-31 11:25:25',5),(2,2,2,'Recomendado','2022-03-31 11:26:29',4),(3,3,2,'Recomendado','2022-03-31 11:26:32',3),(4,2,3,'Es un excelente libro','2022-03-31 11:26:39',5),(5,2,4,'Libro muy bueno','2022-03-31 11:26:45',4),(6,2,5,'Libro muy bueno','2022-03-31 11:27:07',4),(7,2,6,'Libro poco entretenido','2022-03-31 11:27:32',2),(8,2,7,'Libro exitoso','2022-03-31 11:28:04',4),(9,2,8,'Libro muy dificultoso','2022-03-31 11:28:53',2);
/*!40000 ALTER TABLE `tb_rating_libros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_roles`
--

DROP TABLE IF EXISTS `tb_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rol` varchar(5) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_roles`
--

LOCK TABLES `tb_roles` WRITE;
/*!40000 ALTER TABLE `tb_roles` DISABLE KEYS */;
INSERT INTO `tb_roles` VALUES (1,'admin','Administrador General'),(2,'reprs','Representante Instituciones'),(3,'estud','Estudiantes');
/*!40000 ALTER TABLE `tb_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_suscripciones`
--

DROP TABLE IF EXISTS `tb_suscripciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_suscripciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idInstitucionFK` int NOT NULL,
  `fecRegistro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `vigenciaDias` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idInstitucionFK` (`idInstitucionFK`),
  CONSTRAINT `tb_suscripciones_ibfk_1` FOREIGN KEY (`idInstitucionFK`) REFERENCES `tb_instituciones` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_suscripciones`
--

LOCK TABLES `tb_suscripciones` WRITE;
/*!40000 ALTER TABLE `tb_suscripciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_suscripciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuarios`
--

DROP TABLE IF EXISTS `tb_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idPersonaFK` int DEFAULT NULL,
  `emailUsuario` varchar(60) NOT NULL,
  `passwordUSuario` varchar(65) NOT NULL,
  `rolId` int NOT NULL,
  `fecRegistro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idInstitucionFK` int DEFAULT NULL,
  `estado` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`),
  KEY `rolId` (`rolId`),
  KEY `idPersonaFK` (`idPersonaFK`),
  KEY `idInstitucionFK` (`idInstitucionFK`),
  CONSTRAINT `tb_usuarios_ibfk_1` FOREIGN KEY (`rolId`) REFERENCES `tb_roles` (`id`),
  CONSTRAINT `tb_usuarios_ibfk_2` FOREIGN KEY (`idPersonaFK`) REFERENCES `tb_personas` (`id`),
  CONSTRAINT `tb_usuarios_ibfk_3` FOREIGN KEY (`idInstitucionFK`) REFERENCES `tb_instituciones` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuarios`
--

LOCK TABLES `tb_usuarios` WRITE;
/*!40000 ALTER TABLE `tb_usuarios` DISABLE KEYS */;
INSERT INTO `tb_usuarios` VALUES (1,1,'i202014474@cibertec.edu.pe','1234',1,'2022-03-31 11:24:39',1,_binary ''),(2,2,'i202014475@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(3,3,'i202014476@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(4,4,'i202014477@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(5,5,'i202014478@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(6,6,'i202014479@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(7,7,'i202014470@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(8,8,'i202014471@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(9,9,'i202014480@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(10,10,'i202014481@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(11,11,'i202014482@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(12,12,'i202014483@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(13,13,'i202014484@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(14,14,'i202014485@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(15,15,'i202014486@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(16,16,'i202014487@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(17,17,'i202014488@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(18,18,'i202014489@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(19,19,'i202014490@cibertec.edu.pe','1234',3,'2022-03-31 11:24:39',1,_binary ''),(20,20,'representante@cibertec.edu.pe','1234',2,'2022-03-31 11:24:39',NULL,_binary '');
/*!40000 ALTER TABLE `tb_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_bibliotech_1'
--

--
-- Dumping routines for database 'bd_bibliotech_1'
--
/*!50003 DROP PROCEDURE IF EXISTS `USP_BuscarCategoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_BuscarCategoria`( IN thisid INT )
BEGIN

Select id,descripcion
		from TB_CATEGORIAS where  id=thisid;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_BuscarLibro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_BuscarLibro`(in thisid int )
BEGIN
Select id,title,title_long,isbn,isbn13,
		language,edition,pages,dimensions,synopsys,coverLink, estado
		from TB_LIBROS where id=thisid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_EliminarLibro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_EliminarLibro`(id int)
BEGIN
Update TB_LIBROS Set ESTADO = 1
		where Id=@id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_GetCategoriasLibrosDASH` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetCategoriasLibrosDASH`()
BEGIN
			SELECT descripcion CATEGORIA,COUNT(*) CANTIDAD FROM TB_PRESTAMOS p
			INNER JOIN TB_LIBRO_CATEGORIA lc ON lc.idLibroFK=p.idLibroFK
			INNER JOIN TB_CATEGORIAS c ON c.id=lc.idCategoriaFK
			inner join TB_USUARIOS u ON u.id=p.idUsuarioFK
			where u.idInstitucionFK=1
			group by c.descripcion;
	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_GetInteraccionesCategoriasDASH` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetInteraccionesCategoriasDASH`()
BEGIN
	SELECT c.descripcion CATEGORIAS, COUNT(*) CANTIDAD FROM TB_RATING_LIBROS r
	INNER JOIN TB_LIBRO_CATEGORIA lc ON r.idLibroFK=lc.idLibroFK
	INNER JOIN TB_CATEGORIAS c ON c.id=lc.idCategoriaFK
	inner join TB_USUARIOS u ON u.id=r.idUsuarioFK
			where u.idInstitucionFK=1
			group by c.descripcion;
	END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_GetLibrosRankDASH` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetLibrosRankDASH`()
BEGIN
SELECT l.title, COUNT(*) CANTIDAD FROM TB_RATING_LIBROS r
	INNER JOIN TB_LIBRO_CATEGORIA lc ON r.idLibroFK=lc.idLibroFK
	INNER JOIN TB_LIBROS l ON l.id=lc.idLibroFK
	inner join TB_USUARIOS u ON u.id=r.idUsuarioFK
			where u.idInstitucionFK=1
			group by l.title;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_ListarIntituciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_ListarIntituciones`()
BEGIN
Select id,nombre,idUsuarioRepresentanteFK,dominioInstitucion
		from TB_INSTITUCIONES;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `USP_ListarLibro` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_ListarLibro`()
BEGIN
	Select id,title,title_long,isbn,isbn13,
		language,edition,pages,dimensions,synopsys,coverLink
		from TB_LIBROS where ESTADO=1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-03  9:09:25
