package com.shen.demo.dao.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> BaseResponse<T> success(T t) {
        return new BaseResponse<>(200, "success", t);
    }

    public static <T> BaseResponse<T> fail(int errorCode, String msg, T t) {
        return new BaseResponse<>(errorCode, msg, t);
    }
}
