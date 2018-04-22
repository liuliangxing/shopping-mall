package com.jbt.shopping.common.exceptions;

import com.destinyboy.jbt.exceptions.ProjectException;

public class BusinessException extends ProjectException {
    public BusinessException() {
        super();
    }

    public BusinessException(BusinessCodeConfig businessCodeConfig) {
        super(businessCodeConfig.getCode(), businessCodeConfig.getMessage());
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    protected BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
