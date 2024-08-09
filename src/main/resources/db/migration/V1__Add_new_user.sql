create table if not exists user (
 id int auto_increment primary key,
 create_time datetime default current_timestamp,
 create_by varchar(255) default null,
 update_time datetime default null on update current_timestamp,
 update_by varchar(255) default null,
 remark text
) engine=innodb default charset=utf8mb4;