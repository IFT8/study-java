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
