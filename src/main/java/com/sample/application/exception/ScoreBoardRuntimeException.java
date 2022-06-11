package com.sample.application.exception;


public class ScoreBoardRuntimeException extends RuntimeException {

    public ScoreBoardRuntimeException(String message) {
        super(message);
    }

    public ScoreBoardRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
