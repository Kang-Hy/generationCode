package com.khy.model;


public enum ErrorCode {

    OSS_ERROR(203, "对象存储异常"),
    DATA_ERROR(204, "数据异常"),
    DB_ERROR(205, "保存失败"),
    RPC_ERROR(206, "远程调用出错"),

    /*1000-2000 号段为用户及排班模块错误码*/
    LOGIN_FAIL(1001, "账号或密码错误"),

    /*5001-6000 号字段为附件错误码*/
    ATTACHMENT_BINDING(5001, "附件绑定失败,请重新绑定"),
    ATTACHMENT_NOT_BINDING(5002, "该附件未绑定，请重新选择"),
    ;


    private final int errorCode;
    private final String msg;

    ErrorCode(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMsg() {
        return msg;
    }
}
