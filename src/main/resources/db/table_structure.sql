CREATE TABLE `item`
(
    `id`          int(11)        NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `name`        varchar(128)   NOT NULL COMMENT '名称',
    `price`       decimal(10, 2) NOT NULL COMMENT '价格',
    `data`        varchar(256)   NOT NULL DEFAULT '' COMMENT '数据信息',
    `update_time` datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_time` datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`name`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;