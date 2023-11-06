/************************************************************分割线************************************************************/
/* todo MyBatis映射/JPA关联查询/MBP关联查询 */

CREATE TABLE `user`  (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
`password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `role`  (
`role_id` int(11) NOT NULL AUTO_INCREMENT,
`role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
--   `user_id` int(11) NULL DEFAULT 0,
PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `user_role`  (
`user_role_id` int(11) NOT NULL AUTO_INCREMENT,
`user_id` int(11) NULL DEFAULT 0,
`role_id` int(11) NULL DEFAULT 0,
PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

DELETE FROM `user`;
DELETE FROM `role`;
DELETE FROM `user_role`;
INSERT INTO `user` VALUES (1, 'name1', 'pwd1');
INSERT INTO `role` VALUES (1, 'role1');
INSERT INTO `role` VALUES (2, 'role2');
-- INSERT INTO `role` VALUES (1, 'role1', 1);
-- INSERT INTO `role` VALUES (2, 'role2', 1);
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 1, 2);

/* UUID作为主键（不推荐） */
CREATE TABLE `user`  (
`id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
`password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `role`  (
`role_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
`role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `user_role`  (
`user_role_id` int(11) NOT NULL AUTO_INCREMENT,
`user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
`role_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `user` VALUES ('877dd8c2-e7c3-4690-8778-f882a22d8093', 'user1', 'pwd1');
INSERT INTO `role` VALUES ('4d201114-7f13-40b9-abea-e7d7b00b183b', 'role1');
INSERT INTO `role` VALUES ('c83b950a-9ff5-11ea-bf9d-94c6910c8b5c', 'role2');
INSERT INTO `user_role` VALUES (1, '877dd8c2-e7c3-4690-8778-f882a22d8093', '4d201114-7f13-40b9-abea-e7d7b00b183b');
INSERT INTO `user_role` VALUES (2, '877dd8c2-e7c3-4690-8778-f882a22d8093', 'c83b950a-9ff5-11ea-bf9d-94c6910c8b5c');

/************************************************************分割线************************************************************/
/* todo mybatis_test */

CREATE TABLE `mybatis_test`  (
`id` int(11) NOT NULL AUTO_INCREMENT,
`parent_id` int(11) NULL DEFAULT 0,
`create_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `mybatis_test` VALUES (1, 0, '');
INSERT INTO `mybatis_test` VALUES (2, 0, '');
INSERT INTO `mybatis_test` VALUES (3, 0, '');
INSERT INTO `mybatis_test` VALUES (4, 0, '');
INSERT INTO `mybatis_test` VALUES (5, 0, '');
INSERT INTO `mybatis_test` VALUES (6, 0, '');
INSERT INTO `mybatis_test` VALUES (7, 0, '2018-12-26 18:00:00');
INSERT INTO `mybatis_test` VALUES (8, 0, '2018-12-26 19:00:00');
INSERT INTO `mybatis_test` VALUES (9, 0, '2018-12-27 18:00:00');
INSERT INTO `mybatis_test` VALUES (10, 0, '2018-12-27 19:00:00');
