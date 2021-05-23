package ru.gruzoff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Car validity dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarValidityDto {
    /**
     * The Is valid.
     */
    protected boolean isValid;
    /**
     * The Reason of crash.
     */
    protected String reasonOfCrash;
}
