package com.shen.demo.dao.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shen
 * @date 2021/11/18 20:16
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseRequest<T> {
    private String requestId;
    private T data;
}
