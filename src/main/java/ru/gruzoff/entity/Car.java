package ru.gruzoff.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cars")
@Data
public class Car extends BaseEntity {
    protected int pricePerHour;
    protected int max_weight;
    protected int length;
    protected int width;
    protected int height;
    protected int size;
    protected int maxPeopleCapacity;

    protected String gosNomber;
}