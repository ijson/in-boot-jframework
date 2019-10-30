package com.ijson.framework.exception;

public class FrameworkBusinessException extends FrameworkRuntimeException {

    public FrameworkBusinessException(FrameworkBusinessExceptionCode code, String extensionMessage) {
        super(code.getCode(), extensionMessage);
    }

    public FrameworkBusinessException(Integer code, String extensionMessage) {
        super(code, extensionMessage);
    }

    public FrameworkBusinessException(FrameworkBusinessExceptionCode code) {
        super(code.getCode(), code.getMessage());
    }

}