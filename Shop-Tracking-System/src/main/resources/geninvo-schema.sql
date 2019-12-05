-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.18 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for geninvo
DROP DATABASE IF EXISTS `geninvo`;
CREATE DATABASE IF NOT EXISTS `geninvo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `geninvo`;

-- Dumping structure for table geninvo.shops
DROP TABLE IF EXISTS `shops`;
CREATE TABLE IF NOT EXISTS `shops` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(50) DEFAULT NULL,
  `owner_name` varchar(50) DEFAULT NULL,
  `shop_category` varchar(50) DEFAULT NULL,
  `shop_address` varchar(50) DEFAULT NULL,
  `longitude` varchar(50) DEFAULT NULL,
  `latitude` varchar(50) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
