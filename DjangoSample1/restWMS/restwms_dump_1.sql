-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           8.0.15 - MySQL Community Server - GPL
-- SE du serveur:                Win64
-- HeidiSQL Version:             10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Listage de la structure de la base pour restWMS
CREATE DATABASE IF NOT EXISTS `restWMS` /*!40100 DEFAULT CHARACTER SET utf8mb4  */;
USE `restWMS`;

-- Listage de la structure de la table restWMS. restWMS_colors
CREATE TABLE IF NOT EXISTS `restWMS_colors` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `webtag` varchar(50) NOT NULL,
  `l_red` float NOT NULL,
  `l_green` float NOT NULL,
  `l_blue` float NOT NULL,
  `date_add` date DEFAULT NULL,
  `date_remove` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table restWMS.restWMS_colors : ~13 rows (environ)
/*!40000 ALTER TABLE `restWMS_colors` DISABLE KEYS */;
REPLACE INTO `restWMS_colors` (`id`, `name`, `webtag`, `l_red`, `l_green`, `l_blue`, `date_add`, `date_remove`) VALUES
    (' 1', '#123FFF', '#123FFF', 18, 63, 255, NULL, NULL),
    (' 10', '#00E3DE', '#00E3DE', 0, 227, 222, NULL, NULL),
    (' 11', '#9912E4', '#9912E4', 153, 18, 228, NULL, NULL),
    (' 12', '#EF54FE', '#EF54FE', 239, 84, 254, NULL, NULL),
    (' 13', '#123FFF', '#123FFF', 18, 63, 255, NULL, NULL),
    (' 2', '#AA34DD', '#AA34DD', 170, 52, 221, NULL, NULL),
    (' 3', '#33DDFF', '#33DDFF', 51, 221, 255, NULL, NULL),
    (' 4', '#AAEEDE', '#AAEEDE', 170, 238, 222, NULL, NULL),
    (' 5', '#FF0013', '#FF0013', 255, 0, 19, NULL, NULL),
    (' 6', '#000023', '#000023', 0, 0, 35, NULL, NULL),
    (' 7', '#EF47EA', '#EF47EA', 239, 71, 234, NULL, NULL),
    (' 8', '#FF2354', '#FF2354', 255, 35, 84, NULL, NULL),
    (' 9', '#7899FF', '#7899FF', 120, 153, 255, NULL, NULL);
/*!40000 ALTER TABLE `restWMS_colors` ENABLE KEYS */;

-- Listage de la structure de la table restWMS. restWMS_fixture
CREATE TABLE IF NOT EXISTS `restWMS_fixture` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `l_x` int(11) DEFAULT NULL,
  `l_y` int(11) DEFAULT NULL,
  `mode` varchar(50) DEFAULT NULL,
  `direction` int(11) DEFAULT NULL,
  `date_add` date DEFAULT NULL,
  `date_remove` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table restWMS.restWMS_fixture : ~0 rows (environ)
/*!40000 ALTER TABLE `restWMS_fixture` DISABLE KEYS */;
REPLACE INTO `restWMS_fixture` (`id`, `name`, `l_x`, `l_y`, `mode`, `direction`, `date_add`, `date_remove`) VALUES
    ('ws2811_bgr_5m_300', 'ws2811_rbg_5m_300', 300, 1, '2', 1, NULL, NULL),
    ('ws2811_rbg_5m_300', 'ws2811_rbg_5m_300', 300, 1, '1', 1, NULL, NULL);
/*!40000 ALTER TABLE `restWMS_fixture` ENABLE KEYS */;

-- Listage de la structure de la table restWMS. restWMS_product
CREATE TABLE IF NOT EXISTS `restWMS_product` (
  `code` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `date_add` date DEFAULT NULL,
  `date_remove` date DEFAULT NULL,
  `price` float DEFAULT NULL,
  `id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table restWMS.restWMS_product : ~0 rows (environ)
/*!40000 ALTER TABLE `restWMS_product` DISABLE KEYS */;
REPLACE INTO `restWMS_product` (`code`, `name`, `date_add`, `date_remove`, `price`, `id`) VALUES
    ('1\r\n', 'crepe', NULL, NULL, 4.5, 'crepe_1');
/*!40000 ALTER TABLE `restWMS_product` ENABLE KEYS */;

-- Listage de la structure de la table restWMS. restWMS_projectsetup
CREATE TABLE IF NOT EXISTS `restWMS_projectsetup` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `fixture` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fixture` (`fixture`),
  CONSTRAINT `fixture` FOREIGN KEY (`fixture`) REFERENCES `restWMS_fixture` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Listage des données de la table restWMS.restWMS_projectsetup : ~2 rows (environ)
/*!40000 ALTER TABLE `restWMS_projectsetup` DISABLE KEYS */;
/*!40000 ALTER TABLE `restWMS_projectsetup` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
