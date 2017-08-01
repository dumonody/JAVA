/*
SQLyog v10.2 
MySQL - 5.5.49 : Database - bookdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookdb`;

/*Table structure for table `books` */

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `id` int(11) DEFAULT NULL,
  `bookid` int(11) DEFAULT NULL,
  `bookname` varchar(180) DEFAULT NULL,
  `author` varchar(180) DEFAULT NULL,
  `chubanshe` varchar(180) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `amount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `books` */

insert  into `books`(`id`,`bookid`,`bookname`,`author`,`chubanshe`,`date`,`amount`) values (5,15,'那啥','duyanhan','人民出版社','2017-07-26',12),(2,20,'英雄联盟','duyanhan','人民出版社','2017-07-26',12),(3,25,'英雄联盟','hehe','江西出版社','2017-07-13',15);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
