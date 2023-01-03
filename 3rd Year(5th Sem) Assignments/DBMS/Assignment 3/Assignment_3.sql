-- phpMiniAdmin dump 1.9.170730
-- Datetime: 2022-08-25 11:38:09
-- Host: 
-- Database: indranilb

/*!40030 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

DROP TABLE IF EXISTS `BOATS`;
CREATE TABLE `BOATS` (
  `B_id` int(4) NOT NULL,
  `B_name` varchar(20) DEFAULT NULL,
  `colours` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`B_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `BOATS` DISABLE KEYS */;
INSERT INTO `BOATS` VALUES ('8','Indranil','Pink'),('9','Alex','green'),('10','Smith','yellow'),('11','Franklin','violet'),('12','Ana','blue'),('13','Indranil','orange'),('14','Astik','grey'),('15','Arnold','Red');
/*!40000 ALTER TABLE `BOATS` ENABLE KEYS */;

DROP TABLE IF EXISTS `RESERVES`;
CREATE TABLE `RESERVES` (
  `s_id` int(4) NOT NULL,
  `b_id` int(8) DEFAULT NULL,
  `day` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `RESERVES` DISABLE KEYS */;
INSERT INTO `RESERVES` VALUES ('1','8','Sunday'),('2','9','Monday'),('3','10','Tuesday'),('4','11','Wednesday'),('5','12','Thursday'),('6','13','Friday'),('7','14','Saturday'),('8','15','Sunday');
/*!40000 ALTER TABLE `RESERVES` ENABLE KEYS */;

DROP TABLE IF EXISTS `SAILORS`;
CREATE TABLE `SAILORS` (
  `s_id` int(4) NOT NULL,
  `s_name` varchar(8) DEFAULT NULL,
  `rating` int(5) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `SAILORS` DISABLE KEYS */;
INSERT INTO `SAILORS` VALUES ('1','Indranil','5','33'),('2','Alex','7','21'),('3','Smith','9','22'),('4','Franklin','8','25'),('5','Ana','6','24'),('6','Indranil','9','25'),('7','Astik','7','22'),('8','Arnold','7','69');
/*!40000 ALTER TABLE `SAILORS` ENABLE KEYS */;

DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student` (
  `RollNo` int(11) NOT NULL,
  `Sname` varchar(20) DEFAULT NULL,
  `City` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`RollNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES ('1','Indranil','Kolkata'),('2','Astik','Punjab'),('3','Sriporno','Karnataka'),('4','Arghya','Delhi'),('5','Sourit','Mumbai');
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;

DROP TABLE IF EXISTS `Subject`;
CREATE TABLE `Subject` (
  `Subno` int(11) NOT NULL,
  `SubTitle` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Subno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `Subject` DISABLE KEYS */;
INSERT INTO `Subject` VALUES ('6','RDBMS'),('7','System Design'),('8','Mechanics'),('9','Networks'),('10','Math');
/*!40000 ALTER TABLE `Subject` ENABLE KEYS */;

DROP TABLE IF EXISTS `TEACHER`;
CREATE TABLE `TEACHER` (
  `Tid` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `Dept` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Tid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `TEACHER` DISABLE KEYS */;
INSERT INTO `TEACHER` VALUES ('1','Malcom','CST'),('2','Jack','IT'),('3','Kendrick','EE'),('4','Drake','ETC'),('5','Travis','CE');
/*!40000 ALTER TABLE `TEACHER` ENABLE KEYS */;

DROP TABLE IF EXISTS `TaughtBy`;
CREATE TABLE `TaughtBy` (
  `Tid` int(11) NOT NULL,
  `Subno` int(11) NOT NULL,
  PRIMARY KEY (`Tid`,`Subno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40000 ALTER TABLE `TaughtBy` DISABLE KEYS */;
INSERT INTO `TaughtBy` VALUES ('20','25'),('21','26'),('22','27'),('23','28'),('24','29');
/*!40000 ALTER TABLE `TaughtBy` ENABLE KEYS */;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;


-- phpMiniAdmin dump end
