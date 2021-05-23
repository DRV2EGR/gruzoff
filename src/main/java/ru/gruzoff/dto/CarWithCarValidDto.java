package ru.gruzoff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Car with car valid dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarWithCarValidDto {
    /**
     * The Max weight.
     */
    protected int max_weight;
    /**
     * The Length.
     */
    protected int length;
    /**
     * The Width.
     */
    protected int width;
    /**
     * The Height.
     */
    protected int height;
    /**
     * The Size.
     */
    protected int size;
    /**
     * The Max people capacity.
     */
    protected int maxPeopleCapacity;

    /**
     * The Type.
     */
    protected CarTypeDto type;

    /**
     * The Gos nomber.
     */
    protected String gosNomber;

    /**
     * The Validity.
     */
    protected CarValidityDto validity;
}
