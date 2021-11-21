package com.shen.demo.handler;

import com.shen.demo.common.ConstUtil;
import com.shen.demo.dao.vo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shen
 * @date 2021/11/18 13:53
 */

@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @Value("${custom.isPrintExceptionStack}")
    private boolean isPrintExceptionStack;

    @ExceptionHandler(Throwable.class)
    public BaseResponse<Object> handleThrowable(Throwable e) {
        if (isPrintExceptionStack) {
            e.printStackTrace();
        }
        String msg = ConstUtil.SERVER_ERROR_MSG + " (" + e.getMessage() + ")";
        return BaseResponse.fail(ConstUtil.DEFAULT_EXCEPTION_ERROR, msg, e);
    }
}
