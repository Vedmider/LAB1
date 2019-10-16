CREATE DATABASE `vegetable` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

CREATE TABLE `vegetable_color` (
                                   `id` int(11) NOT NULL AUTO_INCREMENT,
                                   `color` varchar(255) COLLATE utf8_bin NOT NULL,
                                   PRIMARY KEY (`id`),
                                   UNIQUE KEY `color` (`color`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `vegetable_type` (
                                  `id` int(11) NOT NULL AUTO_INCREMENT,
                                  `type_name` varchar(255) COLLATE utf8_bin NOT NULL,
                                  PRIMARY KEY (`id`),
                                  UNIQUE KEY `type_name` (`type_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `vegetable_prototype` (
                                       `id` int(11) NOT NULL AUTO_INCREMENT,
                                       `name` varchar(255) COLLATE utf8_bin NOT NULL,
                                       `color` int(11) NOT NULL,
                                       `type` int(11) NOT NULL,
                                       `calorific_value` int(11) NOT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `name` (`name`),
                                       KEY `vegetable_type_fk` (`type`),
                                       KEY `vegetable_color_fk` (`color`),
                                       CONSTRAINT `vegetable_color_fk` FOREIGN KEY (`color`) REFERENCES `vegetable_color` (`id`),
                                       CONSTRAINT `vegetable_type_fk` FOREIGN KEY (`type`) REFERENCES `vegetable_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `vegetable_type` (
                                  `id` int(11) NOT NULL AUTO_INCREMENT,
                                  `type_name` varchar(255) COLLATE utf8_bin NOT NULL,
                                  PRIMARY KEY (`id`),
                                  UNIQUE KEY `type_name` (`type_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `vegetables` (
                              `id` int(11) NOT NULL AUTO_INCREMENT,
                              `prototype` int(11) NOT NULL,
                              `weight` int(11) NOT NULL,
                              PRIMARY KEY (`id`),
                              KEY `prototype_fk` (`prototype`),
                              CONSTRAINT `prototype_fk` FOREIGN KEY (`prototype`) REFERENCES `vegetable_prototype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


INSERT INTO `vegetable_type` VALUES (2,'Bulb'),(4,'Fruit'),(1,'Leafy'),(3,'Root');
INSERT INTO `vegetable_color` VALUES (2,'Black'),(5,'Green'),(1,'Orange'),(4,'Red'),(6,'White'),(3,'Yellow');
INSERT INTO `vegetable_prototype` VALUES (11,'Carrot',3,1,3),(12,'Cucumber',5,4,5),(13,'Kale',5,1,6),(14,'Onion',6,2,3),(15,'Tomato',4,4,9);
INSERT INTO `vegetables` VALUES (7,11,200),(8,12,300),(9,14,230);
