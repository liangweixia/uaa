drop table if exists user;
create table login(
`id` bigint(20) not null auto_increment,
`username` varchar(200) null comment '账户 ',
`password` varchar(200) null comment '密码 ',
`email` varchar(200) null comment '邮箱 ',
`mobile` varchar(200) null comment '手机号 ',
`status` varchar(200) null comment '状态 状态',
`tenant_id` bigint(20) null comment '租户ID',
`object_state` varchar(10) null comment '对象状态：normal-有效 disabled-失效',
`owner_id` bigint(20) null comment '拥有者ID',
`created_by`  bigint(20) null,
`created_time`  datetime null,
`last_updated_by`  bigint(20) null,
`last_updated_time`  datetime null,
primary key (`id`)
) engine=innodb auto_increment=1  comment='';
