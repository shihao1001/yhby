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
) COMMENT="用户表"


alter table t_user add column city_id int not null default 0 comment "所属城市id";
alter table t_user add column community_id bigint(20) not null default 0 comment "所属小区id";


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

create table t_community(
  community_id bigint(20) not null auto_increment primary key comment "小区id",
  community_name varchar(64) not null default "" comment "小区名称", 
  community_address varchar(1024) not null default "" comment "小区地址",
  community_latitude double not null default 0 comment "小区纬度",
  community_longitude double not null default 0 comment "小区经度",
  community_status int not null default 0 comment "小区开放状态，0:未知；1:开放；2:关闭",
  city_id int not null default 0 comment "所在城市id"
);

create table t_province(
   province_id int not null auto_increment primary key comment "省份id",
   province_code varchar(20) not null default "" comment "省份代码",
   province_name varchar(50) not null default "" comment "省级名称"
)comment="省级信息表";

# alter table t_province add column status int not null default 0 comment "状态，0:未开放；1:开放";


create table t_city(
  city_id int NOT NULL auto_increment primary key comment "城市id",  
  city_code varchar(20) not null default "" comment "城市代码",  
  city_name varchar(50) NOT NULL default "" comment "城市名称",  
  province_id varchar(20) NOT NULL default "" comment "省份id"
)comment="城市信息表";


--create table t_product_type(
--   product_type_id int not null auto_increment primary key comment "",
--   product_type_name varchar(64) not null default "" comment ""
--);

create table p_product_type(
  id int not null auto_increment primary key comment "自增id",
  name varchar(64) not null default "" comment "种类名称",
  status int not null default 0 comment "状态，0:未启用；1:启用",
  pic varchar(256) not null default "" comment "图片url",
  rank int not null default 0 comment "排序",
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT "更新时间"
);

insert into p_product_type(name,rank) values ("家庭美食",1),("代办跑腿",2),("有房租售",3),("家庭教学",4)



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



create table t_advice(
  id bigint(20) not null auto_increment primary key comment "自增id",
  user_id bigint(20) not null default 0 comment "所属用户id",
  advice_content varchar(2048) not null default "" comment "意见建议",
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT "更新时间",
  key `Index_user_id` (`user_id`)
);



create table o_order(
   order_id bigint(20) not null auto_increment primary key comment "自增id",
   product_id bigint(20) not null default 0 comment "产品id",
   price int not null default 0 comment "单价",
   quantity int not null default 0 comment "数量",
   buyer_id bigint(20) not null default 0 comment "购买人",
   seller_id bigint(20) not null default 0 comment "售卖人",
   status int not null default 0 comment "订单状态，0:创建；1:付款；2:结算",
   create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
   update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT "更新时间",
   key `Index_buyer_id` (`buyer_id`),
   key `Index_seller_id` (`seller_id`)
);


create table c_banner(
  id bigint(20) not null auto_increment primary key comment "自增id",
  name varchar(128) not null default "" comment "名称",
  pic_url varchar(256) not null default "" comment "图片链接",
  is_hit int not null default 0 comment "是否可以点击，0:不可以；1:可以",
  link_url varchar(256) not null default "" comment "点击图片的链接",
  rank int not null default 0 comment "排序；1:最高",
  weight int not null default 0 comment "权重，用于显示时间长短",
  is_share int not null default 0 comment "是否可以分享;0:不可以；1:可以",
  status int not null default 0 comment "状态；0:无效；1:有效",
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP comment "创建时间",
  update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT "更新时间" 
);


