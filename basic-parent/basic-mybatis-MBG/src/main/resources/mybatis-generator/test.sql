USE study;
/*员工表*/
DROP TABLE IF EXISTS t_crew;
CREATE TABLE t_crew (
  crew_id               BIGINT(13) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '数据库主键ID{"max":13}',
  crew_internal_id      VARCHAR(15)                  DEFAULT NULL
  COMMENT '员工内部编号{"min":3}',
  crew_username         VARCHAR(20)         NOT NULL
  COMMENT '员工登陆账号{"min":3}',
  crew_branch_id        BIGINT(13) UNSIGNED NOT NULL
  COMMENT '员工所属的网点ID,与 t_client_branch.branch_id 字段关联',
  crew_email            VARCHAR(45)                  DEFAULT NULL
  COMMENT '电子邮箱 {"email":true}',
  crew_birthday         DATE                         DEFAULT NULL
  COMMENT '生日 {"pattern":"yyyy-MM-dd"]',
  crew_status           CHAR(7)             NOT NULL DEFAULT 'ENABLE'
  COMMENT '状态【ENABLE[启用]、DISABLE[禁用]】{"dataList":["ENABLE","DISABLE"]}',
  crew_create_timestamp DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间 {"pattern":"yyyy-MM-dd HH:mm:ss"}',
  crew_delete_flag      CHAR(1)             NOT NULL DEFAULT 'N'
  COMMENT '逻辑删除标志【N[正常]，Y[删除]】 {"dataList":["N","Y"]}',
  PRIMARY KEY (crew_id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '员工表';

DROP TABLE IF EXISTS t_client;
CREATE TABLE t_client (
  client_id               BIGINT(13) UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '数据库主键ID{"max":13}',
  client_internal_id      VARCHAR(15)         NOT NULL
  COMMENT '客户内部编号{"min":3}',
  client_name             VARCHAR(100)        NOT NULL
  COMMENT '客户名称{"min":3}',
  client_type             VARCHAR(6)          NOT NULL
  COMMENT '客户类型【CIT,CLIENT...】{"dataList":["CIT","CLIENT"]}',
  client_cit_id           BIGINT(13) UNSIGNED NOT NULL
  COMMENT '客户类型为[CLIENT]所属哪一个CIT的客户，与t_client.client_id关联，且类型为[CIT]；0为CIT',
  client_sector           VARCHAR(30)                  DEFAULT NULL
  COMMENT '客户所属领域,retailer,bank...{"dataList":["RETAILER","BANK"]}',
  client_tele_phone       VARCHAR(15)                  DEFAULT NULL
  COMMENT '客户联系电话',
  client_address          VARCHAR(150)                 DEFAULT NULL
  COMMENT '客户总部地址',
  client_phone            VARCHAR(20)                  DEFAULT NULL
  COMMENT '客户联系电话',
  client_longitude        VARCHAR(15)                  DEFAULT NULL
  COMMENT '客户地址经度',
  client_latitude         VARCHAR(15)                  DEFAULT NULL
  COMMENT '客户地址纬度',
  client_create_timestamp DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  client_create_by        VARCHAR(20)         NOT NULL
  COMMENT '创建人,与t_crew.crew_username字段关联',
  client_delete_flag      CHAR(1)             NOT NULL DEFAULT 'N'
  COMMENT '逻辑删除标志【N[正常]，Y[删除]】{"dataList":["Y","N"]}',
  PRIMARY KEY (client_id),
  UNIQUE KEY uk_client_internal_id (client_internal_id)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '客户基本信息表 Logic ID: client_company_id';

ALTER TABLE t_client
  ADD INDEX i_client_delete_flag (client_delete_flag);
SHOW INDEX FROM t_client;
