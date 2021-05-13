package ru.gruzoff.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Conflict exception.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends ApiClientException {
    private static final long serialVersionUID = 1L;

    public ConflictException(String message) {
        super(message);
    }
}
