CREATE DATABASE IF NOT EXISTS study_abroad DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE study_abroad;

CREATE TABLE IF NOT EXISTS `school` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name_cn` VARCHAR(100) NOT NULL COMMENT '中文名',
    `name_en` VARCHAR(100) COMMENT '英文名',
    `name_ru` VARCHAR(100) COMMENT '俄语名',
    `city` VARCHAR(50) COMMENT '所在城市',
    `logo_url` VARCHAR(255) COMMENT 'Logo',
    `cover_url` VARCHAR(255) COMMENT '封面图',
    `intro_cn` TEXT COMMENT '中文介绍',
    `intro_ru` TEXT COMMENT '俄语介绍',
    `intro_en` TEXT COMMENT '英文介绍',
    `sort` INT DEFAULT 0 COMMENT '排序',
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学校表';

CREATE TABLE IF NOT EXISTS `major` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `school_id` BIGINT NOT NULL,
    `name_cn` VARCHAR(100) NOT NULL,
    `name_ru` VARCHAR(100),
    `name_en` VARCHAR(100),
    `degree` VARCHAR(20),
    `duration` INT,
    `tuition` DECIMAL(10,2),
    `language` VARCHAR(20),
    `intro_cn` TEXT,
    `sort` INT DEFAULT 0,
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `idx_school` (`school_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='专业表';

CREATE TABLE IF NOT EXISTS `application` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `full_name` VARCHAR(100) NOT NULL,
    `gender` VARCHAR(10),
    `birth_date` DATE,
    `nationality` VARCHAR(50),
    `passport_no` VARCHAR(50),
    `phone` VARCHAR(50) NOT NULL,
    `email` VARCHAR(100),
    `wechat` VARCHAR(50),
    `whatsapp` VARCHAR(50),
    `current_education` VARCHAR(50),
    `current_school` VARCHAR(100),
    `target_school_id` BIGINT,
    `target_major` VARCHAR(100),
    `target_degree` VARCHAR(20),
    `intake_year` VARCHAR(20),
    `message` TEXT,
    `status` VARCHAR(20) DEFAULT 'NEW',
    `remark` TEXT,
    `ip_address` VARCHAR(50),
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `idx_status` (`status`),
    KEY `idx_created` (`created_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='报名表';

INSERT INTO `school` (`name_cn`, `name_en`, `name_ru`, `city`, `intro_cn`, `intro_ru`, `sort`) VALUES
('清华大学', 'Tsinghua University', 'Университет Цинхуа', '北京', 
 '中国顶尖学府，工科、理科、管理学科享誉全球。', 
 'Ведущий университет Китая, известный во всём мире.', 1),
('北京大学', 'Peking University', 'Пекинский университет', '北京', 
 '中国最古老的现代大学之一，人文社科领域领先。', 
 'Один из старейших современных университетов Китая.', 2);

INSERT INTO `major` (`school_id`, `name_cn`, `name_ru`, `name_en`, `degree`, `duration`, `tuition`, `language`) VALUES
(1, '计算机科学与技术', 'Компьютерные науки', 'Computer Science', '本科', 4, 26000, '中文'),
(2, '国际经济与贸易', 'Международная экономика', 'International Economics', '本科', 4, 26000, '中文');