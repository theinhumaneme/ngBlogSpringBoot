USE blog;


-- blog.`user` definition

CREATE TABLE `user` (
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_UN` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- blog.comment definition

CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(100) NOT NULL,
  `user_id` int NOT NULL,
  `post_id` int NOT NULL,
  `date_created` date NOT NULL,
  `date_edited` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `comment_FK` (`post_id`),
  KEY `comment_FK_1` (`user_id`),
  CONSTRAINT `comment_FK` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`),
  CONSTRAINT `comment_FK_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- blog.upvoted_posts definition

CREATE TABLE `upvoted_posts` (
  `user_id` int NOT NULL,
  `post_id` int NOT NULL,
  KEY `upvoted_posts_FK` (`user_id`),
  KEY `upvoted_posts_FK_1` (`post_id`),
  CONSTRAINT `upvoted_posts_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `upvoted_posts_FK_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- blog.upvoted_comments definition

CREATE TABLE `upvoted_comments` (
  `user_id` int NOT NULL,
  `comment_id` int NOT NULL,
  KEY `upvoted_comments_FK` (`user_id`),
  KEY `upvoted_comments_FK_1` (`comment_id`),
  CONSTRAINT `upvoted_comments_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `upvoted_comments_FK_1` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;