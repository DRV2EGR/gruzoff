package ru.gruzoff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    protected int max_weight;
    protected int length;
    protected int width;
    protected int height;
    protected int size;
    protected int maxPeopleCapacity;

    protected int type;

    protected String gosNomber;
}
