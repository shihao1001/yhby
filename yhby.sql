CREATE DATABASE yhby DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE t_user(
    user_id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT "id",
    mobile_no VARCHAR(32) NOT NULL DEFAULT "" COMMENT "手机号",
    password varchar(1024) not null default "" comment "密码",
    user_name VARCHAR(32) NOT NULL DEFAULT "" COMMENT "姓名",
    nick_name VARCHAR(32) NOT NULL DEFAULT "" COMMENT "昵称",
    identity_id VARCHAR(32) NOT NULL DEFAULT "" COMMENT "身份证",
    is_realname int not null default 0 comment "是否实名,1:实名；0:未实名",
    home_addr VARCHAR(1000) NOT NULL DEFAULT "" COMMENT "家庭地址",
    community_name varchar(256) not null default "" comment "小区名称",
    company_addr VARCHAR(1000) NOT NULL DEFAULT "" COMMENT "公司地址",
    gender TINYINT NOT NULL DEFAULT 1 COMMENT "性别",
    birthday TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "生日",
    picture_url VARCHAR(128) NOT NULL DEFAULT "" COMMENT "头像",
    own_sign varchar(1024) not null default "" comment "个性签名",
    own_label varchar(1024) not null default "" comment "个人标签",
    create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
    update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT "更新时间",
    KEY `index_mobile_no` (`mobile_no`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT="用户表"



CREATE TABLE t_user_session(
   sid BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT "sid",
   user_id BIGINT(20) NOT NULL DEFAULT 0,
   token VARCHAR(128) NOT NULL DEFAULT "",
   secret VARCHAR(128) NOT NULL DEFAULT "",
   create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT "更新时间",
   KEY `Index_user_id` (`user_id`),
   UNIQUE KEY `ndex_token` (`token`)
);
