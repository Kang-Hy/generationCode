package com.khy.model;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 响应信息主体
 */
@Slf4j
public class R<T> implements Serializable {

    public static final int SUCCESS = 200;

    public static final int FAIL = 500;

    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    private T data;


    public static <T> R<T> ok() {
        return restResult(null, SUCCESS, null);
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, SUCCESS, null);
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(data, SUCCESS, msg);
    }

    public static <T> R<T> fail() {
        return restResult(null, FAIL, null);
    }

    public static <T> R<T> fail(T data) {
        return restResult(data, FAIL, null);
    }

    public static <T> R<T> fail(String msg) {
        return restResult(null, FAIL, msg);
    }


    public static <T> R<T> fail(int code, String msg) {
        log.info(msg);
        return restResult(null, code, msg);
    }

    public static <T> R<T> fail(ErrorCode errorCode) {
        return restResult(null, errorCode.getErrorCode(), errorCode.getMsg());
    }


    private static <T> R<T> restResult(T data, int code, String msg) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }


    public boolean checkSuccess() {
        return code == SUCCESS;
    }

    public boolean checkFail() {
        return code == FAIL;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
