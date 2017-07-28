DROP DATABASE IF EXISTS db_products;
CREATE DATABASE IF NOT EXISTS db_products
  DEFAULT CHARSET utf8
  COLLATE utf8_general_ci;
USE db_products;

CREATE TABLE products (
  pid        BIGINT(13) NOT NULL                                                 AUTO_INCREMENT,
  name       VARCHAR(200)                                                        DEFAULT NULL,
  type       VARCHAR(200)                                                        DEFAULT NULL,
  price      DOUBLE                                                              DEFAULT NULL,
  createTime TIMESTAMP                                                           DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (pid)
)