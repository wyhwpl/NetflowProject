package com.netflow.common;

public enum BaseErrorEnum implements BaseError {

    DuplicateUser("-1","该用户已存在"),
    DuplicateRole("-1","该角色已存在"),
    DuplicateResource("-1","当前应用下该应用资源已存在")
    ;


    private String resultCode;
    private String resultMsg;

    BaseErrorEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }
}
