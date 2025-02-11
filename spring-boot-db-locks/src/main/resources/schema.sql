CREATE DATABASE IF NOT EXISTS tickets_db;

-- Use the created database
USE tickets_db;

CREATE TABLE  IF NOT EXISTS `ticket_store` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `remaining_qty` int DEFAULT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE  IF NOT EXISTS `ticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `remaining_qty` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);
