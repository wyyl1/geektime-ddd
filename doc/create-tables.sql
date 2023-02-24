CREATE TABLE `org` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tenant_id` int NOT NULL,
  `superior_id` int DEFAULT NULL COMMENT '上级 id',
  `org_type_code` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '组织类别代号',
  `leader_id` int NOT NULL COMMENT '负责人 id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `create_at` datetime NOT NULL,
  `create_by` int NOT NULL,
  `last_updated_at` datetime DEFAULT NULL,
  `last_updated_by` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='组织';