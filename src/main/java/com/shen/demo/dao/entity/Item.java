package com.shen.demo.dao.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;

@Table(name = "item")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Integer id;

    private String name;

    private BigDecimal price;

    private String data;

    @Column(name = "update_time", updatable = false, insertable = false)
    private Date updateTime;

    @Column(name = "create_time", updatable = false, insertable = false)
    private Date createTime;
}
