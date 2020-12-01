drop table if exists `role`;
create table `role`
(
    id            bigint auto_increment primary key,
    code          varchar(32)  not null unique comment '编码',
    name          varchar(32)  not null comment '名称',
    remark        varchar(255) not null comment '备注',
    creator_id    bigint       not null comment '创建者主键',
    created_time  datetime     not null comment '创建时间',
    modifier_id   bigint       not null comment '修改者主键',
    modified_time datetime     not null comment '最近修改时间'
);

create index role_name_index on role (name);

COMMENT ON TABLE `role` IS '角色';
COMMENT ON COLUMN `role`.id IS '主键';

drop table if exists `user_role`;
create table `user_role`
(
    user_id bigint not null comment '用户',
    role_id bigint not null comment '角色',
    primary key (user_id, role_id)
);

COMMENT ON TABLE `user_role` IS '用户角色';
