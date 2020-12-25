package com.netflow.exception;

import com.netflow.common.BaseError;

/**
 * @author 汪培林
 * @data 2020-12-24  21:48:27
 */
public class DuplicatedException extends RuntimeException {

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    public DuplicatedException(){
        super();
    }

    public DuplicatedException(BaseError baseError){
        super(baseError.getResultCode());
        this.errorCode = baseError.getResultCode();
        this.errorMsg = baseError.getResultMsg();
    }

    public DuplicatedException(BaseError baseError, Throwable cause){
        super(baseError.getResultCode(),cause);
        this.errorCode = baseError.getResultCode();
        this.errorMsg = baseError.getResultMsg();
    }

    public DuplicatedException(String errorCode) {
        this.errorCode = errorCode;
    }

    public DuplicatedException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public DuplicatedException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode,cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
