package com.ijson.framework.exception;

public class FrameworkRuntimeException extends RuntimeException {


    private int errorCode = FrameworkBusinessExceptionCode.SYSTEM_ERROR.getCode();

    public FrameworkRuntimeException() {
    }

    public FrameworkRuntimeException(Throwable throwable) {
        super(throwable);
    }

    public FrameworkRuntimeException(int errorCode, String message) {
        this(message, false);
        this.errorCode = errorCode;
    }

    private FrameworkRuntimeException(String message, boolean stackTrace) {
        super(message, null, true, stackTrace);
    }

    public int getErrorCode() {
        return errorCode;
    }
}
