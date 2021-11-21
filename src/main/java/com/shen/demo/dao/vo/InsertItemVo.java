package com.shen.demo.dao.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author shen
 * @date 2021/11/18 16:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertItemVo {
    @NotNull
    private String name;
    @NotNull
    private BigDecimal price;

    private String data;
}
