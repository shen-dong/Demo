package com.shen.demo.common;

/**
 * @author shen
 * @date 2021/11/18 11:03
 */
public class ConstUtil {
    //response msg
    public static final String SERVER_ERROR_MSG = "some errors was happened";
    public static final String INSERT_SUCCESS_MSG = "insert success";
    public static final String INSERT_FAIL_MSG = "insert fail";
    public static final String DELETE_SUCCESS_MSG = "delete success";
    public static final String NO_ITEM_DELETE_MSG = "no item with a corresponding name, no item were delete";
    public static final String REPEAT_NAME_MSG = "this same name item is already existed";
    public static final String NOT_EXISTED_MSG = "the id is not existed";
    public static final String UPDATE_CONTENT_EMPTY_MSG = "all update param is empty";
    public static final String REQUEST_EMPTY_MSG = "request param is empty";
    public static final String UPDATE_SUCCESS_MSG = "update item success";


    //return status code
    public static final Integer SUCCESS_CODE = 200;
    public static final Integer DEFAULT_EXCEPTION_ERROR = 30000;
    public static final Integer REQUEST_PARAM_ERROR = 30101;
    public static final Integer REQUEST_EMPTY_CODE = 30102;
}
