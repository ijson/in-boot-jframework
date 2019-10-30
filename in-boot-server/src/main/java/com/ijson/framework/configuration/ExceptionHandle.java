package com.ijson.framework.configuration;

import com.ijson.framework.exception.FrameworkBusinessException;
import com.ijson.framework.exception.FrameworkBusinessExceptionCode;
import com.ijson.framework.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * desc: 异常处理器
 * version: 6.7
 * Created by cuiyongxu on 2019/7/28 9:30 PM
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof FrameworkBusinessException) {
            FrameworkBusinessException blogBusinessException = (FrameworkBusinessException) e;
            return Result.error(blogBusinessException);
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            return Result.error(FrameworkBusinessExceptionCode.REQUEST_WAY_ERROR);
        } else {
            log.error("【系统异常】{}", e);
            return Result.error(FrameworkBusinessExceptionCode.SYSTEM_ERROR);
        }
    }

}
