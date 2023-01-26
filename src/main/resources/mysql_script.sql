-- blog.post definition

CREATE TABLE `post` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` varchar(100) NOT NULL,
  `user_id` int NOT NULL,
  `date_created` date DEFAULT NULL,
  `date_edited` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `post_FK` (`user_id`),
  CONSTRAINT `post_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- blog.`user` definition

CREATE TABLE `user` (
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_UN` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;