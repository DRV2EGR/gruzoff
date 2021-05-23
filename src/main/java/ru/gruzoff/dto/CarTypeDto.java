package ru.gruzoff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Car type dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarTypeDto {
    /**
     * The Id.
     */
    protected long id;
    /**
     * The Price per hour.
     */
    protected float pricePerHour;
    /**
     * The Description.
     */
    protected String description;
}
