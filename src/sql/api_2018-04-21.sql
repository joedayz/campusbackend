# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.9)
# Database: api
# Generation Time: 2018-04-21 17:14:41 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table curso
# ------------------------------------------------------------

DROP TABLE IF EXISTS `curso`;

CREATE TABLE `curso` (
  `curso_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `destacado_home` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `titulo_curso` varchar(200) NOT NULL,
  `titulo_footer_curso` varchar(100) NOT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `tipo_curso` bigint(20) NOT NULL,
  `key_curso` varchar(100) NOT NULL,
  `row_version` int(11) DEFAULT NULL,
  PRIMARY KEY (`curso_id`),
  UNIQUE KEY `UK_fbh6f3answ3ryu9s7po3i96gx` (`key_curso`),
  KEY `FKlpiv7eg4uiiyjfrvyyuar6sl4` (`tipo_curso`),
  CONSTRAINT `FK_drke58avar9uta9w7vuvyccma` FOREIGN KEY (`tipo_curso`) REFERENCES `tipo_curso` (`tipo_curso_id`),
  CONSTRAINT `FKlpiv7eg4uiiyjfrvyyuar6sl4` FOREIGN KEY (`tipo_curso`) REFERENCES `tipo_curso` (`tipo_curso_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;

INSERT INTO `curso` (`curso_id`, `created_by`, `created_date`, `destacado_home`, `status`, `titulo_curso`, `titulo_footer_curso`, `updated_by`, `updated_date`, `tipo_curso`, `key_curso`, `row_version`)
VALUES
	(113,'JOE','2016-06-15 18:53:38','N','A','ASP.NET MVC 3','ASP.NET MVC 3',NULL,NULL,7,'aspnetmvc3',0),
	(114,'JOE','2016-06-15 18:53:38','N','A','Test Driven Development con .NET','TDD .NET',NULL,NULL,7,'tddnet',0),
	(115,'JOE','2016-06-15 18:53:38','N','A','Spring Framework 2.0','Spring 2',NULL,NULL,7,'spring2',0),
	(116,'JOE','2016-06-15 18:53:38','N','A','Spring Boot','Spring Boot',NULL,NULL,7,'springboot1',0),
	(117,'JOE','2016-06-15 18:53:38','N','A','Spring Framework 3.0 y 4.0','Spring 3 y 4',NULL,NULL,7,'spring34',0),
	(118,'JOE','2016-06-15 18:53:38','N','A','Spring MVC 4','Spring MVC 4',NULL,NULL,7,'springmvc4',0),
	(119,'JOE','2016-06-15 18:53:38','N','A','Desarrollo de Servicios Web SOAP y REST con Java','Servicios Web',NULL,NULL,7,'serviciosweb1',0),
	(120,'JOE','2016-06-15 18:53:38','N','A','Oracle Certified Java 6','OCJP 6',NULL,NULL,7,'ocjp6',0),
	(121,'JOE','2016-06-15 18:53:38','N','A','Mule ESB','Mule ESB',NULL,NULL,7,'muleesb1',0),
	(122,'JOE','2016-06-15 18:53:38','N','A','Introducción a Java Web','Java Web',NULL,NULL,7,'introjavaweb',0),
	(123,'JOE','2016-06-15 18:53:38','N','A','Java Associate 7 y 8','Java Associate 8',NULL,NULL,7,'javaasocciate78',0),
	(124,'JOE','2016-06-15 18:53:38','N','A','Devops','Devops',NULL,NULL,7,'devops',0),
	(125,'JOE','2016-06-15 18:53:38','N','A','Vaadin 7','Vaadin 7',NULL,NULL,7,'vaadin',0),
	(126,'JOE','2016-06-15 18:53:38','N','A','Introducción a Ruby on Rails','RoR',NULL,NULL,7,'introror',0),
	(127,'JOE','2016-06-15 18:53:38','N','A','Java 7','Java 7',NULL,NULL,7,'java7',0),
	(128,'JOE','2016-06-15 18:53:38','N','A','Java 8','Java 8',NULL,NULL,7,'java8',0),
	(129,'JOE','2016-06-15 18:53:38','N','A','Hibernate','Hibernate',NULL,NULL,7,'hibernate',0),
	(130,'JOE','2016-06-15 18:53:38','N','A','Mybatis','Mybatis',NULL,NULL,7,'mybatis',0),
	(131,'JOE','2016-06-15 18:53:38','N','A','Desarrollo Web con Primefaces','Primefaces',NULL,NULL,7,'primefaces',0),
	(132,'JOE','2016-06-15 18:53:38','Y','A','Java EE 7','JavaEE 7',NULL,NULL,7,'javaee7',0),
	(133,'JOE','2016-06-15 18:53:38','N','A','Introducción a Python','Intro Python',NULL,NULL,7,'intropython',0),
	(134,'JOE','2016-06-15 18:53:38','N','A','Python para Zombies','Python para zombies',NULL,NULL,7,'pythonparazombies',0),
	(135,'JOE','2016-06-15 18:53:38','N','A','Angular JS','Angular JS',NULL,NULL,7,'angularjs1',0),
	(136,'JOE','2016-06-15 18:53:38','N','A','Iniciando con Android','Intro Android',NULL,NULL,7,'introandroid',0),
	(137,'JOE','2016-06-15 18:53:38','N','A','Almacenamiento de Datos con Android','SQLite Android',NULL,NULL,7,'sqliteandroid',0),
	(138,'JOE','2016-06-15 18:53:38','N','A','Integración con Servidores y Mapas','Mapas Android',NULL,NULL,7,'mapasgpsandroid',0),
	(139,'JOE','2016-06-15 18:53:38','N','A','Publiguia','Publiguia Android',NULL,NULL,7,'publiguiaandroid',0),
	(140,'JOE',NULL,'Y','A','Spring 4','Spring 4',NULL,NULL,5,'curso-spring-4',0);

/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table datos_curso
# ------------------------------------------------------------

DROP TABLE IF EXISTS `datos_curso`;

CREATE TABLE `datos_curso` (
  `datos_curso_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `descripcion_curso` varchar(1000) DEFAULT NULL,
  `instructor_curso` varchar(200) DEFAULT NULL,
  `metodologia_curso` varchar(100) DEFAULT NULL,
  `participantes_curso` varchar(20) DEFAULT NULL,
  `requisitos_curso` varchar(600) DEFAULT NULL,
  `syllabus_curso` varchar(200) DEFAULT NULL,
  `temas_curso` varchar(2000) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `curso_id` bigint(20) NOT NULL,
  `row_version` int(11) DEFAULT NULL,
  PRIMARY KEY (`datos_curso_id`),
  KEY `FKg6qfnjm3rwxwxnpin4idvjvne` (`curso_id`),
  CONSTRAINT `FK_nsxivfc5dlf9fi23avrg1kpdf` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`curso_id`),
  CONSTRAINT `FKg6qfnjm3rwxwxnpin4idvjvne` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`curso_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `datos_curso` WRITE;
/*!40000 ALTER TABLE `datos_curso` DISABLE KEYS */;

INSERT INTO `datos_curso` (`datos_curso_id`, `created_by`, `created_date`, `descripcion_curso`, `instructor_curso`, `metodologia_curso`, `participantes_curso`, `requisitos_curso`, `syllabus_curso`, `temas_curso`, `updated_by`, `updated_date`, `curso_id`, `row_version`)
VALUES
	(65,'JOE','2016-06-16 11:16:11','La implementación de Microsoft ASP.NET MVC proporciona una alternativa al modelo de formularios Web Forms de ASP.NET \npara crear aplicaciones web. ASP.NET MVC es un marco de presentación de poca complejidad y fácil de testear que,\n como las aplicaciones basadas en formularios Web Forms, se integra con características de ASP.NET como son las páginas maestras\n y la autenticación basada en pertenencias.\n\n','Claudia Caipo','Material, Código  y Video por clase','Ilimitado','C# y Conocimiento Básico de Desarrollo Web','https://www.dropbox.com/s/iwb0tdt8kckbru0/TALLER%20ASP.NET%20MVC4%20presencial.pdf?dl=0','ASP NET MVC 3',NULL,NULL,113,0),
	(66,'JOE','2016-06-16 11:16:13','Los participantes aprenderan a:\n. Diseñar y Desarrollar software dirigido por pruebas\n. Detectar cambios indeseados usando pruebas de regresión. \n. Capturar requerimientos y especificaciones como pruebas de aceptación \n. Aplicar las mejores prácticas para así superar las dificultades de escribir pruebas de aceptación unitarias. \n. Use xUnit, Moq, .NET/C# developers  ','Uzi Mamani','Material, Código  y Video por clase','Ilimitado','C#','https://www.dropbox.com/s/1wej7k0t34ziwlj/Test%20Driven%20Development%20en%20.NET.pdf?dl=0','Introducción a TDD \nUnit Test Básico\nTDD con xUnit para explorar y diseñar software \nEscribiendo pruebas unitarias eficientes. \nBuenas Prácticas y dificultades/daño colateral de las pruebas unitarias \n Aplicando Mocks y Stubs con Moq para aislar las pruebas. \nAplicando Técnicas refactoring básicas ',NULL,NULL,114,0),
	(67,'JOE','2016-06-16 11:16:16','En este curso el participante empezará a desarrollar aplicaciones web utilizando Spring Framework 2, \nconectando con base datos MySQL y Oracle. El IDE a utilizar será SpringSource Tool Suite.','José Díaz','Material, Código  y Video por clase','Ilimitado','Java','https://www.dropbox.com/s/defx808kdw4dgtm/JoeDayz%20-%20Academia%20SpringSource%20-%20Core%20Spring%203.0.pdf?dl=0','Spring Core\nSpring JDBC\nSpring ORM\nSpring MVC\nSpring Security\nSpring WS',NULL,NULL,115,0),
	(68,'JOE','2016-06-16 11:16:17','Curso de desarrollo web utilizando Spring Boot y Spring 4.','José Díaz','Material, Código  y Video por clase','Ilimitado','Java','https://www.dropbox.com/s/gdvyslrescwb7k6/JoeDayz-CoreSpringFramework4.0.pdf?dl=0','Spring Boot con AngularJS',NULL,NULL,116,0),
	(69,'JOE','2016-06-16 11:16:19','Curso de desarrollo web utilizando Spring Boot y Spring 4.','José Díaz','Material, Código  y Video por clase','Ilimitado','Java','https://www.dropbox.com/s/gdvyslrescwb7k6/JoeDayz-CoreSpringFramework4.0.pdf?dl=0','Spring Core\nSpring JDBC\nSpring ORM\nSpring MVC\nSpring Security\nSpring WS',NULL,NULL,117,0),
	(70,'JOE','2016-06-16 11:16:20','Desarrollo de una aplicación web con Spring MVC y Jquery','José Díaz','Material, Código  y Video por clase','Ilimitado','Java','https://www.dropbox.com/s/gdvyslrescwb7k6/JoeDayz-CoreSpringFramework4.0.pdf?dl=0','Spring MVC 4\nJquery',NULL,NULL,118,0),
	(71,'JOE','2016-06-16 11:16:22','Servicios Web SOAP y REST','José Díaz','Material, Código  y Video por clase','Ilimitado','Java','https://www.dropbox.com/s/zghp3itesgtnpgr/JoeDayz%20-%20Desarrollador%20Empresarial%20Java%20EE%20Online.pdf?dl=0','SOAP\nREST',NULL,NULL,119,0),
	(72,'JOE','2016-06-16 11:16:23','Oracle Certified Java Programmer 6','José Díaz','Material, Código  y Video por clase','Ilimitado','Java','https://www.dropbox.com/s/ewcx1rzu4s5yt7j/Silabus%20OCJP%206.0%202013.pdf?dl=0','Objetivos para la OCJP 6',NULL,NULL,120,0),
	(73,'JOE','2016-06-16 11:16:25','Mule ESB','Eddú Melendez','Material, Código  y Video por clase','Ilimitado','Java','https://www.dropbox.com/s/h48tcly1q8d83rq/MuleESB.pdf?dl=0','Introducción a MuleESB \nEmpezando con Anypoint Studio, Maven, Gradle \nConstruir Aplicaciones de Integración \nRefactorizando Aplicaciones Mule \n Transformadores \n Mule Expression Language (MEL) \n Manejo de Errores \n Construir Aplicaciones RESTful con RAML \n Test con MUnit  ',NULL,NULL,121,0),
	(74,'JOE','2016-06-16 11:16:27','Introducción a Java Web','José Díaz','Material, Código  y Video por clase','Ilimitado','Java','https://www.dropbox.com/s/ihptbp05ph4e1up/JoeDayz%20-%20Desarrollador%20Empresarial%20Java%20EE%20Online.pdf?dl=0','Introducción a Java Web',NULL,NULL,122,0),
	(75,'JOE','2016-06-16 11:16:29','Java Associate 8','José Díaz','Material, Código  y Video por clase','Ilimitado','Java','https://www.dropbox.com/s/0u6bduut5ns3cx2/JoeDayz-JavaSE78-Associate.pdf?dl=0','Java Associate',NULL,NULL,123,0),
	(76,'JOE','2016-06-16 11:16:31','Devops','Antony Bendezu','Material, Código  y Video por clase','Ilimitado','Linux','#','Devops',NULL,NULL,124,0),
	(77,'JOE','2016-06-16 11:16:32','Vaadin 7','Miguel Timana','Material, Código  y Video por clase','Ilimitado','Java','https://www.dropbox.com/s/8y1hh2eeu57l7iw/JoeDayz%20Curso%20Vaadin.pdf?dl=0','Vaadin',NULL,NULL,125,0),
	(78,'JOE','2016-06-16 11:16:34','Introducción a Ruby on Rails','José Díaz','Material, Código  y Video por clase','Ilimitado','Conocer otro lenguaje y\n conocimientos básicos de desarrollo web','https://www.dropbox.com/s/0t81mizrc0hxvvr/JoeDayz%20-%20Diplomado%20Ruby%20on%20Rails%20Online.pdf?dl=0','Ruby\nRails',NULL,NULL,126,0),
	(79,'JOE','2016-06-16 11:16:36','Java 7 ','José Díaz','Material, Código  y Video por clase','Ilimitado','Java','https://www.dropbox.com/s/4a655dxckxfvt5u/JoeDayz-JavaSE7-Fundamentos.pdf?dl=0','Java',NULL,NULL,127,0),
	(80,'JOE','2016-06-16 11:16:38','Java 8','José Díaz','Material, Código  y Video por clase','Ilimitado','Java','https://www.dropbox.com/s/zghp3itesgtnpgr/JoeDayz%20-%20Desarrollador%20Empresarial%20Java%20EE%20Online.pdf?dl=0','Java',NULL,NULL,128,0),
	(81,'JOE','2016-06-16 11:16:40','Hibernate','José Díaz','Material, Código  y Video por clase','Ilimitado','Java','https://www.dropbox.com/s/zghp3itesgtnpgr/JoeDayz%20-%20Desarrollador%20Empresarial%20Java%20EE%20Online.pdf?dl=0','Java',NULL,NULL,129,0),
	(82,'JOE','2016-06-16 11:16:42','MyBatis','José Díaz','Material, Código  y Video por clase','Ilimitado','Java','https://www.dropbox.com/s/zghp3itesgtnpgr/JoeDayz%20-%20Desarrollador%20Empresarial%20Java%20EE%20Online.pdf?dl=0','Java',NULL,NULL,130,0),
	(83,'JOE','2016-06-16 11:16:44','Desarrollo Web con Primefaces','José Díaz','Material, Código  y Video por clase','Ilimitado','Java','https://www.dropbox.com/s/zghp3itesgtnpgr/JoeDayz%20-%20Desarrollador%20Empresarial%20Java%20EE%20Online.pdf?dl=0','Java',NULL,NULL,131,0),
	(84,'JOE','2016-06-16 11:16:46','Java EE 7','José Díaz','Material, Código  y Video por clase','Ilimitado','Java','https://www.dropbox.com/s/zghp3itesgtnpgr/JoeDayz%20-%20Desarrollador%20Empresarial%20Java%20EE%20Online.pdf?dl=0','Java',NULL,NULL,132,0),
	(85,'JOE','2016-06-16 11:16:48','Python','Eysenck Gomez','Material, Código  y Video por clase','Ilimitado','Java','https://www.dropbox.com/s/zofphc7eh333hbl/TALLER%20PYTHON.pdf?dl=0','Python',NULL,NULL,133,0),
	(86,'JOE','2016-06-16 11:16:50','Python para Zombies','José Díaz','Material, Código  y Video por clase','Ilimitado','Fundamentos de programación','#','Python',NULL,NULL,134,0),
	(87,'JOE','2016-06-16 11:16:52','Angular JS','Israel Rosas','Material, Código  y Video por clase','Ilimitado','JavaScript Básico','https://www.dropbox.com/s/0db600p04rwaxxk/Taller%20de%20AngularJS.pdf?dl=0','JavaScript\nAngularJS',NULL,NULL,135,0),
	(88,'JOE','2016-06-16 11:16:55','Iniciando con Android','José Díaz','Material, Código  y Video por clase','Ilimitado','Android','https://www.dropbox.com/s/rdz4g3u3xftcxzt/TALLER%20ANDROID.pdf?dl=0','Android',NULL,NULL,136,0),
	(89,'JOE','2016-06-16 11:16:56','SQLite con Android','José Díaz','Material, Código  y Video por clase','Ilimitado','Android','https://www.dropbox.com/s/rdz4g3u3xftcxzt/TALLER%20ANDROID.pdf?dl=0','Android',NULL,NULL,137,0),
	(90,'JOE','2016-06-16 11:16:58','Integración con Servidores y Mapas','José Díaz','Material, Código  y Video por clase','Ilimitado','Android','https://www.dropbox.com/s/rdz4g3u3xftcxzt/TALLER%20ANDROID.pdf?dl=0','Android',NULL,NULL,138,0),
	(91,'JOE','2016-06-16 11:17:00','Publiguia','José Díaz','Material, Código  y Video por clase','Ilimitado','Android','https://www.dropbox.com/s/rdz4g3u3xftcxzt/TALLER%20ANDROID.pdf?dl=0','Android',NULL,NULL,139,0),
	(92,'JOE',NULL,'Spring 4','Jose Diaz','8 clases presenciales, codigo','9','Java','http://google.com',NULL,NULL,NULL,140,0);

/*!40000 ALTER TABLE `datos_curso` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table detalles_curso
# ------------------------------------------------------------

DROP TABLE IF EXISTS `detalles_curso`;

CREATE TABLE `detalles_curso` (
  `detalles_curso_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `costo` decimal(19,2) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `duracion_curso` varchar(200) DEFAULT NULL,
  `fecha_inscripcion_curso` varchar(200) DEFAULT NULL,
  `horarios_curso` varchar(200) DEFAULT NULL,
  `membresiaAnual` decimal(19,2) DEFAULT NULL,
  `numero_participantes` varchar(200) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `curso_id` bigint(20) NOT NULL,
  `row_version` int(11) DEFAULT NULL,
  `membresia_anual` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`detalles_curso_id`),
  KEY `FK8qrguh82yxp7gwc9wxnt12ru1` (`curso_id`),
  CONSTRAINT `FK8qrguh82yxp7gwc9wxnt12ru1` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`curso_id`),
  CONSTRAINT `FK_4hea0wpylpnna8sxgwcp7toli` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`curso_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `detalles_curso` WRITE;
/*!40000 ALTER TABLE `detalles_curso` DISABLE KEYS */;

INSERT INTO `detalles_curso` (`detalles_curso_id`, `costo`, `created_by`, `created_date`, `duracion_curso`, `fecha_inscripcion_curso`, `horarios_curso`, `membresiaAnual`, `numero_participantes`, `updated_by`, `updated_date`, `curso_id`, `row_version`, `membresia_anual`)
VALUES
	(3,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,113,0,NULL),
	(4,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,114,0,NULL),
	(5,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,115,0,NULL),
	(6,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,116,0,NULL),
	(7,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,117,0,NULL),
	(8,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,118,0,NULL),
	(9,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,119,0,NULL),
	(10,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,120,0,NULL),
	(11,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,121,0,NULL),
	(12,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,122,0,NULL),
	(13,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,123,0,NULL),
	(14,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,124,0,NULL),
	(15,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,125,0,NULL),
	(16,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,126,0,NULL),
	(17,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,127,0,NULL),
	(18,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,128,0,NULL),
	(19,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,129,0,NULL),
	(20,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,130,0,NULL),
	(21,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,131,0,NULL),
	(22,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,132,0,NULL),
	(23,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,133,0,NULL),
	(24,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,134,0,NULL),
	(25,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,135,0,NULL),
	(26,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,136,0,NULL),
	(27,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,137,0,NULL),
	(28,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,138,0,NULL),
	(29,175.00,'JOE','2016-06-16 11:35:41','Mientras tenga membresía vigente','Cuando Ud. Lo desee','Disponible las 24 horas',100.00,'Ilimitado',NULL,NULL,139,0,NULL),
	(30,1000.00,'JOE',NULL,'Del 16 de Julio al 3 de Septiembre 2016','Hasta el 15 de julio','Sabados de 9am a 1pm',0.00,'9',NULL,NULL,140,0,NULL);

/*!40000 ALTER TABLE `detalles_curso` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table general_table
# ------------------------------------------------------------

DROP TABLE IF EXISTS `general_table`;

CREATE TABLE `general_table` (
  `general_table_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `sort_order` decimal(19,2) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `table_name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `row_version` int(11) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`general_table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `general_table` WRITE;
/*!40000 ALTER TABLE `general_table` DISABLE KEYS */;

INSERT INTO `general_table` (`general_table_id`, `code`, `sort_order`, `status`, `table_name`, `value`, `created_by`, `created_date`, `row_version`, `updated_by`, `updated_date`)
VALUES
	(1,'A',1.00,'A','pe.joedayz.api.enums.StatusEnum','Active','JOE','2016-09-02 00:00:00',0,'JOE','2016-09-02 00:00:00'),
	(2,'L',2.00,'A','pe.joedayz.api.enums.StatusEnum','Locked','JOE','2016-09-02 00:00:00',0,'JOE','2016-09-02 00:00:00'),
	(3,'I',3.00,'A','pe.joedayz.api.enums.StatusEnum','Inactive','JOE','2016-09-02 00:00:00',0,'JOE','2016-09-02 00:00:00'),
	(4,'ADMIN',1.00,'A','pe.joedayz.api.enums.RoleEnum','Admin','JOE','2016-09-02 00:00:00',0,'joe','2016-09-02 00:00:00'),
	(5,'PROFESOR',2.00,'A','pe.joedayz.api.enums.RoleEnum','Profesor','JOE','2016-09-02 00:00:00',0,'JOE','2016-09-02 00:00:00'),
	(6,'ESTUDIANTE',3.00,'A','pe.joedayz.api.enums.RoleEnum','Estudiante','JOE','2016-09-02 00:00:00',0,'JOE','2016-09-02 00:00:00'),
	(7,'N',1.00,'A','pe.joedayz.api.enums.PermissionTypeEnum','None (No access)','JOE','2016-09-02 00:00:00',0,'JOE','2016-09-02 00:00:00'),
	(8,'R',2.00,'A','pe.joedayz.api.enums.PermissionTypeEnum','Read Only','JOE','2016-09-02 00:00:00',0,'JOE','2016-09-02 00:00:00'),
	(9,'W',3.00,'A','pe.joedayz.api.enums.PermissionTypeEnum','Edit (Write access)','JOE','2016-09-02 00:00:00',0,'joe','2016-09-02 00:00:00'),
	(10,'1',1.00,'A','pe.joedayz.api.enums.ModuleVisibleEnum','True - Visible','JOE','2016-09-02 00:00:00',0,'JOE','2016-09-02 00:00:00'),
	(11,'0',2.00,'A','pe.joedayz.api.enums.ModuleVisibleEnum','False - No Visible','JOE','2016-09-02 00:00:00',0,'JOE','2016-09-02 00:00:00'),
	(12,'A',1.00,'A','pe.joedayz.api.enums.GeneralTableStatusEnum','Active','JOE','2016-09-02 00:00:00',0,'JOE','2016-09-02 00:00:00'),
	(13,'I',2.00,'A','pe.joedayz.api.enums.GeneralTableStatusEnum','Inactive','JOE','2016-09-02 00:00:00',0,'JOE','2016-09-02 00:00:00'),
	(14,'A',1.00,'A','pe.joedayz.api.enums.ActiveInactiveStatusEnum','Active','JOE','2016-09-02 00:00:00',0,'joe','2016-09-02 00:00:00'),
	(15,'I',2.00,'A','pe.joedayz.api.enums.ActiveInactiveStatusEnum','Inactive','JOE','2016-09-02 00:00:00',0,'joe','2016-09-02 00:00:00'),
	(16,'Y',1.00,'A','pe.joedayz.api.enums.YesNoEnum','Yes','JOE','2016-09-02 00:00:00',0,'joe','2016-09-02 00:00:00'),
	(17,'Y',2.00,'A','pe.joedayz.api.enums.YesNoEnum','No','JOE','2016-09-02 00:00:00',0,'JOE','2016-09-02 00:00:00'),
	(18,'A',1.00,'A','pe.joedayz.api.enums.UserStatusEnum','Active','JOE','2016-09-02 00:00:00',0,'JOE','2016-09-02 00:00:00'),
	(19,'L',2.00,'A','pe.joedayz.api.enums.UserStatusEnum','Locked','JOE','2016-09-02 00:00:00',0,'JOE','2016-09-02 00:00:00'),
	(20,'I',3.00,'A','pe.joedayz.api.enums.UserStatusEnum','Inactive','JOE','2016-09-02 00:00:00',0,'JOE','2016-09-02 00:00:00');

/*!40000 ALTER TABLE `general_table` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table hangout
# ------------------------------------------------------------

DROP TABLE IF EXISTS `hangout`;

CREATE TABLE `hangout` (
  `hangout_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `descripcion` varchar(1000) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `titulo` varchar(200) NOT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `url` varchar(200) NOT NULL,
  `row_version` int(11) DEFAULT NULL,
  `ponente` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hangout_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table module
# ------------------------------------------------------------

DROP TABLE IF EXISTS `module`;

CREATE TABLE `module` (
  `module_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `help_url` varchar(255) DEFAULT NULL,
  `menu_label` varchar(255) DEFAULT NULL,
  `menu_order` decimal(19,2) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `visible` varchar(255) DEFAULT NULL,
  `parent_module_id` bigint(20) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  `row_version` int(11) DEFAULT NULL,
  PRIMARY KEY (`module_id`),
  KEY `FKo2o4pixojr569rh9ul6kbxi7k` (`parent_module_id`),
  CONSTRAINT `FK_g2qk0q05204lfeowib78ii6yh` FOREIGN KEY (`parent_module_id`) REFERENCES `module` (`module_id`),
  CONSTRAINT `FKo2o4pixojr569rh9ul6kbxi7k` FOREIGN KEY (`parent_module_id`) REFERENCES `module` (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;

INSERT INTO `module` (`module_id`, `code`, `help_url`, `menu_label`, `menu_order`, `name`, `url`, `visible`, `parent_module_id`, `created_by`, `created_date`, `updated_by`, `updated_date`, `row_version`)
VALUES
	(35,'C1',NULL,'Java',0.00,'Java','#','Y',NULL,'CELTIC','2016-06-16',NULL,NULL,0),
	(36,'C2',NULL,'Java EE',0.00,'Java EE','#','Y',NULL,'CELTIC','2016-06-16',NULL,NULL,0),
	(37,'C3',NULL,'Android',0.00,'Android','#','Y',NULL,'CELTIC','2016-06-16',NULL,NULL,0),
	(38,'C4',NULL,'Devops',0.00,'Devops','#','Y',NULL,'CELTIC','2016-06-16',NULL,NULL,0),
	(39,'C5',NULL,'Ruby',0.00,'Ruby','#','Y',NULL,'CELTIC','2016-06-16',NULL,NULL,0),
	(40,'C6',NULL,'Python',0.00,'Python','#','Y',NULL,'CELTIC','2016-06-16',NULL,NULL,0),
	(41,'C7',NULL,'.NET',0.00,'.NET','#','Y',NULL,'CELTIC','2016-06-16',NULL,NULL,0),
	(42,'C8',NULL,'Frontend',0.00,'Frontend','#','Y',NULL,'CELTIC','2016-06-16',NULL,NULL,0),
	(43,'C11',NULL,'ASP.NET MVC 3',1.00,'ASP.NET MVC 3','curso.contenido.aspnetmvc3','Y',41,'CELTIC','2016-06-16',NULL,NULL,0),
	(44,'C12',NULL,'TDD .NET',2.00,'Test Driven Development con .NET','curso.contenido.tddnet','Y',41,'CELTIC','2016-06-16',NULL,NULL,0),
	(45,'C13',NULL,'Spring 2',3.00,'Spring Framework 2.0','curso.contenido.spring2','Y',36,'CELTIC','2016-06-16',NULL,NULL,0),
	(46,'C14',NULL,'Spring Boot',4.00,'Spring Boot','curso.contenido.springboot1','Y',36,'CELTIC','2016-06-16',NULL,NULL,0),
	(47,'C15',NULL,'Spring 3 y 4',5.00,'Spring Framework 3.0 y 4.0','curso.contenido.spring34','Y',36,'CELTIC','2016-06-16',NULL,NULL,0),
	(48,'C16',NULL,'Spring MVC 4',6.00,'Spring MVC 4','curso.contenido.springmvc4','Y',36,'CELTIC','2016-06-16',NULL,NULL,0),
	(49,'C17',NULL,'Servicios Web',7.00,'Desarrollo de Servicios Web SOAP y REST con Java','curso.contenido.serviciosweb1','Y',36,'CELTIC','2016-06-16',NULL,NULL,0),
	(50,'C18',NULL,'OCJP 6',8.00,'Oracle Certified Java 6','curso.contenido.ocjp6','Y',35,'CELTIC','2016-06-16',NULL,NULL,0),
	(51,'C19',NULL,'Mule ESB',9.00,'Mule ESB','curso.contenido.muleesb1','Y',36,'CELTIC','2016-06-16',NULL,NULL,0),
	(52,'C20',NULL,'Java Web',10.00,'Introducción a Java Web','curso.contenido.introjavaweb','Y',36,'CELTIC','2016-06-16',NULL,NULL,0),
	(53,'C21',NULL,'Java Associate 8',11.00,'Java Associate 7 y 8','curso.contenido.javaasocciate78','Y',35,'CELTIC','2016-06-16',NULL,NULL,0),
	(54,'C22',NULL,'Devops',12.00,'Devops','curso.contenido.devops','Y',38,'CELTIC','2016-06-16',NULL,NULL,0),
	(55,'C23',NULL,'Vaadin 7',13.00,'Vaadin 7','curso.contenido.vaadin','Y',36,'CELTIC','2016-06-16',NULL,NULL,0),
	(56,'C24',NULL,'RoR',14.00,'Introducción a Ruby on Rails','curso.contenido.introror','Y',39,'CELTIC','2016-06-16',NULL,NULL,0),
	(57,'C25',NULL,'Java 7',15.00,'Java 7','curso.contenido.java7','Y',35,'CELTIC','2016-06-16',NULL,NULL,0),
	(58,'C26',NULL,'Java 8',16.00,'Java 8','curso.contenido.java8','Y',35,'CELTIC','2016-06-16',NULL,NULL,0),
	(59,'C27',NULL,'Hibernate',17.00,'Hibernate','curso.contenido.hibernate','Y',36,'CELTIC','2016-06-16',NULL,NULL,0),
	(60,'C28',NULL,'Mybatis',18.00,'Mybatis','curso.contenido.mybatis','Y',36,'CELTIC','2016-06-16',NULL,NULL,0),
	(61,'C29',NULL,'Primefaces',19.00,'Desarrollo Web con Primefaces','curso.contenido.primefaces','Y',36,'CELTIC','2016-06-16',NULL,NULL,0),
	(62,'C30',NULL,'JavaEE 7',20.00,'Java EE 7','curso.contenido.javaee7','Y',36,'CELTIC','2016-06-16',NULL,NULL,0),
	(63,'C31',NULL,'Intro Python',21.00,'Introducción a Python','curso.contenido.intropython','Y',40,'CELTIC','2016-06-16',NULL,NULL,0),
	(64,'C32',NULL,'Python para zombies',22.00,'Python para Zombies','curso.contenido.pythonparazombies','Y',40,'CELTIC','2016-06-16',NULL,NULL,0),
	(65,'C33',NULL,'Angular JS',23.00,'Angular JS','curso.contenido.angularjs1','Y',42,'CELTIC','2016-06-16',NULL,NULL,0),
	(66,'C34',NULL,'Intro Android',24.00,'Iniciando con Android','curso.contenido.introandroid','Y',37,'CELTIC','2016-06-16',NULL,NULL,0),
	(67,'C35',NULL,'SQLite Android',25.00,'Almacenamiento de Datos con Android','curso.contenido.sqliteandroid','Y',37,'CELTIC','2016-06-16',NULL,NULL,0),
	(68,'C36',NULL,'Mapas Android',26.00,'Integración con Servidores y Mapas','curso.contenido.mapasgpsandroid','Y',37,'CELTIC','2016-06-16',NULL,NULL,0),
	(69,'C37',NULL,'Publiguia Android',27.00,'Publiguia','curso.contenido.publiguiaandroid','Y',37,'CELTIC','2016-06-16',NULL,NULL,0),
	(70,'SE00',NULL,'Seguridad',1.00,'Seguridad','ic-security','Y',NULL,NULL,NULL,NULL,NULL,0),
	(71,'RL01',NULL,'Roles',2.00,'Roles','role.search','Y',70,NULL,NULL,NULL,NULL,0),
	(72,'RL02',NULL,'Roles New',3.00,'Roles New','role.new','N',70,NULL,NULL,NULL,NULL,0),
	(73,'RL03',NULL,'Roles Edit',4.00,'Roles Edit','role.edit','N',70,NULL,NULL,NULL,NULL,0);

/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table parameter
# ------------------------------------------------------------

DROP TABLE IF EXISTS `parameter`;

CREATE TABLE `parameter` (
  `parameter_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `row_version` int(11) DEFAULT NULL,
  PRIMARY KEY (`parameter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table permission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `permission_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `permission_type` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  `module_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `row_version` int(11) DEFAULT NULL,
  PRIMARY KEY (`permission_id`),
  KEY `FKrfeq354xn8likoa217hpvev6d` (`module_id`),
  KEY `FKrvhjnns4bvlh4m1n97vb7vbar` (`role_id`),
  CONSTRAINT `FK_2b20w6doiroujekdjbcpav5xi` FOREIGN KEY (`module_id`) REFERENCES `module` (`module_id`),
  CONSTRAINT `FK_b6es3ecbp4mld88jninpu9fg8` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `FKrfeq354xn8likoa217hpvev6d` FOREIGN KEY (`module_id`) REFERENCES `module` (`module_id`),
  CONSTRAINT `FKrvhjnns4bvlh4m1n97vb7vbar` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;

INSERT INTO `permission` (`permission_id`, `created_by`, `created_date`, `permission_type`, `updated_by`, `updated_date`, `module_id`, `role_id`, `row_version`)
VALUES
	(5,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',43,5,0),
	(6,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',44,5,0),
	(7,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',45,5,0),
	(8,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',46,5,0),
	(9,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',47,5,0),
	(10,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',48,5,0),
	(11,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',49,5,0),
	(12,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',50,5,0),
	(13,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',51,5,0),
	(14,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',52,5,0),
	(15,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',53,5,0),
	(16,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',54,5,0),
	(17,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',55,5,0),
	(18,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',56,5,0),
	(19,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',57,5,0),
	(20,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',58,5,0),
	(21,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',59,5,0),
	(22,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',60,5,0),
	(23,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',61,5,0),
	(24,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',62,5,0),
	(25,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',63,5,0),
	(26,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',64,5,0),
	(27,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',65,5,0),
	(28,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',66,5,0),
	(29,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',67,5,0),
	(30,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',68,5,0),
	(31,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',69,5,0),
	(32,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',43,6,0),
	(33,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',44,6,0),
	(34,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',45,6,0),
	(35,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',46,6,0),
	(36,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',47,6,0),
	(37,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',48,6,0),
	(38,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',49,6,0),
	(39,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',50,6,0),
	(40,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',51,6,0),
	(41,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',52,6,0),
	(42,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',53,6,0),
	(43,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',54,6,0),
	(44,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',55,6,0),
	(45,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',56,6,0),
	(46,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',57,6,0),
	(47,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',58,6,0),
	(48,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',59,6,0),
	(49,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',60,6,0),
	(50,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',61,6,0),
	(51,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',62,6,0),
	(52,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',63,6,0),
	(53,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',64,6,0),
	(54,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',65,6,0),
	(55,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',66,6,0),
	(56,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',67,6,0),
	(57,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',68,6,0),
	(58,'CELTIC','2016-06-16','W','CELTIC','2016-06-16',69,6,0),
	(59,NULL,NULL,'W',NULL,NULL,71,5,0),
	(60,NULL,NULL,'W',NULL,NULL,72,5,0),
	(61,NULL,NULL,'W',NULL,NULL,73,5,0),
	(62,NULL,NULL,'W',NULL,NULL,71,6,0),
	(63,NULL,NULL,'W',NULL,NULL,72,6,0),
	(64,NULL,NULL,'W',NULL,NULL,73,6,0);

/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table portada
# ------------------------------------------------------------

DROP TABLE IF EXISTS `portada`;

CREATE TABLE `portada` (
  `portada_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `descripcion_foto` varchar(150) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `titulo_foto` varchar(100) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `url_foto` varchar(200) NOT NULL,
  `row_version` int(11) DEFAULT NULL,
  PRIMARY KEY (`portada_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `portada` WRITE;
/*!40000 ALTER TABLE `portada` DISABLE KEYS */;

INSERT INTO `portada` (`portada_id`, `created_by`, `created_date`, `descripcion_foto`, `status`, `titulo_foto`, `updated_by`, `updated_date`, `url_foto`, `row_version`)
VALUES
	(1,'JOE','2016-06-15 17:59:21','Foto 1','A','Foto 1','JOE','2016-06-15 17:59:21','foto1.jpg',0),
	(2,'JOE','2016-06-15 17:59:22','Foto 2','A','Foto 2','JOE','2016-06-15 17:59:22','foto2.jpg',0),
	(3,'JOE','2016-06-15 17:59:22','Foto 3','A','Foto 3','JOE','2016-06-15 17:59:22','foto3.jpg',0),
	(4,'JOE','2016-06-15 17:59:22','Foto 4','A','Foto 4','JOE','2016-06-15 17:59:22','foto4.jpg',0);

/*!40000 ALTER TABLE `portada` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table reset_registry
# ------------------------------------------------------------

DROP TABLE IF EXISTS `reset_registry`;

CREATE TABLE `reset_registry` (
  `reset_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `row_version` int(11) DEFAULT NULL,
  PRIMARY KEY (`reset_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `reset_registry` WRITE;
/*!40000 ALTER TABLE `reset_registry` DISABLE KEYS */;

INSERT INTO `reset_registry` (`reset_id`, `created_by`, `created_date`, `status`, `token`, `updated_by`, `updated_date`, `user_name`, `row_version`)
VALUES
	(1,'testuser','2016-06-13 12:50:44',NULL,'[B@71b1aee3',NULL,NULL,'joe',0),
	(2,'testuser','2016-06-13 12:51:13',NULL,'[B@57031adb',NULL,NULL,'joe',0),
	(3,'testuser','2016-06-13 12:52:46',NULL,'[B@441821f9',NULL,NULL,'joe',0),
	(4,'testuser','2016-06-13 12:55:40',NULL,'[B@7d6ef2d0',NULL,NULL,'joe',0),
	(5,'testuser','2016-06-13 12:57:43',NULL,'[B@672d7280',NULL,NULL,'joe',0),
	(6,'testuser','2016-06-13 13:01:45',NULL,'[B@203f8196',NULL,NULL,'joe',0),
	(7,'testuser','2016-06-13 13:04:26',NULL,'[B@1a2dd9d1',NULL,NULL,'joe',0),
	(8,'testuser','2016-06-13 13:09:20',NULL,'[B@7dcc37ba',NULL,NULL,'joe',0),
	(9,'testuser','2016-06-13 14:18:52',NULL,'[B@4f2b95b',NULL,NULL,'joe',0),
	(10,'cron-usr','2016-10-29 13:23:20',NULL,'[B@4974a3d3',NULL,NULL,'joe',0),
	(11,'cron-usr','2016-12-05 00:59:22',NULL,'[B@9842c43',NULL,NULL,'joe',0),
	(12,'cron-usr','2016-12-05 01:02:24',NULL,'[B@3fa9157f',NULL,NULL,'joe',0),
	(13,'cron-usr','2016-12-05 01:08:22',NULL,'[B@2663e259',NULL,NULL,'joe',0),
	(14,'cron-usr','2017-01-23 19:52:05',NULL,'[B@b6df647',NULL,NULL,'joe',0),
	(15,'cron-usr','2017-01-23 20:07:47',NULL,'[B@6dfc2b8c',NULL,NULL,'joe',0),
	(16,'cron-usr','2017-01-23 20:08:43',NULL,'[B@5ecfc179',NULL,NULL,'joe',0),
	(17,'cron-usr','2017-01-23 20:10:42',NULL,'[B@7c7fb95e',NULL,NULL,'joe',0);

/*!40000 ALTER TABLE `reset_registry` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `row_version` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;

INSERT INTO `role` (`role_id`, `code`, `created_by`, `created_date`, `role_name`, `updated_by`, `updated_date`, `row_version`, `status`)
VALUES
	(1,'ADMIN','JOE','2016-09-02 00:00:00','Admin','JOE','2016-09-02 00:00:00',0,'A'),
	(5,'ESTUDIANTE','JOE','2016-06-15 17:45:23','Estudiante','JOE','2016-06-15 17:45:23',0,'A'),
	(6,'PROFESOR','JOE','2016-06-15 17:45:24','Profesor','JOE','2016-06-15 17:45:24',0,'A');

/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table temas_curso
# ------------------------------------------------------------

DROP TABLE IF EXISTS `temas_curso`;

CREATE TABLE `temas_curso` (
  `temas_curso_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `descripcion` varchar(600) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `tema_orden` decimal(19,2) DEFAULT NULL,
  `titulo` varchar(200) NOT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `url` varchar(200) NOT NULL,
  `curso_id` bigint(20) NOT NULL,
  `row_version` int(11) DEFAULT NULL,
  PRIMARY KEY (`temas_curso_id`),
  KEY `FK7w6rhmeh25nsd6fdk5vim7f3d` (`curso_id`),
  CONSTRAINT `FK7w6rhmeh25nsd6fdk5vim7f3d` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`curso_id`),
  CONSTRAINT `FK_3jyabomqtbhiiw9vobvd5gpef` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`curso_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `temas_curso` WRITE;
/*!40000 ALTER TABLE `temas_curso` DISABLE KEYS */;

INSERT INTO `temas_curso` (`temas_curso_id`, `created_by`, `created_date`, `descripcion`, `status`, `tema_orden`, `titulo`, `updated_by`, `updated_date`, `url`, `curso_id`, `row_version`)
VALUES
	(17,'JOE','2016-06-16 15:48:23','Primera Clase','A',1.00,'Primera Clase',NULL,NULL,'https://www.dropbox.com/s/lo3ch1skvg4icec/Primera%2Bclase%2Bde%2BSpring%2B4-9-13%2B7.36%2BPM.mov?dl=0',115,0),
	(18,'JOE','2016-06-16 15:48:23','Segunda Clase','A',2.00,'Segunda Clase',NULL,NULL,'https://www.dropbox.com/s/zhslpetw97ae7nd/Segunda%2Bclase%2Bde%2BSpring%2B3%2B4-12-13%2B7.45%2BPM.mov?dl=0',115,0),
	(19,'JOE','2016-06-16 15:48:23','Tercera Clase','A',3.00,'Tercera Clase',NULL,NULL,'https://www.dropbox.com/s/62y676jyz2hi04h/Tercera%2Bclase%2Bde%2BSpring%2B3%2B4-16-13%2B7.46%2BPM.mov?dl=0',115,0),
	(20,'JOE','2016-06-16 15:48:23','Cuarta Clase','A',4.00,'Cuarta Clase',NULL,NULL,'https://www.dropbox.com/s/2gdpak5pahs9t7j/Cuarta%2BClase%2Bde%2BSpring%2B3%2B4-18-13%2B7.43%2BPM.mov?dl=0',115,0),
	(21,'JOE','2016-06-16 15:48:23','Quinta Clase','A',5.00,'Quinta Clase',NULL,NULL,'https://www.dropbox.com/s/5qydfg7059ouznw/Quinta%2BClase%2Bde%2BSpring%2B3%2B4-23-13%2B7.48%2BPM.mov?dl=0',115,0),
	(22,'JOE','2016-06-16 15:48:23','Sexta Clase','A',6.00,'Sexta Clase',NULL,NULL,'https://www.dropbox.com/s/iapx7rmzi4tvzi9/6ta%2Bclase%2Bde%2BSpring%2B3%2B4-25-13%2B8.08%2BPM.mov?dl=0',115,0),
	(23,'JOE','2016-06-16 15:48:23','Septima Clase','A',7.00,'Septima Clase',NULL,NULL,'https://www.dropbox.com/s/8liqztw42qmncim/RepasoSpringMVC.mov?dl=0',115,0),
	(24,'JOE','2016-06-16 15:48:23','Octava Clase','A',8.00,'Octava Clase',NULL,NULL,'https://www.dropbox.com/s/moczw562gk57fc4/Septima%2BClase%2B%2B5-2-13%2B8.01%2BPM%2B2.mov?dl=0',115,0),
	(25,'JOE','2016-06-16 15:48:23','Novena Clase','A',9.00,'Novena Clase',NULL,NULL,'https://www.dropbox.com/s/laanlghl6v0y0bv/Spring%2BSecurity%2B5-23-13%2B8.01%2BPM.mov?dl=0',115,0),
	(26,'JOE','2016-06-16 15:48:23','Spring MVC con AngularJS','A',1.00,'Spring MVC con AngularJS',NULL,NULL,'https://www.dropbox.com/s/9kfoqjt83a2ams2/springmvc4angularjs.m4v?dl=0',116,0),
	(27,'JOE','2016-06-16 15:48:23','Spring MVC COn AngularJS con JDBC','A',2.00,'Spring MVC COn AngularJS con JDBC',NULL,NULL,'https://www.dropbox.com/s/gl9v3q2uhkujgaf/springmvc4angularjswithjdbc.m4v?dl=0',116,0),
	(28,'JOE','2016-06-16 15:48:23','Cache','A',3.00,'Cache',NULL,NULL,'https://www.dropbox.com/s/5f61pqriq9se1jw/springbootcache.m4v?dl=0',116,0),
	(29,'JOE','2016-06-16 15:48:23','JMS','A',4.00,'JMS',NULL,NULL,'https://www.dropbox.com/s/h3xivnqit6yuw22/springbootconjmsforyoutube.mp4?dl=0',116,0),
	(30,'JOE','2016-06-16 15:48:23','Spring WS','A',5.00,'Spring WS',NULL,NULL,'https://www.dropbox.com/s/on0ndwsdsmhd81p/springwsboot.m4v?dl=0',116,0),
	(31,'JOE','2016-06-16 15:48:23','Spring Batch','A',6.00,'Spring Batch',NULL,NULL,'https://www.dropbox.com/sh/aaoxlrp8wxleqzs/AABVMg3Pq-rcbPFzcLG-mWkQa?dl=0',116,0),
	(32,'JOE','2016-06-16 15:48:23','Primera Clase','A',1.00,'Primera Clase',NULL,NULL,'https://www.dropbox.com/sh/4j5nosuzcirqvqz/AABPCtd14C64GTNDsQ7c9LQoa?dl=0',117,0),
	(33,'JOE','2016-06-16 15:48:23','Segunda Clase','A',2.00,'Segunda Clase',NULL,NULL,'https://www.dropbox.com/sh/zdqujah6oe4s37v/AAD1KYUQBU1nR8nsdsGyOCPXa?dl=0',117,0),
	(34,'JOE','2016-06-16 15:48:23','Tercera Clase','A',3.00,'Tercera Clase',NULL,NULL,'https://www.dropbox.com/sh/y240a6zjdz8xxsg/AAA73r7B17D7LLz6QFaukMwya?dl=0',117,0),
	(35,'JOE','2016-06-16 15:48:23','Cuarta Clase','A',4.00,'Cuarta Clase',NULL,NULL,'https://www.dropbox.com/sh/bff73oelsi9gv0z/AACSu7ufmTN2AOZdPgqVupGNa?dl=0',117,0),
	(36,'JOE','2016-06-16 15:48:23','Quinta Clase','A',5.00,'Quinta Clase',NULL,NULL,'https://www.dropbox.com/sh/5nrbc99txssgt2l/AADFUN2UNVO26x3N9Dyo0I5Ia?dl=0',117,0),
	(37,'JOE','2016-06-16 15:48:23','Sexta Clase','A',6.00,'Sexta Clase',NULL,NULL,'https://www.dropbox.com/sh/6eqjpjbmoo461zt/AADrS2rriSA_QFg-tPDDwnoba?dl=0',117,0),
	(38,'JOE','2016-06-16 15:48:23','Septima Clase','A',7.00,'Septima Clase',NULL,NULL,'https://www.dropbox.com/sh/vbq3adzkh5lqyg2/AAAnNmT0pXUbOc8q6b33Xwq3a?dl=0',117,0),
	(39,'JOE','2016-06-16 15:48:23','Octava Clase','A',8.00,'Octava Clase',NULL,NULL,'https://www.dropbox.com/sh/3akhfxodd6xn6zl/AACHQEsK_UvFQ-jioWFj0k-2a?dl=0',117,0),
	(40,'JOE','2016-06-16 15:48:23','Novena Clase','A',9.00,'Novena Clase',NULL,NULL,'https://www.dropbox.com/sh/kjafzv5zuh1ucok/AABk-gCYdfVlwNjLePlazZsMa?dl=0',117,0),
	(41,'JOE','2016-06-16 15:48:23','Decima Clase','A',10.00,'Decima Clase',NULL,NULL,'https://www.dropbox.com/sh/i98aqfplyd1bipx/AACGUvbTamhRJMYxXl9FgYcxa?dl=0',117,0),
	(42,'JOE','2016-06-16 15:48:23','Onceava Clase','A',11.00,'Onceava Clase',NULL,NULL,'https://www.dropbox.com/sh/a3sq6srtyoiympn/AACzVqrePNZFSrCi46ijiihaa?dl=0',117,0),
	(43,'JOE','2016-06-16 15:48:23','Doceava Clase','A',12.00,'Doceava Clase',NULL,NULL,'https://www.dropbox.com/sh/dbk50xt8gnnzp57/AABEQcAFp6VaOApf79er-GzPa?dl=0',117,0),
	(44,'JOE','2016-06-16 15:48:23','Treceava Clase','A',13.00,'Treceava Clase',NULL,NULL,'https://www.dropbox.com/sh/mu4ek2hcv711xy1/AAAoIft-8-z8Nqn8mtVN2jOka?dl=0',117,0),
	(45,'JOE','2016-06-16 15:48:23','Marionette JS','A',14.00,'Marionette JS',NULL,NULL,'https://www.dropbox.com/sh/yvp53wkiws4bf17/AABQ7Y8zZYe-t3HoKYw_EsjNa?dl=0',117,0),
	(46,'JOE','2016-06-16 15:48:23','Primera Clase','A',1.00,'Primera Clase',NULL,NULL,'https://www.dropbox.com/sh/tqimdqalo6pxe0v/AABOrDttkpvJMHjHK9eMFOCAa?dl=0',118,0),
	(47,'JOE','2016-06-16 15:48:23','Segunda Clase','A',2.00,'Segunda Clase',NULL,NULL,'https://www.dropbox.com/sh/kb4zzujk9ftqsvi/AADm9QPK7njySuAzBteuu1GWa?dl=0',118,0),
	(48,'JOE','2016-06-16 15:48:23','Tercera Clase','A',3.00,'Tercera Clase',NULL,NULL,'https://www.dropbox.com/sh/tjwguhcva6nv66o/AAAvNWmemDw-GEkHqDiEGd6La?dl=0',118,0),
	(49,'JOE','2016-06-16 15:48:23','Cuarta Clase','A',4.00,'Cuarta Clase',NULL,NULL,'https://www.dropbox.com/sh/u98dlpqw568rluy/AACLFVP0W-pRITLYZj_VL_67a?dl=0',118,0),
	(50,'JOE','2016-06-16 15:48:23','Quinta Clase','A',5.00,'Quinta Clase',NULL,NULL,'https://www.dropbox.com/sh/61jsbhyqedjhtbr/AAAIwft2DFXXtdqcokTY8FIIa?dl=0',118,0),
	(51,'JOE','2016-06-16 15:48:23','Sexta Clase','A',6.00,'Sexta Clase',NULL,NULL,'https://www.dropbox.com/sh/3trwoem5zkrlkg4/AADkx6WmRCYzstZ5j-75FjVUa?dl=0',118,0);

/*!40000 ALTER TABLE `temas_curso` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tipo_curso
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tipo_curso`;

CREATE TABLE `tipo_curso` (
  `tipo_curso_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `row_version` int(11) DEFAULT NULL,
  PRIMARY KEY (`tipo_curso_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tipo_curso` WRITE;
/*!40000 ALTER TABLE `tipo_curso` DISABLE KEYS */;

INSERT INTO `tipo_curso` (`tipo_curso_id`, `created_by`, `created_date`, `nombre`, `status`, `updated_by`, `updated_date`, `code`, `row_version`)
VALUES
	(5,'JOE','2016-06-15 18:07:06','ONLINE','A','JOE','2016-06-15 18:07:06','O',0),
	(6,'JOE','2016-06-15 18:07:07','PRESENCIAL','A','JOE','2016-06-15 18:07:07','P',0),
	(7,'JOE','2016-06-23 14:59:41','VIDEO CURSO','A','JOE','2016-06-23 14:59:54','V',0);

/*!40000 ALTER TABLE `tipo_curso` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  `role_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `row_version` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FKj345gk1bovqvfame88rcx7yyx` (`user_id`),
  CONSTRAINT `FK_apcc8lxk2xnug8377fatvbn04` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_it77eq964jhfqtu54081ebtio` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;

INSERT INTO `user_role` (`user_role_id`, `created_by`, `created_date`, `updated_by`, `updated_date`, `role_id`, `user_id`, `row_version`)
VALUES
	(133,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,135,0),
	(134,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,136,0),
	(135,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,137,0),
	(136,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,138,0),
	(137,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,139,0),
	(138,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,140,0),
	(139,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,141,0),
	(140,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,142,0),
	(141,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,143,0),
	(142,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,144,0),
	(143,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,145,0),
	(144,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,146,0),
	(145,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,147,0),
	(146,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,148,0),
	(147,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,149,0),
	(148,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,150,0),
	(149,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,151,0),
	(150,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,152,0),
	(151,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,153,0),
	(152,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,154,0),
	(153,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,155,0),
	(154,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,156,0),
	(155,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,157,0),
	(156,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,158,0),
	(157,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,159,0),
	(158,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,160,0),
	(159,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,161,0),
	(160,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,162,0),
	(161,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,163,0),
	(162,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,164,0),
	(163,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,165,0),
	(164,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,166,0),
	(165,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,167,0),
	(166,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,168,0),
	(167,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,169,0),
	(168,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,170,0),
	(169,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,171,0),
	(170,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,172,0),
	(171,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,173,0),
	(172,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,174,0),
	(173,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,175,0),
	(174,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,176,0),
	(175,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,177,0),
	(176,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,178,0),
	(177,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,179,0),
	(178,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,180,0),
	(179,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,181,0),
	(180,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,182,0),
	(181,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,183,0),
	(182,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,184,0),
	(183,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,185,0),
	(184,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,186,0),
	(185,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,187,0),
	(186,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,188,0),
	(187,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,189,0),
	(188,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,190,0),
	(189,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,191,0),
	(190,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,192,0),
	(191,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,193,0),
	(192,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,194,0),
	(193,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,195,0),
	(194,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,196,0),
	(195,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,197,0),
	(196,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,198,0),
	(197,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,199,0),
	(198,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,200,0),
	(199,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,201,0),
	(200,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,202,0),
	(201,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,203,0),
	(202,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,204,0),
	(203,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,205,0),
	(204,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,206,0),
	(205,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,207,0),
	(206,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,208,0),
	(207,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,209,0),
	(208,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,210,0),
	(209,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,211,0),
	(210,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,212,0),
	(211,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,213,0),
	(212,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,214,0),
	(213,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,215,0),
	(214,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,216,0),
	(215,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,217,0),
	(216,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,218,0),
	(217,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,219,0),
	(218,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,220,0),
	(219,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,221,0),
	(220,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,222,0),
	(221,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,223,0),
	(222,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,224,0),
	(223,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,225,0),
	(224,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,226,0),
	(225,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,227,0),
	(226,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,228,0),
	(227,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,229,0),
	(228,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,230,0),
	(229,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,231,0),
	(230,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,232,0),
	(231,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,233,0),
	(232,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,234,0),
	(233,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,235,0),
	(234,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,236,0),
	(235,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,237,0),
	(236,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,238,0),
	(237,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,239,0),
	(238,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,240,0),
	(239,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,241,0),
	(240,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,242,0),
	(241,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,243,0),
	(242,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,244,0),
	(243,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,245,0),
	(244,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,246,0),
	(245,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,247,0),
	(246,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,248,0),
	(247,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,249,0),
	(248,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,250,0),
	(249,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,251,0),
	(250,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,252,0),
	(251,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,253,0),
	(252,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,254,0),
	(253,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,255,0),
	(254,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,256,0),
	(255,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,257,0),
	(256,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,258,0),
	(257,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,259,0),
	(258,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,260,0),
	(259,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,261,0),
	(260,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,262,0),
	(261,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,263,0),
	(262,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,264,0),
	(263,'CELTIC','2016-06-15','CELTIC','2016-06-15',5,265,0);

/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `row_version` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`user_id`, `created_by`, `created_date`, `email`, `first_name`, `last_name`, `password`, `status`, `title`, `updated_by`, `updated_date`, `user_name`, `row_version`)
VALUES
	(135,'CELTIC','2016-06-15 17:52:08','jose.diaz@joedayz.pe','Jose','Diaz Diaz','joedayz','A','-','cron-usr','2016-10-29 13:01:48','joe',2),
	(136,'CELTIC','2016-06-15 17:52:08','rpcesar@sysarp.com','Cesar ','Rubio Padilla','123','A','-','CELTIC','2016-06-15 17:52:08','rpcesar',0),
	(137,'CELTIC','2016-06-15 17:52:08','tinto.volk22@gmail.com','Ernesto Martin ','Torres García','123','A','-','CELTIC','2016-06-15 17:52:08','tinto.volk22',0),
	(138,'CELTIC','2016-06-15 17:52:08','ivancondori1@gmail.com','Ivan ','Condori','123','A','-','CELTIC','2016-06-15 17:52:08','ivancondori1',0),
	(139,'CELTIC','2016-06-15 17:52:08','arnoldchura@gmail.com','Arnold ','Chura','123','A','-','CELTIC','2016-06-15 17:52:08','arnoldchura',0),
	(140,'CELTIC','2016-06-15 17:52:09','tanquise@clinicaamericana.org.pe','Tanquise','','123','A','-','CELTIC','2016-06-15 17:52:09','tanquise',0),
	(141,'CELTIC','2016-06-15 17:52:09','jeremycaceres@gmail.com','Jeremy ','Caceres','123','A','-','CELTIC','2016-06-15 17:52:09','jeremycaceres',0),
	(142,'CELTIC','2016-06-15 17:52:09','fernandezherrera345@gmail.com','Carlos ','Fernandez Herrera','123','A','-','CELTIC','2016-06-15 17:52:09','fernandezherrera345',0),
	(143,'CELTIC','2016-06-15 17:52:09','jesus.choq@gmail.com','Jesus ','Choque','123','A','-','CELTIC','2016-06-15 17:52:09','jesus.choq',0),
	(144,'CELTIC','2016-06-15 17:52:09','homar.del.alva@gmail.com','Homar ','del alva','123','A','-','CELTIC','2016-06-15 17:52:09','homar.del.alva',0),
	(145,'CELTIC','2016-06-15 17:52:09','jllougon@gmail.com','Jose Luis',' Lougon','123','A','-','CELTIC','2016-06-15 17:52:09','jllougon',0),
	(146,'CELTIC','2016-06-15 17:52:09','jvarela6@gmail.com','Jesus ','Mendoza','123','A','-','CELTIC','2016-06-15 17:52:09','jvarela6',0),
	(147,'CELTIC','2016-06-15 17:52:09','kenyica13@gmail.com','KENYI',' CANCHIHUAMAN ANGO','123','A','-','CELTIC','2016-06-15 17:52:09','kenyica13',0),
	(148,'CELTIC','2016-06-15 17:52:09','rafael_mg@outlook.com','Rafael',' Michuy Gutierrez','123','A','-','CELTIC','2016-06-15 17:52:09','rafael_mg',0),
	(149,'CELTIC','2016-06-15 17:52:09','fcamabeltran@gmail.com','Felix ','Cama Beltran','123','A','-','CELTIC','2016-06-15 17:52:09','fcamabeltran',0),
	(150,'CELTIC','2016-06-15 17:52:09','omarinccjcc@hotmail.com','Omar ','Calsin','123','A','-','CELTIC','2016-06-15 17:52:09','omarinccjcc',0),
	(151,'CELTIC','2016-06-15 17:52:09','javier.floresr31@gmail.com','Javier Felipe ','Flores Ramos','123','A','-','CELTIC','2016-06-15 17:52:09','javier.floresr31',0),
	(152,'CELTIC','2016-06-15 17:52:09','rokefeler@gmail.com','José ','Roque','123','A','-','CELTIC','2016-06-15 17:52:09','rokefeler',0),
	(153,'CELTIC','2016-06-15 17:52:09','harbarnard@ichikawagroup.com','Harold',' Chumbe','123','A','-','CELTIC','2016-06-15 17:52:09','harbarnard',0),
	(154,'CELTIC','2016-06-15 17:52:09','miguel.amaya99@gmail.com','Jose Miguel',' Amaya Camacho','123','A','-','CELTIC','2016-06-15 17:52:09','miguel.amaya99',0),
	(155,'CELTIC','2016-06-15 17:52:09','edivasrom@hotmail.com','Edinson Josue ','Vásquez','123','A','-','CELTIC','2016-06-15 17:52:09','edivasrom',0),
	(156,'CELTIC','2016-06-15 17:52:09','joozve20@gmail.com','Josue',' Daniel','123','A','-','CELTIC','2016-06-15 17:52:09','joozve20',0),
	(157,'CELTIC','2016-06-15 17:52:09','rollerfernandez@gmail.com','Roller',' Fernandez','123','A','-','CELTIC','2016-06-15 17:52:09','rollerfernandez',0),
	(158,'CELTIC','2016-06-15 17:52:09','jhontaison@gmail.com','JOHN',' ORTIZ RODRIGUEZ','123','A','-','CELTIC','2016-06-15 17:52:09','jhontaison',0),
	(159,'CELTIC','2016-06-15 17:52:09','jordantorresv@gmail.com','Jordan','','123','A','-','CELTIC','2016-06-15 17:52:09','jordantorresv',0),
	(160,'CELTIC','2016-06-15 17:52:09','czearz@gmail.com','Cesar',' Pastor Nuñez','123','A','-','CELTIC','2016-06-15 17:52:09','czearz',0),
	(161,'CELTIC','2016-06-15 17:52:09','macgyverbarrientos@gmail.com','macgyver ','barrientos','123','A','-','CELTIC','2016-06-15 17:52:09','macgyverbarrientos',0),
	(162,'CELTIC','2016-06-15 17:52:09','ahenryjs@gmail.com','Henry',' Jimenez Sanchez','123','A','-','CELTIC','2016-06-15 17:52:09','ahenryjs',0),
	(163,'CELTIC','2016-06-15 17:52:09','sagittaiire@hotmail.com','Abel ','Sánchez Cabrera','123','A','-','CELTIC','2016-06-15 17:52:09','sagittaiire',0),
	(164,'CELTIC','2016-06-15 17:52:09','montesinos2005ii@gmail.com','Juan Carlos ','Ludeña Montesinos','123','A','-','CELTIC','2016-06-15 17:52:09','montesinos2005ii',0),
	(165,'CELTIC','2016-06-15 17:52:09','fernando.zegarrag@hotmail.com','Fernando ','Zegarra','123','A','-','CELTIC','2016-06-15 17:52:09','fernando.zegarrag',0),
	(166,'CELTIC','2016-06-15 17:52:09','mijail.rivera@gmail.com','OMAR MIJAIL ','RIVERA MENDOZA.','123','A','-','CELTIC','2016-06-15 17:52:09','mijail.rivera',0),
	(167,'CELTIC','2016-06-15 17:52:09','juan_q_0611@hotmail.com','Juan Jesús ','Quispe Odar','123','A','-','CELTIC','2016-06-15 17:52:09','juan_q_0611',0),
	(168,'CELTIC','2016-06-15 17:52:09','jdavid_2014@hotmail.com','David ','Condori','123','A','-','CELTIC','2016-06-15 17:52:09','jdavid_2014',0),
	(169,'CELTIC','2016-06-15 17:52:09','marcox99@gmail.com','Marco ','lopez','123','A','-','CELTIC','2016-06-15 17:52:09','marcox99',0),
	(170,'CELTIC','2016-06-15 17:52:09','mazodirty@hotmail.com','Joan Andres ','Muñoz','123','A','-','CELTIC','2016-06-15 17:52:09','mazodirty',0),
	(171,'CELTIC','2016-06-15 17:52:09','dences@gmail.com','Dennis ','Cerruche','123','A','-','CELTIC','2016-06-15 17:52:09','dences',0),
	(172,'CELTIC','2016-06-15 17:52:09','dario.q@outlook.com','DARIO WILLY','QQUECHO QUISPE ','123','A','-','CELTIC','2016-06-15 17:52:09','dario.q',0),
	(173,'CELTIC','2016-06-15 17:52:09','jpier_one@hotmail.com','Jeampierre','','123','A','-','CELTIC','2016-06-15 17:52:09','jpier_one',0),
	(174,'CELTIC','2016-06-15 17:52:09','armando17@gmail.com','Armando Turpo ','Zevallos Vasquez','123','A','-','CELTIC','2016-06-15 17:52:09','armando17',0),
	(175,'CELTIC','2016-06-15 17:52:09','cerm1981@hotmail.com','Carlos ','Rodriguez','123','A','-','CELTIC','2016-06-15 17:52:09','cerm1981',0),
	(176,'CELTIC','2016-06-15 17:52:09','felixgato8@gmail.com','Felix Alberto ','Laura Antezana','123','A','-','CELTIC','2016-06-15 17:52:09','felixgato8',0),
	(177,'CELTIC','2016-06-15 17:52:09','jhosep.dario@gmail.com','Jhosep Dario ','Luna Diaz','123','A','-','CELTIC','2016-06-15 17:52:09','jhosep.dario',0),
	(178,'CELTIC','2016-06-15 17:52:09','gonzalezesjuan@gmail.com','Juan ','Gonzales','123','A','-','CELTIC','2016-06-15 17:52:09','gonzalezesjuan',0),
	(179,'CELTIC','2016-06-15 17:52:09','javier.venero@gmail.com','Javier ','Venero','123','A','-','CELTIC','2016-06-15 17:52:09','javier.venero',0),
	(180,'CELTIC','2016-06-15 17:52:09','ricc7.peche@gmail.com','Ricardo Jesus ','Herrera López','123','A','-','CELTIC','2016-06-15 17:52:09','ricc7.peche',0),
	(181,'CELTIC','2016-06-15 17:52:09','leonardo.dcbv@gmail.com','Leonardo Miguel ','Del Carpio Bellido Vargas','123','A','-','CELTIC','2016-06-15 17:52:09','leonardo.dcbv',0),
	(182,'CELTIC','2016-06-15 17:52:09','luizkawai7@gmail.com','Luiz Augusto ','Kawai Kohatsu','123','A','-','CELTIC','2016-06-15 17:52:09','luizkawai7',0),
	(183,'CELTIC','2016-06-15 17:52:09','bryansoft21@gmail.com','Bryan',' Avila Jjara','123','A','-','CELTIC','2016-06-15 17:52:09','bryansoft21',0),
	(184,'CELTIC','2016-06-15 17:52:09','liz1593@gmail.com','eugenia isabela ','perez isidro','123','A','-','CELTIC','2016-06-15 17:52:09','liz1593',0),
	(185,'CELTIC','2016-06-15 17:52:09','jelusita@hotmail.com','Jenny Lucia ','Vega Guerrero','123','A','-','CELTIC','2016-06-15 17:52:09','jelusita',0),
	(186,'CELTIC','2016-06-15 17:52:09','llargiec@hotmail.com','Jean Carlos',' Ramos Cruz','123','A','-','CELTIC','2016-06-15 17:52:09','llargiec',0),
	(187,'CELTIC','2016-06-15 17:52:09','jvasqueze33@gmail.com','Wilfredo Junior ','Vásquez Eslava','123','A','-','CELTIC','2016-06-15 17:52:09','jvasqueze33',0),
	(188,'CELTIC','2016-06-15 17:52:09','cvelezdevi@gmail.com','César Augusto ','Vélez de Villa Domínguez','123','A','-','CELTIC','2016-06-15 17:52:09','cvelezdevi',0),
	(189,'CELTIC','2016-06-15 17:52:09','munilvc@gmail.com','Luis Felipe',' Vega Calle','123','A','-','CELTIC','2016-06-15 17:52:09','munilvc',0),
	(190,'CELTIC','2016-06-15 17:52:09','franciscocastillochinchay@gmail.com','Francisco ','Castillo','123','A','-','CELTIC','2016-06-15 17:52:09','franciscocastillochinchay',0),
	(191,'CELTIC','2016-06-15 17:52:09','agtespecialista@gmail.com','Antonio ','Gonzales Toledo','123','A','-','CELTIC','2016-06-15 17:52:09','agtespecialista',0),
	(192,'CELTIC','2016-06-15 17:52:09','carlossing@gmail.com','Carlos Miguel ','Sing Ramos','123','A','-','CELTIC','2016-06-15 17:52:09','carlossing',0),
	(193,'CELTIC','2016-06-15 17:52:09','martinvera@gmail.com','Martin ','Vera','123','A','-','CELTIC','2016-06-15 17:52:09','martinvera',0),
	(194,'CELTIC','2016-06-15 17:52:09','maliaga.pantoja@gmail.com','Miguel ','Aliaga Pantoja','123','A','-','CELTIC','2016-06-15 17:52:09','maliaga.pantoja',0),
	(195,'CELTIC','2016-06-15 17:52:09','dcaguilar7@gmail.com','David ','Aguilar','123','A','-','CELTIC','2016-06-15 17:52:09','dcaguilar7',0),
	(196,'CELTIC','2016-06-15 17:52:09','tuxedo.root@gmail.com','Jhonson ','Rabelo','123','A','-','CELTIC','2016-06-15 17:52:09','tuxedo.root',0),
	(197,'CELTIC','2016-06-15 17:52:09','fgonifacundo.12@gmail.com','Flavio Cesar ','Goñi Facundo','123','A','-','CELTIC','2016-06-15 17:52:09','fgonifacundo.12',0),
	(198,'CELTIC','2016-06-15 17:52:09','carloslds33@gmail.com','Carlos Enrique ','Castro Aguirre','123','A','-','CELTIC','2016-06-15 17:52:09','carloslds33',0),
	(199,'CELTIC','2016-06-15 17:52:09','eaguirre378@gmail.com','EdyLuis ','Aguirre','123','A','-','CELTIC','2016-06-15 17:52:09','eaguirre378',0),
	(200,'CELTIC','2016-06-15 17:52:09','alexnaupay@gmail.com','Alex ','Naupay','123','A','-','CELTIC','2016-06-15 17:52:09','alexnaupay',0),
	(201,'CELTIC','2016-06-15 17:52:09','juan.damian.odar@gmail.com','Juan Damian ','Odar','123','A','-','CELTIC','2016-06-15 17:52:09','juan.damian.odar',0),
	(202,'CELTIC','2016-06-15 17:52:09','jchcamareno@gmail.com','Juan Carlos ','Camareno Huamán','123','A','-','CELTIC','2016-06-15 17:52:09','jchcamareno',0),
	(203,'CELTIC','2016-06-15 17:52:09','jnicmez12@gmail.com','José ','Nicasio','123','A','-','CELTIC','2016-06-15 17:52:09','jnicmez12',0),
	(204,'CELTIC','2016-06-15 17:52:09','vladimir_sc@hotmail.com','Vladimir ','SC','123','A','-','CELTIC','2016-06-15 17:52:09','vladimir_sc',0),
	(205,'CELTIC','2016-06-15 17:52:09','joselounmsm2012@gmail.com','Jose Alfredo',' Taquila Domingo','123','A','-','CELTIC','2016-06-15 17:52:09','joselounmsm2012',0),
	(206,'CELTIC','2016-06-15 17:52:09','mvpfrans@gmail.com','Pedro ','Mayta','123','A','-','CELTIC','2016-06-15 17:52:09','mvpfrans',0),
	(207,'CELTIC','2016-06-15 17:52:09','guidosjulca@gmail.com','Guido ','Sarmiento','123','A','-','CELTIC','2016-06-15 17:52:09','guidosjulca',0),
	(208,'CELTIC','2016-06-15 17:52:09','carrasco_alan@yahoo.es','Alan ','Carrasco','123','A','-','CELTIC','2016-06-15 17:52:09','carrasco_alan',0),
	(209,'CELTIC','2016-06-15 17:52:09','hl_businessolutions@hotmail.com','Hector','','123','A','-','CELTIC','2016-06-15 17:52:09','hl_businessolutions',0),
	(210,'CELTIC','2016-06-15 17:52:09','hmorandini@altec.com.ar','Hernan ','Morandini','123','A','-','CELTIC','2016-06-15 17:52:09','hmorandini',0),
	(211,'CELTIC','2016-06-15 17:52:09','clodoaldosanchez@gmail.com','Clodoaldo ','Sanchez Paredes','123','A','-','CELTIC','2016-06-15 17:52:09','clodoaldosanchez',0),
	(212,'CELTIC','2016-06-15 17:52:09','sergio19906@gmail.com','Sergio Alejandro',' Servín Arce','123','A','-','CELTIC','2016-06-15 17:52:09','sergio19906',0),
	(213,'CELTIC','2016-06-15 17:52:09','juan.calixto.salazar@gmail.com','Juan ','Calixto Salazar','123','A','-','CELTIC','2016-06-15 17:52:09','juan.calixto.salazar',0),
	(214,'CELTIC','2016-06-15 17:52:09','jtejadavilca@gmail.com','Jose ','Tejada Vilca','123','A','-','CELTIC','2016-06-15 17:52:09','jtejadavilca',0),
	(215,'CELTIC','2016-06-15 17:52:09','guidomgm@gmail.com','Guido Maycol ','Gutierrez Miranda','123','A','-','CELTIC','2016-06-15 17:52:09','guidomgm',0),
	(216,'CELTIC','2016-06-15 17:52:09','eloarte@gmail.com','Erick ','Loarte Benites','123','A','-','CELTIC','2016-06-15 17:52:09','eloarte',0),
	(217,'CELTIC','2016-06-15 17:52:09','jlam2001@hotmail.com','Jose ','Alpiste Marres','123','A','-','CELTIC','2016-06-15 17:52:09','jlam2001',0),
	(218,'CELTIC','2016-06-15 17:52:09','ruben.yllanes@gmail.com','Ruben ','Yllanes','123','A','-','CELTIC','2016-06-15 17:52:09','ruben.yllanes',0),
	(219,'CELTIC','2016-06-15 17:52:09','ing.arellano@gmail.com','Luis ','Arellano','123','A','-','CELTIC','2016-06-15 17:52:09','ing.arellano',0),
	(220,'CELTIC','2016-06-15 17:52:09','enic.isordia@hotmail.com','Enic ','isordia cuevas','123','A','-','CELTIC','2016-06-15 17:52:09','enic.isordia',0),
	(221,'CELTIC','2016-06-15 17:52:09','09200160@unmsm.edu.pe','Jorge Luis ','Tello Gamarra','123','A','-','CELTIC','2016-06-15 17:52:09','09200160',0),
	(222,'CELTIC','2016-06-15 17:52:09','vasquezfisi95@gmail.com','Fisi ','vasquez','123','A','-','CELTIC','2016-06-15 17:52:09','vasquezfisi95',0),
	(223,'CELTIC','2016-06-15 17:52:09','ana_quim@hotmail.com','Anatoli ','Quimper','123','A','-','CELTIC','2016-06-15 17:52:09','ana_quim',0),
	(224,'CELTIC','2016-06-15 17:52:09','quimper.mk@gmail.com','Milko',' Quimper','123','A','-','CELTIC','2016-06-15 17:52:09','quimper.mk',0),
	(225,'CELTIC','2016-06-15 17:52:09','decc90@gmail.com','Diego Eduardo ','Cardenas','123','A','-','CELTIC','2016-06-15 17:52:09','decc90',0),
	(226,'CELTIC','2016-06-15 17:52:09','Dany_16b@hotmail.com','Juan',' murga zegarra','123','A','-','CELTIC','2016-06-15 17:52:09','Dany_16b',0),
	(227,'CELTIC','2016-06-15 17:52:09','angel.garcia.biz@gmail.com','Angel ','Garcia Alcantara','123','A','-','CELTIC','2016-06-15 17:52:09','angel.garcia.biz',0),
	(228,'CELTIC','2016-06-15 17:52:09','bonfersen@gmail.com','Luis ','Bustamente','123','A','-','CELTIC','2016-06-15 17:52:09','bonfersen',0),
	(229,'CELTIC','2016-06-15 17:52:09','juligrva@hotmail.com','JULIAN ANDRES ','GRANADA VASQUEZ','123','A','-','CELTIC','2016-06-15 17:52:09','juligrva',0),
	(230,'CELTIC','2016-06-15 17:52:09','edwinnavarroprado@gmail.com','Edwin ','Navarro','123','A','-','CELTIC','2016-06-15 17:52:09','edwinnavarroprado',0),
	(231,'CELTIC','2016-06-15 17:52:09','santiagochris92@gmail.com','Chris ','Santiago','123','A','-','CELTIC','2016-06-15 17:52:09','santiagochris92',0),
	(232,'CELTIC','2016-06-15 17:52:09','alexfercal@gmail.com','Alex ','Fernandez','123','A','-','CELTIC','2016-06-15 17:52:09','alexfercal',0),
	(233,'CELTIC','2016-06-15 17:52:09','edwinalexander2026@hotmail.com','Edwin ','Cotrina','123','A','-','CELTIC','2016-06-15 17:52:09','edwinalexander2026',0),
	(234,'CELTIC','2016-06-15 17:52:09','jastoja@gmail.com','Jose ','Asto','123','A','-','CELTIC','2016-06-15 17:52:09','jastoja',0),
	(235,'CELTIC','2016-06-15 17:52:09','arturo.jesus.galvez@gmail.com','Arturo Jesus  ','Galvez','123','A','-','CELTIC','2016-06-15 17:52:09','arturo.jesus.galvez',0),
	(236,'CELTIC','2016-06-15 17:52:09','larh0510@gmail.com','Luis ','Rosales Huertas','123','A','-','CELTIC','2016-06-15 17:52:09','larh0510',0),
	(237,'CELTIC','2016-06-15 17:52:09','hmendo81@gmail.com','Henry ','Mendoza Puerta','123','A','-','CELTIC','2016-06-15 17:52:09','hmendo81',0),
	(238,'CELTIC','2016-06-15 17:52:09','diego.esgu@gmail.com','Diego ','Gutierrez','123','A','-','CELTIC','2016-06-15 17:52:09','diego.esgu',0),
	(239,'CELTIC','2016-06-15 17:52:09','lucaspesa@hotmail.com','Lucas ','Perdomo Sanchez','123','A','-','CELTIC','2016-06-15 17:52:09','lucaspesa',0),
	(240,'CELTIC','2016-06-15 17:52:09','ricardomon85@gmail.com','Ricardo ','Roman','123','A','-','CELTIC','2016-06-15 17:52:09','ricardomon85',0),
	(241,'CELTIC','2016-06-15 17:52:09','CARLOSMAMANI1993@GMAIL.COM','CARLOS VICTOR ','MAMANI GUEVARA','123','A','-','CELTIC','2016-06-15 17:52:09','CARLOSMAMANI1993',0),
	(242,'CELTIC','2016-06-15 17:52:09','glisselisbeth@gmail.com','Glisse Lisbeth.',' JORGE MALCA','123','A','-','CELTIC','2016-06-15 17:52:09','glisselisbeth',0),
	(243,'CELTIC','2016-06-15 17:52:09','jorgecarmonal@hotmail.com','Jorge ','Carmona','123','A','-','CELTIC','2016-06-15 17:52:09','jorgecarmonal',0),
	(244,'CELTIC','2016-06-15 17:52:09','jpizarro83@hotmail.com','Joseph ','Pizarro Carmona','123','A','-','CELTIC','2016-06-15 17:52:09','jpizarro83',0),
	(245,'CELTIC','2016-06-15 17:52:09','eriosmurrugarra@gmail.com','Erikson ','Murrugarra','123','A','-','CELTIC','2016-06-15 17:52:09','eriosmurrugarra',0),
	(246,'CELTIC','2016-06-15 17:52:09','luisangel511@gmail.com','Luis ','Castillo','123','A','-','CELTIC','2016-06-15 17:52:09','luisangel511',0),
	(247,'CELTIC','2016-06-15 17:52:09','atlas.aresco@gmail.com','Ciro',' R. V.','123','A','-','CELTIC','2016-06-15 17:52:09','atlas.aresco',0),
	(248,'CELTIC','2016-06-15 17:52:09','litojose@gmail.com','José',' Granados Mendoza','123','A','-','CELTIC','2016-06-15 17:52:09','litojose',0),
	(249,'CELTIC','2016-06-15 17:52:09','oscarqpe@gmail.com','Oscar ','quispe','123','A','-','CELTIC','2016-06-15 17:52:09','oscarqpe',0),
	(250,'CELTIC','2016-06-15 17:52:09','mallquilm@gmail.com','Luis ','Mallqui','123','A','-','CELTIC','2016-06-15 17:52:09','mallquilm',0),
	(251,'CELTIC','2016-06-15 17:52:09','nrafael1@gmail.com','Nestor ','Audante','123','A','-','CELTIC','2016-06-15 17:52:09','nrafael1',0),
	(252,'CELTIC','2016-06-15 17:52:09','diegogcampana@hotmail.com','Diego ','Gomez Campana','123','A','-','CELTIC','2016-06-15 17:52:09','diegogcampana',0),
	(253,'CELTIC','2016-06-15 17:52:09','b_raggio@hotmail.com','Bruno ','Alva Raggio','123','A','-','CELTIC','2016-06-15 17:52:09','b_raggio',0),
	(254,'CELTIC','2016-06-15 17:52:09','jeanpaulct@gmail.com','Jean Paul ','Curiñaupa Taype','123','A','-','CELTIC','2016-06-15 17:52:09','jeanpaulct',0),
	(255,'CELTIC','2016-06-15 17:52:09','cmunguiam@gmail.com','Cristhian Alberto ','Munguia Martinez','123','A','-','CELTIC','2016-06-15 17:52:09','cmunguiam',0),
	(256,'CELTIC','2016-06-15 17:52:09','Flashperuvian1@gmail.com','Anthony ','rojas','123','A','-','CELTIC','2016-06-15 17:52:09','Flashperuvian1',0),
	(257,'CELTIC','2016-06-15 17:52:09','rochoac@gmail.com','Roman ','Ochoa','123','A','-','CELTIC','2016-06-15 17:52:09','rochoac',0),
	(258,'CELTIC','2016-06-15 17:52:09','danielqv.120@gmail.com','Daniel ','Quiroz','123','A','-','CELTIC','2016-06-15 17:52:09','danielqv.120',0),
	(259,'CELTIC','2016-06-15 17:52:09','jolr841@hotmail.com','Juan ','Lopez','123','A','-','CELTIC','2016-06-15 17:52:09','jolr841',0),
	(260,'CELTIC','2016-06-15 17:52:09','alanlopezgutierrez@gmail.com','Alan ','Lopez','123','A','-','CELTIC','2016-06-15 17:52:09','alanlopezgutierrez',0),
	(261,'CELTIC','2016-06-15 17:52:09','juancarlosbucio@gmail.com','Juan Carlos',' Bucio','123','A','-','CELTIC','2016-06-15 17:52:09','juancarlosbucio',0),
	(262,'CELTIC','2016-06-15 17:52:09','lsupoo@gmail.com','Luis Alberto',' Supoo Orihuela','123','A','-','CELTIC','2016-06-15 17:52:09','lsupoo',0),
	(263,'CELTIC','2016-06-15 17:52:09','aldojl28@hotmail.com','Aldo ','Yoel','123','A','-','CELTIC','2016-06-15 17:52:09','aldojl28',0),
	(264,'CELTIC','2016-06-15 17:52:09','strato_vic_14@hotmail.com','Victor Hugo',' Trujillo Charalla','123','A','-','CELTIC','2016-06-15 17:52:09','strato_vic_14',0),
	(265,'CELTIC','2016-06-15 17:52:09','ideatsoft@gmail.com','Freddy ','Caballero','123','A','-','CELTIC','2016-06-15 17:52:09','ideatsoft',0);

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
