package ru.gruzoff.dto;

import lombok.Data;

@Data
public class CarDto {
    protected int max_weight;
    protected int length;
    protected int width;
    protected int height;
    protected int size;
    protected int maxPeopleCapacity;

    protected String gosNomber;
}
