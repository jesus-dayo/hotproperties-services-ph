--CREATE DATABASE hotproperties;
use hotpropertiesdev;

DROP TABLE IF EXISTS `User_Role`;
DROP TABLE IF EXISTS `User`;
DROP TABLE IF EXISTS `Role`;
DROP TABLE IF EXISTS `AuditLog`;
DROP TABLE IF EXISTS `Property`;
DROP TABLE IF EXISTS `Location`;
DROP TABLE IF EXISTS `Images`;
DROP TABLE IF EXISTS `Type`;
DROP TABLE IF EXISTS `Inquiry`;
DROP TABLE IF EXISTS `Alert`;

CREATE TABLE `Application_User` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(766) NOT NULL,
  `username` varchar(766) NOT NULL,
  `password` varchar(766) NOT NULL,
  `status` varchar(766) NOT NULL,
  `deleted` int(11) DEFAULT NULL,
  `last_created` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  
  `last_updated` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `Role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(766) NOT NULL,
  `description` varchar(766) DEFAULT NULL,  
  `deleted` int(11) DEFAULT NULL,
  `last_updated` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,  
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `User_Role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `users_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  `deleted` int(11) DEFAULT NULL,
  `last_updated` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,    
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `AuditLog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userame` varchar(766) NOT NULL,
  `role` varchar(766) DEFAULT NULL,
  `action` varchar(766) DEFAULT NULL,
  `method` varchar(766) DEFAULT NULL,
  `arguments` blob,
  `deleted` int(11) DEFAULT NULL,
  `last_updated` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `Location` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `psgc_code` varchar(255) DEFAULT NULL,
  `citymun_desc` text,
  `reg_desc` varchar(255) DEFAULT NULL,
  `prov_code` varchar(255) DEFAULT NULL,
  `citymun_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `Images` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(766) DEFAULT NULL,
  `image` varchar(2000) DEFAULT NULL,
  `property_id` bigint(20) DEFAULT NULL,
  `profile` tinyint(1) DEFAULT FALSE,
  `last_updated` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `Type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(766) DEFAULT NULL,
  `last_updated` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `Property` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(766) NOT NULL,
  `description` varchar(10000) DEFAULT NULL,
  `location_id` bigint(20) DEFAULT NULL,
  `price` varchar(766) DEFAULT NULL,
  `rooms` bigint(20) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `bath` bigint(20) DEFAULT NULL,
  `sqm` bigint(20) DEFAULT NULL,
  `swimming` tinyint(1) DEFAULT NULL,
  `garage` tinyint(1) DEFAULT NULL,
   `gym` tinyint(1) DEFAULT NULL,
   `court` tinyint(1) DEFAULT NULL,
   `youtubelink` varchar(766) DEFAULT NULL,
   `link` varchar(766) DEFAULT NULL,
   `category` int(1) DEFAULT NULL,
   `status` int(1) DEFAULT NULL,
   `latitude` varchar(200) DEFAULT NULL,
   `longitude` varchar(200) DEFAULT NULL,
  `last_updated` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_location` FOREIGN KEY
    (`location_id`)
    REFERENCES Location(`id`),
  CONSTRAINT `fk_type` FOREIGN KEY
    (`type_id`)
    REFERENCES Type(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `Inquiry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `message` varchar(766) DEFAULT NULL,
  `property_id` bigint(20) NOT NULL,
  `last_updated` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `Alert` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `message` varchar(766) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `propertyId` bigint(20) NOT NULL,
  `last_updated` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;