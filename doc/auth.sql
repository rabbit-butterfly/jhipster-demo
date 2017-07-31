DROP TABLE IF EXISTS JHI_ROLE;

/*==============================================================*/
/* Table: JHI_ROLE                                              */
/*==============================================================*/
CREATE TABLE JHI_ROLE
(
   ID                   BIGINT(18) NOT NULL AUTO_INCREMENT COMMENT '主键',
   NAME                 VARCHAR(32) NOT NULL COMMENT '权限名称',
   CODE                 VARCHAR(16) NOT NULL COMMENT '编码',
   LEVEL                SMALLINT(1) NOT NULL COMMENT '级别',
   PARENT_ID            BIGINT(9) NOT NULL COMMENT '父节点',
   CREATED_BY           VARCHAR(16) COMMENT '创建人',
   CREATED_DATE         TIMESTAMP COMMENT '创建时间',
   LAST_MODIFIED_BY     VARCHAR(16) COMMENT '修改人',
   LAST_MODIFIED_DATE   DATE COMMENT '修改时间',
   PRIMARY KEY (ID)
);


DROP TABLE IF EXISTS JHI_BIZ_AUTH;

/*==============================================================*/
/* Table: JHI_BIZ_AUTH                                          */
/*==============================================================*/
CREATE TABLE JHI_BIZ_AUTH
(
   ID                   BIGINT(18) NOT NULL COMMENT '主键',
   BIZ_NAME             VARCHAR(16) NOT NULL COMMENT '业务类别',
   ROLE_CODE            VARCHAR(16) NOT NULL COMMENT '角色编码',
   MIN_AUTH_CODE        BIGINT(9) NOT NULL COMMENT '最小限码',
   MAX_AUTH_CODE        BIGINT(9) COMMENT '最大权限权',
   AUTH_CODE            VARCHAR(1024) COMMENT '特殊权限码',
   AUTH_CATEGORY        SMALLINT(1) NOT NULL DEFAULT 0 COMMENT '权限类别@0:范围,1:特殊权限包含,1:特殊权限排除',
   CREATED_BY           VARCHAR(16) COMMENT '创建人',
   CREATED_DATE         TIMESTAMP COMMENT '创建时间',
   LAST_MODIFIED_BY     VARCHAR(16) COMMENT '修改人',
   LAST_MODIFIED_DATE   DATE COMMENT '修改时间',
   PRIMARY KEY (ID)
);

ALTER TABLE JHI_BIZ_AUTH COMMENT '数据权限设置';

DROP TABLE IF EXISTS JHI_BIZ;

/*==============================================================*/
/* Table: JHI_BIZ                                               */
/*==============================================================*/
CREATE TABLE JHI_BIZ
(
   ID                   BIGINT(18) NOT NULL AUTO_INCREMENT COMMENT '主键',
   BIZ_NAME             VARCHAR(16) NOT NULL COMMENT '业务名称',
   PRIMARY KEY (ID)
);

ALTER TABLE JHI_BIZ COMMENT '数据权限设置';
