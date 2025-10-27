package com.backend.aep_2025.application.exception.globalError;

import lombok.Getter;
import org.apache.logging.log4j.message.Message;

@Getter
public abstract class GenericException extends RuntimeException {
    private final String errorCode;
    private final Object arg;


    protected GenericException(String errorCode, Object arg,String message) {
        super(message);
        this.errorCode = errorCode;
        this.arg = arg;
    }
}
