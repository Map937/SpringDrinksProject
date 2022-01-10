DROP TABLE IF EXISTS drink CASCADE;
CREATE TABLE `drink` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `colour` varchar(255) NOT NULL,
  `drink_name` varchar(255) NOT NULL,
  `is_fizzy` bit(1) NOT NULL,
  `ml` int NOT NULL,
  PRIMARY KEY (`id`)
)