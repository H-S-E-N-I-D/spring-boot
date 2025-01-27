CREATE DATABASE IF NOT EXISTS crud_db1;

-- Use the created database
USE crud_db1;

CREATE TABLE  IF NOT EXISTS `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `joined_date` date DEFAULT NULL,
  `active` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
)
