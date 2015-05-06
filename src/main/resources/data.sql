
-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` (username, password, enabled) VALUES ('admin', '$2a$10$of1L1pNENMuUeP2/pMfy1ePScKhrOzHIrHsuhL2u1ieoXClLP5wFG', '1');
INSERT INTO `users` (username, password, enabled) VALUES ('xiwc', '$2a$10$qR3ar2k/g9gsLgPKAqqprOcN4tsfQAiSd7mdLNDIEC4ytwAUKKgzO', '1');
INSERT INTO `users` (username, password, enabled) VALUES ('lhjz', '$2a$10$cHoqi0vbJpkOe.ShF7A6qO0kf8lKOH/6tHr3oe7vA4UcKdtgGeJnq', '1');

-- ----------------------------
-- Records of authorities
-- ----------------------------
INSERT INTO `authorities` (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO `authorities` (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO `authorities` (username, authority) VALUES ('xiwc', 'ROLE_ADMIN');
INSERT INTO `authorities` (username, authority) VALUES ('xiwc', 'ROLE_USER');
INSERT INTO `authorities` (username, authority) VALUES ('lhjz', 'ROLE_ADMIN');
INSERT INTO `authorities` (username, authority) VALUES ('lhjz', 'ROLE_USER');

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` (id, age, first_name, last_name, password, sex, user_name) VALUES (null, 30, 'zhang', 'san', 'zhangsan', 1, 'zhangsan');
INSERT INTO `test` (id, age, first_name, last_name, password, sex, user_name) VALUES (null, 28, 'li', 'si', 'lisi', 2, 'lisi');
INSERT INTO `test` (id, age, first_name, last_name, password, sex, user_name) VALUES (null, 28, 'li', 'si2', 'lisi2', 2, 'lisi2');
INSERT INTO `test` (id, age, first_name, last_name, password, sex, user_name) VALUES (null, 40, 'wang', 'wu', 'wangwu', 1, 'wangwu');
INSERT INTO `test` (id, age, first_name, last_name, password, sex, user_name) VALUES (null, 40, 'wang', 'wu', 'wangwu', 1, 'wangwu');
INSERT INTO `test` (id, age, first_name, last_name, password, sex, user_name) VALUES (null, 40, 'wang', 'wu', 'wangwu', 1, 'wangwu');
INSERT INTO `test` (id, age, first_name, last_name, password, sex, user_name) VALUES (null, 40, 'wang', 'wu', 'wangwu', 1, 'wangwu');
INSERT INTO `test` (id, age, first_name, last_name, password, sex, user_name) VALUES (null, 40, 'wang', 'wu', 'wangwu', 1, 'wangwu');
INSERT INTO `test` (id, age, first_name, last_name, password, sex, user_name) VALUES (null, 40, 'wang', 'wu', 'wangwu', 1, 'wangwu');
