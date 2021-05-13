package ru.gruzoff.exception;

/**
 * The type Api exception.
 */
public abstract class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
