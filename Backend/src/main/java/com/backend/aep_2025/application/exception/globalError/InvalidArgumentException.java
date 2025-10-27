package com.backend.aep_2025.application.exception.globalError;

public class InvalidArgumentException extends GenericException{

    public InvalidArgumentException(Object arg, String message) {
        super("INVALID_ARGUMENT", arg, message);
    }
}
