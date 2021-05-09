package ru.gruzoff.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Not found exception.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends ApiClientException {
    private static final long serialVersionUID = 1L;
}