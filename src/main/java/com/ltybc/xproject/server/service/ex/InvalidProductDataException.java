package com.ltybc.xproject.server.service.ex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidProductDataException extends RuntimeException {

    public InvalidProductDataException() {
    }

    public InvalidProductDataException(String message) {
        super(message);
    }

    public InvalidProductDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidProductDataException(Throwable cause) {
        super(cause);
    }

    public InvalidProductDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
