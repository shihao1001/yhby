CREATE DATABASE yhby DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

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

create table t_product_type(
   product_type_id int not null auto_increment primary key comment "",
   product_type_name varchar(64) not null default "" comment ""
);


create table t_product(
  product_id bigint(20) not null auto_increment primary key comment "产品id",
  product_type_id int not null default 0 comment "产品类型",
  user_id BIGINT(20) NOT NULL default 0 comment "产品所有者",
  product_title varchar(256) not null default "" comment "产品标题",
  product_summary varchar(256) not null default "" comment "产品简介",
  product_pic varchar(1024) not null default "" comment "产品图片链接,以特殊符号间隔，如@@@",
  product_unit varchar(32) not null default "" comment "产品售卖单位",
  product_price int not null default 0 comment "产品价格,单位为分",
  product_status int not null default 0 comment "产品状态，0:未知；1:待发布（草稿）；2:发布中（有效）；3:下线（无效）",
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT "更新时间",
  key `Index_product_type_id` (`product_type_id`)
);

alter table t_product add index Index_user_id(`user_id`);
