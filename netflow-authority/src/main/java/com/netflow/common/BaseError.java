package com.netflow.common;

public interface BaseError {

    /**
     * 获取错误码
     * @return
     */
    String getResultCode();

    /**
     * 获取错误信息
     * @return
     */
    String getResultMsg();
}
