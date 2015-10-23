/*
SQLyog Community v12.09 (64 bit)
MySQL - 5.6.17 : Database - hashfon
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hashfon` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hashfon`;

/*Table structure for table `hash` */

DROP TABLE IF EXISTS `hash`;

CREATE TABLE `hash` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag` varchar(100) COLLATE utf8_croatian_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

/*Data for the table `hash` */

insert  into `hash`(`id`,`tag`) values (1,'bubble'),(2,'json'),(3,'insertion');

/*Table structure for table `hr` */

DROP TABLE IF EXISTS `hr`;

CREATE TABLE `hr` (
  `id_kompanije` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `ime` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `prezime` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `token` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL,
  PRIMARY KEY (`id_kompanije`,`id`),
  KEY `id` (`id`),
  CONSTRAINT `hr_ibfk_1` FOREIGN KEY (`id_kompanije`) REFERENCES `kompanija` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

/*Data for the table `hr` */

insert  into `hr`(`id_kompanije`,`id`,`email`,`password`,`ime`,`prezime`,`token`) values (2,1,'ivana.banovic@htec.rs','bleja','Ivana','Banovic','TOKEN##KOMPANIJA##1');

/*Table structure for table `kompanija` */

DROP TABLE IF EXISTS `kompanija`;

CREATE TABLE `kompanija` (
  `Ime` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `Opis` text COLLATE utf8_croatian_ci NOT NULL,
  `Slika` varchar(10000) COLLATE utf8_croatian_ci DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL,
  `adresa` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

/*Data for the table `kompanija` */

insert  into `kompanija`(`Ime`,`Opis`,`Slika`,`id`,`email`,`adresa`) values ('HTEC','Mare je najjaci!',NULL,2,'h@h.com','biga 9'),('BAL','Raca je car!',NULL,3,'b@bal.com','camuraja 13');

/*Table structure for table `oglas_kompanije` */

DROP TABLE IF EXISTS `oglas_kompanije`;

CREATE TABLE `oglas_kompanije` (
  `id_kompanije` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `oglas` text COLLATE utf8_croatian_ci NOT NULL,
  `naziv` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  PRIMARY KEY (`id_kompanije`,`id`),
  KEY `id` (`id`),
  CONSTRAINT `oglas_kompanije_ibfk_1` FOREIGN KEY (`id_kompanije`) REFERENCES `kompanija` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

/*Data for the table `oglas_kompanije` */

insert  into `oglas_kompanije`(`id_kompanije`,`id`,`oglas`,`naziv`) values (2,2,'Mare kralj!!!!!!!!!!','Bleja'),(2,48,'123123123','Oglas 11'),(2,50,'getlucky','Oglas'),(3,4,'ogi ads','Smor'),(3,46,'asdasddssdadsadasdas','Sto');

/*Table structure for table `snipet` */

DROP TABLE IF EXISTS `snipet`;

CREATE TABLE `snipet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` text COLLATE utf8_croatian_ci NOT NULL,
  `id_hash` bigint(20) NOT NULL,
  `id_student` bigint(20) NOT NULL,
  PRIMARY KEY (`id`,`id_student`),
  KEY `id_hash` (`id_hash`),
  KEY `id_student` (`id_student`),
  CONSTRAINT `snipet_ibfk_1` FOREIGN KEY (`id_hash`) REFERENCES `hash` (`id`),
  CONSTRAINT `snipet_ibfk_2` FOREIGN KEY (`id_student`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

/*Data for the table `snipet` */

insert  into `snipet`(`id`,`code`,`id_hash`,`id_student`) values (3,'public static void BubbleSort( int [ ] num )\r\n{\r\n     int j;\r\n     boolean flag = true;   // set flag to true to begin first pass\r\n     int temp;   //holding variable\r\n\r\n     while ( flag )\r\n     {\r\n            flag= false;    //set flag to false awaiting a possible swap\r\n            for( j=0;  j < num.length -1;  j++ )\r\n            {\r\n                   if ( num[ j ] < num[j+1] )   // change to > for ascending sort\r\n                   {\r\n                           temp = num[ j ];                //swap elements\r\n                           num[ j ] = num[ j+1 ];\r\n                           num[ j+1 ] = temp;\r\n                          flag = true;              //shows a swap occurred  \r\n                  } \r\n            } \r\n      } \r\n} ',1,1),(4,'djon',1,1),(5,'marko\\nkralj\\nbleja',1,1),(6,'adspkopdoskaasdkopopdsak{\nSDAPLSD{}\n',1,2),(7,'marko\nkralj',1,1);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `prezime` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `telefon` varchar(100) COLLATE utf8_croatian_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `slika` varchar(10000) COLLATE utf8_croatian_ci DEFAULT NULL,
  `adresa` varchar(255) COLLATE utf8_croatian_ci NOT NULL,
  `datum_rodjenja` date NOT NULL,
  `dodatne_informacije` varchar(10000) COLLATE utf8_croatian_ci DEFAULT NULL,
  `token` varchar(255) COLLATE utf8_croatian_ci DEFAULT NULL,
  `godina_diplomiranja` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_croatian_ci;

/*Data for the table `student` */

insert  into `student`(`id`,`ime`,`prezime`,`password`,`telefon`,`email`,`slika`,`adresa`,`datum_rodjenja`,`dodatne_informacije`,`token`,`godina_diplomiranja`) values (1,'Marko','Barackov','mikimaus','888','mdbarackov@gmail.com',' ','Vojvode Stepe 212/16','1992-08-10','Kraljina!',NULL,2015),(2,'Ivan','Aracki','asd','123321213','ivan.aracki@gmail.com',' ','asddsa','1992-12-30','asd',NULL,2020),(3,'Lazar','Blanusa','mikimaus','','lazar_92@live.com','','Vojvode Stepe 212/16','1992-09-03','Kraljina!',NULL,2018),(4,'','','','','',NULL,'','0000-00-00',NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
