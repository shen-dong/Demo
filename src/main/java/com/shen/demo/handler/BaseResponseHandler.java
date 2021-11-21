package com.shen.demo.handler;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.shen.demo.common.ConstUtil;
import com.shen.demo.dao.vo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shen
 * @date 2021/11/18 13:32
 */

@ControllerAdvice
@Slf4j
public class BaseResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        boolean isReturnTypeString = false;
        //unified result set is BaseResponse
        if (!(body instanceof BaseResponse)) {
            isReturnTypeString = body instanceof String;
            body = BaseResponse.success(body);
        }
        //check result whether happen exception
        boolean isFailed = !ConstUtil.SUCCESS_CODE.equals(((BaseResponse<?>) body).getCode());
        Throwable e = null;
        if (((BaseResponse<?>) body).getData() instanceof Throwable) {
            e = (Throwable) ((BaseResponse<?>) body).getData();
            ((BaseResponse<?>) body).setData(null);
        }
        printBaseLog(body, selectedContentType, request, isFailed, e);
        return isReturnTypeString ? JSONUtil.toJsonStr(body) : body;
    }

    /**
     * print base request-response log
     */
    private void printBaseLog(Object body, MediaType type, ServerHttpRequest request, boolean exceptionFlag, Throwable e) {
        HttpServletRequest httpServletRequest = ((ServletServerHttpRequest) request).getServletRequest();
        Object requestBody = httpServletRequest.getAttribute("requestBody");
        Object useTimeMillis = httpServletRequest.getAttribute("useTimeMillis");

        StringBuilder builder = new StringBuilder();
        //append request
        builder.append("request=[")
                .append("url:").append(request.getURI()).append(", ")
                .append("type:").append(request.getMethodValue()).append(", ")
                .append("timestamp:").append(DateUtil.date()).append(", ")
                .append("requestBody:").append(requestBody).append("] ");
        //append response
        builder.append("response=[")
                .append("ContentType:").append(type).append(", ")
                .append("response body:").append(body).append("] ");
        //append useTimeMillis
        builder.append("useTimeMillis=[")
                .append("useTimeMillis: ").append(useTimeMillis == null ? 0 : useTimeMillis)
                .append(" ms").append("] ");
        //append exception
        if (e != null) {
            builder.append("exception=[").append(e.getClass().getName()).append("]");
        }
        //print corresponding level log base on whether exception
        if (exceptionFlag) {
            log.error(builder.toString());
        } else {
            log.info(builder.toString());
        }
    }
}
