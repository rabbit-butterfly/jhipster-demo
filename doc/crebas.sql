/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/7/23 12:38:36                           */
/*==============================================================*/


DROP TABLE IF EXISTS COMPANY;

DROP TABLE IF EXISTS PP_GRADE_MATERAIL;

DROP TABLE IF EXISTS PP_INSPECTION_RATIO;

DROP TABLE IF EXISTS PP_INSPECTION_RULE;

DROP TABLE IF EXISTS PP_LINE;

DROP TABLE IF EXISTS PP_LINE_DRAWING;

DROP TABLE IF EXISTS PP_LINE_WELD;

DROP TABLE IF EXISTS PP_LINE_WELD_CHECK;

DROP TABLE IF EXISTS PP_LINE_WELD_ENTRUST;

DROP TABLE IF EXISTS PP_LINE_WELD_MATERIAL;

DROP TABLE IF EXISTS PP_THICKNESS;

DROP TABLE IF EXISTS PROJECT;

DROP TABLE IF EXISTS PROJECT_AREA;

DROP TABLE IF EXISTS PROJECT_MATERIAL;

DROP TABLE IF EXISTS PROJECT_SPEC;

DROP TABLE IF EXISTS PROJECT_SUB_CONSTRACTOR;

DROP TABLE IF EXISTS PROJECT_USER;

DROP TABLE IF EXISTS PROJECT_WELDER;

DROP TABLE IF EXISTS USER_AREA;

DROP TABLE IF EXISTS USER_INFO;

DROP TABLE IF EXISTS USER_POWER;

DROP TABLE IF EXISTS WELDER;

DROP TABLE IF EXISTS WELDER_SKILL;

/*==============================================================*/
/* Table: COMPANY                                               */
/*==============================================================*/
CREATE TABLE COMPANY
(
   ID                   BIGINT(18) NOT NULL AUTO_INCREMENT COMMENT '主键',
   NAME                 VARCHAR(50) NOT NULL COMMENT '公司名称',
   CORPORATOR           VARCHAR(10),
   ADDRESS              VARCHAR(100) NOT NULL,
   PROVINCE             VARCHAR(10),
   CITY                 VARCHAR(10),
   AREA                 VARCHAR(10),
   REMARK               VARCHAR(500),
   MOBILE               VARCHAR(11) NOT NULL,
   STATUS               INT DEFAULT 0 COMMENT '0：冻结
            1：有效',
   DEL_FLAG             INT DEFAULT 0 COMMENT '0：有效
            1：逻辑删除',
   CREATE_TIME          TIMESTAMP,
   CREATOR              VARCHAR(10),
   UPDATE_TIME          TIMESTAMP,
   PRIMARY KEY (ID)
);

ALTER TABLE COMPANY COMMENT '公司表：存放公司的基本信息';

/*==============================================================*/
/* Table: PP_GRADE_MATERAIL                                     */
/*==============================================================*/
CREATE TABLE PP_GRADE_MATERAIL
(
   ID                   BIGINT(18) NOT NULL,
   COMP_ID              BIGINT NOT NULL,
   PROJ_ID              BIGINT NOT NULL,
   MATERIAL             VARCHAR(50),
   PP_CLASS             VARCHAR(50),
   JSIZE_MIN            VARCHAR(50),
   JSIZE_MAX            VARCHAR(50) COMMENT '@ 来源抽检比例表 中的代号',
   WALL_THICK_CODE      VARCHAR(64),
   MATERIAL_TYPE        VARCHAR(64) COMMENT '@ CS SS PE',
   MATERIAL_CATEGORY    VARCHAR(50) COMMENT '@ 常量',
   CREATE_TIME          TIMESTAMP,
   DEL_FLAG             INT,
   PRIMARY KEY (ID)
);

ALTER TABLE PP_GRADE_MATERAIL COMMENT '等级材质对照表';

/*==============================================================*/
/* Table: PP_INSPECTION_RATIO                                   */
/*==============================================================*/
CREATE TABLE PP_INSPECTION_RATIO
(
   ID                   BIGINT(18) NOT NULL,
   COMP_ID              BIGINT NOT NULL,
   PROJ_ID              BIGINT NOT NULL,
   INSPECTION_CODE      VARCHAR(50) COMMENT 'I III IV',
   RT_RATE              BIGINT(9),
   RT_RATE_GD           BIGINT(9),
   RT_STANDARD          VARCHAR(50),
   RT_GRADE             VARCHAR(50) COMMENT '@ I III IV',
   PT_RATE              BIGINT(9),
   PT_STANDARD          VARCHAR(50),
   PT_GRADE             VARCHAR(50),
   UT_RATE              BIGINT(9),
   UT_STANDARD          VARCHAR(50),
   UT_GRADE             VARCHAR(50),
   MT_RATE              BIGINT(9),
   MT_STANDARD          VARCHAR(50),
   MT_GRADE             VARCHAR(50),
   CREATE_TIME          TIMESTAMP,
   DEL_FLAG             INT,
   PRIMARY KEY (ID)
);

ALTER TABLE PP_INSPECTION_RATIO COMMENT '抽检比例设置表';

/*==============================================================*/
/* Table: PP_INSPECTION_RULE                                    */
/*==============================================================*/
CREATE TABLE PP_INSPECTION_RULE
(
   ID                   BIGINT(18) NOT NULL,
   COMP_ID              BIGINT NOT NULL,
   PROJ_ID              BIGINT NOT NULL,
   MATERIAL             VARCHAR(50),
   PP_CLASS             VARCHAR(50),
   JACKETED_PIPE        VARCHAR(50),
   INSPECTION_CODE      VARCHAR(50) COMMENT '@ 来源抽检比例表 中的代号',
   CREATE_TIME          TIMESTAMP,
   DEL_FLAG             INT,
   PRIMARY KEY (ID)
);

ALTER TABLE PP_INSPECTION_RULE COMMENT '抽检规则设置表';

/*==============================================================*/
/* Table: PP_LINE                                               */
/*==============================================================*/
CREATE TABLE PP_LINE
(
   ID                   BIGINT(18) NOT NULL,
   COMP_ID              BIGINT NOT NULL COMMENT 'comp_ID',
   PROJ_ID              BIGINT NOT NULL,
   AREA_ID              BIGINT NOT NULL,
   LINE_NUM             VARCHAR(50),
   LINE_VERSION         VARCHAR(20),
   SIZE                 VARCHAR(10),
   SERV                 VARCHAR(50),
   CLASS_SPEC           VARCHAR(50) COMMENT '@',
   LINE_FROM            VARCHAR(50),
   LINE_TO              VARCHAR(50),
   OPERATE_PRESSURE     VARCHAR(20),
   OPERATE_TEMPERATURE  VARCHAR(50),
   LINE_LEVEL           VARCHAR(10),
   LINE_CODE            VARCHAR(50),
   DESIGN_PRESSURE      VARCHAR(50),
   DESIGN_TEMPERATURE   VARCHAR(50),
   KIND_LEVEL           VARCHAR(50),
   INSPECTION_CODE      VARCHAR(50),
   INSULATION_CODE      VARCHAR(50),
   INSULATION_HIGH      VARCHAR(50),
   PAINT_CODE           VARCHAR(50),
   PI_DIAGRAM           VARCHAR(50),
   TEST_PRESSURE        VARCHAR(50),
   TEST_MATERIAL        VARCHAR(50),
   JACKETED_PIPE        VARCHAR(50),
   REMARK               VARCHAR(500),
   CREATE_TIME          TIMESTAMP,
   DEL_FLAG             INT,
   PRIMARY KEY (ID)
);

ALTER TABLE PP_LINE COMMENT '管道特性表';

/*==============================================================*/
/* Table: PP_LINE_DRAWING                                       */
/*==============================================================*/
CREATE TABLE PP_LINE_DRAWING
(
   ID                   BIGINT(18) NOT NULL,
   PIPE_ID              BIGINT NOT NULL,
   PAGE_CODE            INT,
   VERSION_CODE         VARCHAR(50),
   ALTERATION_CODE      VARCHAR(50),
   NAME                 VARCHAR(50),
   FILE_PATH            VARCHAR(200),
   REMARK               VARCHAR(500),
   CREATE_TIME          TIMESTAMP,
   DEL_FLAG             INT,
   PRIMARY KEY (ID)
);

ALTER TABLE PP_LINE_DRAWING COMMENT '管线-图片';

/*==============================================================*/
/* Table: PP_LINE_WELD                                          */
/*==============================================================*/
CREATE TABLE PP_LINE_WELD
(
   ID                   BIGINT(18) NOT NULL AUTO_INCREMENT,
   PIPE_ID              BIGINT NOT NULL,
   PAGE_CODE            VARCHAR(20),
   JIONT                VARCHAR(50),
   WPSNO                VARCHAR(32),
   JLOCATION            VARCHAR(50),
   JCLASS               VARCHAR(50),
   FINISH_DATE          DATE,
   JSIZE                VARCHAR(5),
   THICKNESS            VARCHAR(50) COMMENT '管道壁厚设置表@',
   JTYPE                VARCHAR(20) COMMENT '数据字典@',
   WELDING_PROCESS      VARCHAR(50) COMMENT '数据字典@',
   FIXED_ROTAT          VARCHAR(50) COMMENT '数据字典@',
   ROOT_WELDER          VARCHAR(50) COMMENT '焊工代号@',
   EXAMITEM             VARCHAR(32),
   COVER_WELDER         VARCHAR(50) COMMENT '焊工代号@',
   VISUAL               BIGINT(9) COMMENT '数据字典@',
   PIECE_NO1            VARCHAR(50),
   WELDING_MATIAL       VARCHAR(50),
   PIECE_NO2            VARCHAR(50),
   HEAT_NO1             VARCHAR(64),
   HEAT_NO2             VARCHAR(64),
   ALTER_CODE           VARCHAR(64),
   ALTER_TYPE           VARCHAR(64) COMMENT '数据字典@',
   DAILY_NO             VARCHAR(20),
   HARDESS_REC          VARCHAR(50),
   HEAT_REC             VARCHAR(64),
   RT_LOT               VARCHAR(50),
   RT_SAMPLE            VARCHAR(50),
   REMARK               VARCHAR(500),
   CREATE_TIME          TIMESTAMP,
   DEL_FLAG             INT,
   PRIMARY KEY (ID)
);

ALTER TABLE PP_LINE_WELD COMMENT '焊接记录表';

/*==============================================================*/
/* Table: PP_LINE_WELD_CHECK                                    */
/*==============================================================*/
CREATE TABLE PP_LINE_WELD_CHECK
(
   ID                   BIGINT(18) NOT NULL AUTO_INCREMENT,
   PROJ_ID              BIGINT(9) NOT NULL,
   PIPE_ID              BIGINT(9) NOT NULL,
   JOINT_ID             BIGINT,
   RTFILM_TOTAL         INT COMMENT '@rt',
   RTFILM_PASS_TOTAL    INT COMMENT '@rt',
   REPORT_CODE          VARCHAR(16) COMMENT '@rt',
   CHECK_DATE           VARCHAR(16) COMMENT '@rt',
   CHECK_RESULT         VARCHAR(16),
   REWORK_CODE          VARCHAR(50),
   REWORK_WELDER        VARCHAR(50),
   REWORK_DATE          DATE,
   REWORK_RESULT        VARCHAR(50),
   REPAIR_REPORT        VARCHAR(50),
   REMARK               VARCHAR(500),
   CREATE_TIME          TIMESTAMP,
   DEL_FLAG             INT,
   PRIMARY KEY (ID)
);

ALTER TABLE PP_LINE_WELD_CHECK COMMENT '焊接记录质量检查记录';

/*==============================================================*/
/* Table: PP_LINE_WELD_ENTRUST                                  */
/*==============================================================*/
CREATE TABLE PP_LINE_WELD_ENTRUST
(
   ID                   BIGINT(18) NOT NULL,
   PROJ_ID              BIGINT(9) NOT NULL,
   PIPELINE_ID          BIGINT NOT NULL,
   WELD_ID              BIGINT,
   FLOW_NUM             VARCHAR(20),
   CODE                 VARCHAR(50) COMMENT '@分项号-委托类型-流水号',
   EXPAND_COUNT         INT,
   REPARE_COUNT         INT,
   ENTRUST_TYPE         VARCHAR(10) COMMENT '@RT PT UT MT PMI',
   ENTRUST_DATE         DATE,
   REMARK               VARCHAR(500),
   CREATE_TIME          TIMESTAMP,
   DEL_FLAG             INT,
   PRIMARY KEY (ID)
);

ALTER TABLE PP_LINE_WELD_ENTRUST COMMENT '管线-焊接委托记录表';

/*==============================================================*/
/* Table: PP_LINE_WELD_MATERIAL                                 */
/*==============================================================*/
CREATE TABLE PP_LINE_WELD_MATERIAL
(
   ID                   BIGINT(18) NOT NULL AUTO_INCREMENT,
   PIPELINE_ID          BIGINT NOT NULL,
   PAGE_CODE            INT,
   SEQUENCE_NUMBER      INT,
   MATERIAL_CODE        VARCHAR(50),
   NAME                 VARCHAR(50),
   MATERIAL_DESC        VARCHAR(50),
   SPEC                 VARCHAR(50),
   UNIT                 VARCHAR(20),
   MATERIAL             VARCHAR(50),
   DESIGN_QTY           VARCHAR(50),
   REMARK               VARCHAR(500),
   CREATE_TIME          TIMESTAMP,
   DEL_FLAG             INT,
   PRIMARY KEY (ID)
);

ALTER TABLE PP_LINE_WELD_MATERIAL COMMENT '管线-焊接材料记录表';

/*==============================================================*/
/* Table: PP_THICKNESS                                          */
/*==============================================================*/
CREATE TABLE PP_THICKNESS
(
   ID                   BIGINT(18) NOT NULL,
   COMP_ID              BIGINT NOT NULL,
   PROJ_ID              BIGINT NOT NULL,
   JSIZE                VARCHAR(5),
   WALL_THICK_CODE      VARCHAR(50),
   EXTERNAL_DIAMETER    BIGINT(9),
   THICKNESS            BIGINT(9),
   CREATE_TIME          TIMESTAMP,
   DEL_FLAG             INT,
   PRIMARY KEY (ID)
);

ALTER TABLE PP_THICKNESS COMMENT '管道壁厚设置表';

/*==============================================================*/
/* Table: PROJECT                                               */
/*==============================================================*/
CREATE TABLE PROJECT
(
   ID                   BIGINT(18) NOT NULL,
   CODE                 VARCHAR(20) NOT NULL,
   NAME                 VARCHAR(80),
   EN_NAME              VARCHAR(32),
   SUPERVISOR           VARCHAR(100),
   OWNER_CONTRACTOR     VARCHAR(100),
   TOTAL_CONTRACTOR     VARCHAR(100),
   START_DATE           DATE,
   END_DATE             DATE,
   STATUS               INT DEFAULT 0 COMMENT '0：待审核
            1：审核通过
            2：审核失败
            3：终结',
   DEL_FLAG             INT DEFAULT 0,
   REMARK               VARCHAR(500),
   EXTEND_ATTR          VARCHAR(50) COMMENT '扩展字段',
   PRIMARY KEY (ID)
);

ALTER TABLE PROJECT COMMENT '存放项目的基本信息:开始时间，结束时间，是否停工等';

/*==============================================================*/
/* Table: PROJECT_AREA                                          */
/*==============================================================*/
CREATE TABLE PROJECT_AREA
(
   ID                   BIGINT(18) NOT NULL AUTO_INCREMENT,
   COMP_ID              BIGINT(9) NOT NULL,
   PROJ_ID              BIGINT NOT NULL,
   AREA_CODE            VARBINARY(10),
   NAME                 VARCHAR(80),
   EN_NAME              VARCHAR(100),
   UNIT_CODE            VARCHAR(50),
   SUB_CONSTRACTOR      VARCHAR(80),
   PRIMARY KEY (ID)
);

ALTER TABLE PROJECT_AREA COMMENT '分包项目：项目的子表';

/*==============================================================*/
/* Table: PROJECT_MATERIAL                                      */
/*==============================================================*/
CREATE TABLE PROJECT_MATERIAL
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   PROJ_ID              BIGINT,
   NAME                 VARCHAR(80),
   PARENT_ID            BIGINT,
   REMARK               VARCHAR(500),
   CREATE_TIME          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   DEL_FLAG             INT,
   PRIMARY KEY (ID)
);

ALTER TABLE PROJECT_MATERIAL COMMENT '项目物资类别表';

/*==============================================================*/
/* Table: PROJECT_SPEC                                          */
/*==============================================================*/
CREATE TABLE PROJECT_SPEC
(
   ID                   BIGINT(18) NOT NULL AUTO_INCREMENT,
   PROJ_ID              BIGINT,
   NAME                 VARCHAR(80) COMMENT '规格名称',
   SIZE                 VARCHAR(10) COMMENT '大小',
   UNIT                 VARCHAR(50) COMMENT '场地',
   REMARK               VARCHAR(500),
   CREATE_TIME          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   DEL_FLAG             INT,
   PRIMARY KEY (ID)
);

ALTER TABLE PROJECT_SPEC COMMENT '项目物资规格明细表';

/*==============================================================*/
/* Table: PROJECT_SUB_CONSTRACTOR                               */
/*==============================================================*/
CREATE TABLE PROJECT_SUB_CONSTRACTOR
(
   ID                   BIGINT(18) NOT NULL AUTO_INCREMENT,
   PROJ_ID              BIGINT NOT NULL,
   NAME                 VARCHAR(80) NOT NULL,
   REMARK               VARCHAR(500),
   CREATE_TIME          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   DEL_FLAG             INT,
   PRIMARY KEY (ID)
);

ALTER TABLE PROJECT_SUB_CONSTRACTOR COMMENT '项目分包商基本信息表';

/*==============================================================*/
/* Table: PROJECT_USER                                          */
/*==============================================================*/
CREATE TABLE PROJECT_USER
(
   ID                   BIGINT(18) NOT NULL AUTO_INCREMENT,
   COMP_ID              BIGINT NOT NULL,
   PROJ_ID              BIGINT(9) NOT NULL,
   USER_ID              BIGINT(9),
   CREATE_TIME          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   DEL_FLAG             INT COMMENT '0：未删除
            1：删除',
   PRIMARY KEY (ID)
);

ALTER TABLE PROJECT_USER COMMENT '项目用户关系表';

/*==============================================================*/
/* Table: PROJECT_WELDER                                        */
/*==============================================================*/
CREATE TABLE PROJECT_WELDER
(
   ID                   BIGINT(18) NOT NULL AUTO_INCREMENT,
   COMP_ID              BIGINT NOT NULL,
   CODE                 VARCHAR(20),
   NAME                 VARCHAR(10) NOT NULL,
   MOBILLE              VARCHAR(16),
   IDENTITY_CARD        VARCHAR(18),
   WORK_TERM            VARCHAR(10),
   UNIT_NAME            VARCHAR(50),
   CREATE_TIME          TIMESTAMP,
   DEL_FLAG             INT,
   REMARK               VARCHAR(500),
   PRIMARY KEY (ID)
);

ALTER TABLE PROJECT_WELDER COMMENT '项目 焊工 工人 关系表';

/*==============================================================*/
/* Table: USER_AREA                                             */
/*==============================================================*/
CREATE TABLE USER_AREA
(
   ID                   BIGINT(18) NOT NULL AUTO_INCREMENT,
   USER_ID              BIGINT NOT NULL,
   AREA_ID              BIGINT NOT NULL,
   PRIMARY KEY (ID)
);

ALTER TABLE USER_AREA COMMENT '用户选中了项目中的哪几个分项';

/*==============================================================*/
/* Table: USER_INFO                                             */
/*==============================================================*/
CREATE TABLE USER_INFO
(
   ID                   BIGINT(18) NOT NULL AUTO_INCREMENT,
   COMP_ID              BIGINT(9) NOT NULL COMMENT '公司ID',
   CODE                 BIGINT(9) COMMENT '用户工号',
   MOBILE               VARCHAR(16) COMMENT '手机号码',
   STATUS               SMALLINT(1) COMMENT '0：无效
            1：有效',
   JOB_TITLE            VARCHAR(16) COMMENT '岗位@',
   MAJOR                VARCHAR(16) COMMENT '专业@',
   JH_USER_ID           BIGINT(9) NOT NULL,
   PRIMARY KEY (ID)
);

ALTER TABLE USER_INFO COMMENT '公司成员表';

/*==============================================================*/
/* Table: USER_POWER                                            */
/*==============================================================*/
CREATE TABLE USER_POWER
(
   ID                   BIGINT(18) NOT NULL AUTO_INCREMENT,
   USER_ID              BIGINT NOT NULL,
   PARENT_CODE          VARCHAR(3) NOT NULL,
   MENU_CODE            VARBINARY(6) NOT NULL COMMENT '100：系统设置
            100001： 公司管理
            10000101：新增
            10000102：编辑
            100002：用户管理',
   FUNC_CODE            VARCHAR(8) NOT NULL,
   PRIMARY KEY (ID)
);

ALTER TABLE USER_POWER COMMENT '用户菜单权限';

/*==============================================================*/
/* Table: WELDER                                                */
/*==============================================================*/
CREATE TABLE WELDER
(
   ID                   BIGINT(18) NOT NULL,
   COMP_ID              BIGINT NOT NULL,
   CODE                 VARCHAR(20),
   NAME                 VARCHAR(10) NOT NULL,
   MOBILLE              VARCHAR(16),
   IDENTITY_CARD        VARCHAR(20),
   WORK_TERM            VARCHAR(10),
   UNIT_NAME            VARCHAR(50),
   CREATE_TIME          TIMESTAMP,
   DEL_FLAG             INT,
   REMARK               VARCHAR(500),
   PRIMARY KEY (ID)
);

ALTER TABLE WELDER COMMENT '焊工工人表-包括：焊工姓名、手机号码、所在班组等';

/*==============================================================*/
/* Table: WELDER_SKILL                                          */
/*==============================================================*/
CREATE TABLE WELDER_SKILL
(
   ID                   BIGINT(18) NOT NULL AUTO_INCREMENT,
   WELDER_ID            BIGINT(9) NOT NULL,
   NAME                 VARCHAR(80) NOT NULL,
   ASSESSMENT_DATE      DATE,
   EFFECTIVE_DATE       DATE,
   CREATE_TIME          TIMESTAMP,
   DEL_FLAG             INT,
   PRIMARY KEY (ID)
);

ALTER TABLE WELDER_SKILL COMMENT '焊工技能表';

