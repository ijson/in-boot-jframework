package com.ijson.framework.model;

import com.ijson.framework.exception.FrameworkBusinessException;
import com.ijson.framework.exception.FrameworkBusinessExceptionCode;
import com.ijson.framework.exception.FrameworkRuntimeException;
import lombok.Data;

/**
 * desc:
 * version: 6.7
 * Created by cuiyongxu on 2019/7/21 2:18 PM
 */
@Data
public class Result<T> {
    private int code;
    private String message;
    private T result;


    public Result(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }


    public Result() {

    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Result ok() {
        return new Result(0, "");
    }

    public static Result error(FrameworkBusinessException e) {
        return new Result(e.getErrorCode(), e.getMessage());
    }

    public static Result ok(String message) {
        return new Result(0, message);
    }

    public static Result error(FrameworkRuntimeException runtimeException) {
        return new Result(runtimeException.getErrorCode(), runtimeException.getMessage());
    }

    public static Result error(int code, String message) {
        return new Result(code, message);
    }

    public static Result error(FrameworkBusinessExceptionCode requestWayError) {
        return new Result(requestWayError.getCode(), requestWayError.getMessage());
    }
}
