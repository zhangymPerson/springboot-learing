CREATE TABLE IF NOT EXISTS user_login_log (
    log_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '日志ID，使用BIGINT以支持更多记录',
    user_id INT NOT NULL COMMENT '用户ID，整数类型，外键可选关联用户表',
    login_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间，默认为当前时间',
    login_ip VARCHAR(45) NOT NULL COMMENT '登录IP地址，考虑IPv6长度',
    login_status ENUM('SUCCESS', 'FAILURE') NOT NULL COMMENT '登录状态',
    failure_reason TEXT COMMENT '登录失败原因，可为空',
    user_agent TEXT COMMENT '用户代理信息，可为空',
    browser VARCHAR(255) COMMENT '浏览器名称，可为空',
    browser_version VARCHAR(50) COMMENT '浏览器版本，可为空',
    operating_system VARCHAR(255) COMMENT '操作系统名称，可为空',
    operating_system_version VARCHAR(50) COMMENT '操作系统版本，可为空',
    INDEX idx_login_time (login_time) COMMENT '为登录时间添加索引以提高查询性能',
    INDEX idx_user_id (user_id) COMMENT '为用户ID添加索引以提高关联查询性能'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户登录日志表';