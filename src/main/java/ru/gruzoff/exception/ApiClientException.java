package ru.gruzoff.exception;

/**
 * The type Api client exception.
 */
public abstract class ApiClientException extends ApiException {
    public ApiClientException(String message) {
        super(message);
    }
}
