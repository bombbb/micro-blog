/*用户信息表*/
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
   `user_id` BIGINT   AUTO_INCREMENT COMMENT "用户ID",
   `user_number` BIGINT  DEFAULT NULL COMMENT "用户编号",
   `nick_name`  VARCHAR(30) DEFAULT NULL COMMENT "昵称" ,
   `login_password` VARCHAR(50) NOT NULL COMMENT "登录密码",
   `salt` VARCHAR(50) DEFAULT NULL COMMENT "登录密码盐",
   `actual_name` VARCHAR(100) DEFAULT NULL COMMENT "真实姓名",
   `gender`  VARCHAR(10) DEFAULT NULL COMMENT "性别",
   `age`  TINYINT UNSIGNED DEFAULT NULL  COMMENT "年龄",
   `header_url` VARCHAR(100) DEFAULT NULL COMMENT "头像URL",
   /*0:未注册，1：已注册，2：登录状态，3：离线状态，4,禁止登录状态，5：注销状态）*/
   `status` TINYINT DEFAULT NULL COMMENT "状态",
   `email` VARCHAR(30) COMMENT "电子邮箱",
   `email_active` TINYINT DEFAULT NULL COMMENT "邮箱是否激活",
   `phone_num` VARCHAR(20)  DEFAULT NULL  COMMENT "电话号码",
   `register_time` TIMESTAMP DEFAULT  CURRENT_TIMESTAMP COMMENT "注册时间",
   `last_login_time` DATETIME DEFAULT NULL COMMENT "最后登录时间",
   `update_time` TIMESTAMP DEFAULT  CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "注册时间",
   `login_nums`  INT DEFAULT NULL COMMENT "登录次数",
    PRIMARY KEY (`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT="用户表";




DROP TABLE IF EXISTS `user_delete`;
CREATE TABLE `user_delete`(
   `id` BIGINT   AUTO_INCREMENT COMMENT "删除用户ID",
   `user_id` BIGINT  DEFAULT NULL COMMENT "用户ID",
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT="用户删除表";


/*用户记录删除时将删除的用户ID存放到删除表，搜索引擎会将搜索引擎中的数据同步删除*/
DROP TRIGGER IF EXISTS `user_update_trigger`;
CREATE TRIGGER user_update_trigger AFTER DELETE
ON user  FOR EACH ROW
BEGIN
INSERT  INTO user_delete (user_id) values(OLD.user_id);
END;


DELETE FROM user where user_id=22;

/*
通过followerId查询获得用户的关注列表
通过followeeId查询获得用户的粉丝列表
*/
DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation`(
   `id` BIGINT   AUTO_INCREMENT COMMENT "ID",
   `followerId` BIGINT   COMMENT "关注者ID",
   `followeeId` BIGINT   COMMENT "被关注者ID",
    PRIMARY KEY (`id`),
    index(`followerId`),
    index(`followeeId`),
    index(`followerId`,`followeeId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT="关系表";


