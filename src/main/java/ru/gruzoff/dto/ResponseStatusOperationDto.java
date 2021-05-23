package ru.gruzoff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Response status operation dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStatusOperationDto extends BasicResponce{
    /**
     * The Response.
     */
    protected String response;
}
