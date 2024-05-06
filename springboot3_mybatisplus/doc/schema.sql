/************************************************************分割线************************************************************/

CREATE TABLE `user`  (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
`password` json NULL,
`create_time` datetime NULL,
`update_time` datetime NULL,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `user`(`id`, `name`, `password`) VALUES (1, 'user1', '{"key": "val"}');
INSERT INTO `user`(`id`, `name`, `password`) VALUES (2, 'user2', '{"key": "val"}');
INSERT INTO `user`(`id`, `name`, `password`) VALUES (3, 'user3', '{"key": "val"}');

CREATE TABLE `role`  (
`role_id` int(11) NOT NULL AUTO_INCREMENT,
`role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
`user_id` int(11) NULL DEFAULT 0,
PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `role`(`role_id`, `role_name`, `user_id`) VALUES (1, 'role1', 1);
INSERT INTO `role`(`role_id`, `role_name`, `user_id`) VALUES (2, 'role2', 1);
INSERT INTO `role`(`role_id`, `role_name`, `user_id`) VALUES (3, 'role3', 2);
INSERT INTO `role`(`role_id`, `role_name`, `user_id`) VALUES (4, 'role4', 2);
