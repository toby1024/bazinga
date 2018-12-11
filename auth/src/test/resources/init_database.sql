DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id`                  INT(11) UNSIGNED NOT NULL  AUTO_INCREMENT,
  `username`            VARCHAR(50)      NOT NULL COMMENT '用户名',
  `password`            VARCHAR(200)     NOT NULL COMMENT '密码',
  `salt`                VARCHAR(20)      NOT NULL COMMENT 'salt',
  `created_at`          DATETIME                   DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at`          DATETIME                   DEFAULT CURRENT_TIMESTAMP COMMENT '编辑时间',
  PRIMARY KEY (`id`)
);