
# csmm_platform 数据库
# ------------------------------------------------------------
create database csmm_platform;

# 使用csmm_platform 数据库
# ------------------------------------------------------------
use csmm_platform;

# 学生信息表: t_student
# ------------------------------------------------------------
drop table if exists `t_student`;
create table `t_student` (
  `stu_id` varchar(64) not null comment '主键:学号',
  
  `name` varchar(64) not null default '' comment '姓名',
  `gender` int(11) default null comment '性别[0/1:男/女]',
  `age` int(11) default null comment '年龄',
  
  `enabled` tinyint(1) not null default '0' comment '是否可用(0/1:否/是)',
  `gmt_created` timestamp not null default current_timestamp comment '创建时间',
  `gmt_modified` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`stu_id`)
) engine=innodb default charset=utf8 comment='学生信息表';

# wyx
# 用户信息表: t_student
# ------------------------------------------------------------
drop table if exists `t_user`;
create table `t_user` (
  `user_id` varchar(64) not null comment '主键:id',
  
  `username` varchar(64) not null default '' comment '用户名',
  `password` varchar(64) not null default '' comment '密码',
  `name` varchar(64) not null default '' comment '姓名',
  `gender` int(11) default null comment '性别[0/1:男/女]',
  `age` int(11) default null comment '年龄',
  `enabled` tinyint(1) not null default '0' comment '是否可用(0/1:否/是)',
  `gmt_created` timestamp not null default current_timestamp comment '创建时间',
  `gmt_modified` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`user_id`)
) engine=innodb default charset=utf8 comment='用户信息表';


#梁乐乐
# 使用csmm_platform 数据库
# ------------------------------------------------------------
use csmm_platform;

# 用户信息表: t_user
# ------------------------------------------------------------
drop table if exists `t_user`;
create table `t_user` (
  `user_id` varchar(64) not null comment '主键:学号',
  
  `name` varchar(64) not null default '' comment '姓名',
  `gender` int(11) default null comment '性别[0/1:男/女]',
  `age` int(11) default null comment '年龄',
  
  `enabled` tinyint(1) not null default '0' comment '是否可用(0/1:否/是)',
  `gmt_created` timestamp not null default current_timestamp comment '创建时间',
  `gmt_modified` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`user_id`)
) engine=innodb default charset=utf8 comment='用户信息表';

