CREATE TABLE IF NOT EXISTS user (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID',
    username VARCHAR(255) NOT NULL UNIQUE COMMENT '用户名',
    password_salt VARCHAR(255) NOT NULL DEFAULT '' COMMENT '存储密码盐',
    password VARCHAR(255) NOT NULL COMMENT '存储加密后的密码',
    email VARCHAR(255) UNIQUE COMMENT '电子邮箱',
    mobile VARCHAR(20) UNIQUE COMMENT '手机号',
    gender ENUM('MALE', 'FEMALE', 'OTHER') COMMENT '性别',
    birthdate DATE COMMENT '出生日期',
    avatar VARCHAR(255) COMMENT '存储头像URL地址',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    create_by INT COMMENT '存储创建记录的用户ID',
    update_time DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    update_by INT COMMENT '存储更新记录的用户ID',
    remark TEXT COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 创建几个系统用户
insert into user(username, password_salt, password) values('admin', 'dsfc', '123456');
insert into user(username, password_salt, password) values('user', 'juyh', '123456');
insert into user(username, password_salt, password) values('guest', 'dcse', '123456');