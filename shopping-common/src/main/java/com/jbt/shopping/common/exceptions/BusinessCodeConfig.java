package com.jbt.shopping.common.exceptions;

public enum BusinessCodeConfig {
    BE_ERROR_1001("BE1001", "用户或密码错误"),
    BE_ERROR_1002("BE1002", "用户已失效，请联系管理员"),
    BE_ERROR_1003("BE1003", "原密码错误"),
    BE_ERROR_1004("BE1004", "用户名已存在"),
    BE_ERROR_1005("BE1005", "广告位不存在"),
    BE_ERROR_1006("BE1006", "用户不存在"),
    BE_ERROR_1007("BE1007", "新密码不能与原密码相同"),
    BE_ERROR_1008("BE1008", "Token不存在或已失效"),
    BE_ERROR_1009("BE1009", "该用户不存在")
    ;

    private String code;
    private String message;
    
    BusinessCodeConfig(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
