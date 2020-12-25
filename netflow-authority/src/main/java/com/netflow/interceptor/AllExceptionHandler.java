package com.netflow.interceptor;

import com.netflow.common.ErrorMsg;
import com.netflow.exception.DuplicatedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 汪培林
 * @data 2020-12-24  21:34:33
 */
@RestControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(value = DuplicatedException.class)
    public ErrorMsg exceptionHandler(HttpServletRequest request,DuplicatedException e){
        return new ErrorMsg(e.getErrorCode(),e.getErrorMsg());
    }
}
