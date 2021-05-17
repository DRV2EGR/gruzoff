package ru.gruzoff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarWithCarValidDto {
    protected int max_weight;
    protected int length;
    protected int width;
    protected int height;
    protected int size;
    protected int maxPeopleCapacity;

    protected CarTypeDto type;

    protected String gosNomber;

    protected CarValidityDto validity;
}
