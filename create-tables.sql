CREATE TABLE `roles` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `type` char(255) NOT NULL,
    `description` text(2000) NOT NULL,
    `author_id` int DEFAULT 0,
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
    `edited_ed` datetime
) COLLATE 'utf8mb3_general_ci';

CREATE TABLE `users` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(255) NOT NULL,
    `surname` varchar(255) NOT NULL,
    `sex` enum('male', 'female', 'other' ) DEFAULT 'other' NOT NULL,
    `comment` varchar(255),
    `role_id` int NOT NULL,
    `phone` varchar(255),
    `email` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `bio_info` text(3000),
    `is_active` bit DEFAULT 1,
    `author_id` int DEFAULT 0 NOT NULL,
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
    `edited_ed` datetime,
    CONSTRAINT UC_tests2 UNIQUE (`phone`, `email`),
    INDEX role_id (role_id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
) COLLATE 'utf8mb3_general_ci';

CREATE TABLE `services` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title` char(255) NOT NULL,
    `description` text(3000) NOT NULL,
    `image_url` varchar(255),
    `specialist_id` int NOT NULL,
    `price` decimal(8,2) NOT NULL,
    `published` bit(1) NOT NULL DEFAULT 0,
    `author_id` int DEFAULT 0,
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
    `edited_ed` datetime,
    INDEX user_ind (specialist_id),
    FOREIGN KEY (specialist_id) REFERENCES users(id)
) COLLATE 'utf8mb3_general_ci';

CREATE TABLE `appointments` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id` int NOT NULL,
    `specialist_id` int NOT NULL,
    `service_id` int NOT NULL,
    `start_time` datetime,
    `status` enum('planning', 'in processing', 'paid', 'canceled') DEFAULT 'in processing',
    `end_time` datetime,
    `comment` char(255),
    `author_id` int DEFAULT 0,
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
    `edited_ed` datetime,
    INDEX service_ind (service_id),
    INDEX user_ind (user_id),
    FOREIGN KEY (service_id) REFERENCES services(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
) COLLATE 'utf8mb3_general_ci';

CREATE TABLE `orders` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `appointment_id` int NOT NULL,
    `price` decimal(8,2) NOT NULL,
    `status` enum('received', 'in processing', 'paid', 'canceled') DEFAULT 'received',
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
    INDEX service_ind (appointment_id),
    FOREIGN KEY (appointment_id) REFERENCES appointments(id)
) COLLATE 'utf8mb3_general_ci';
