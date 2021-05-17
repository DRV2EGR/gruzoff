package ru.gruzoff.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseEntity {
    protected int max_weight;
    protected int length;
    protected int width;
    protected int height;
    protected int size;
    protected int maxPeopleCapacity;

    @ManyToOne
    protected CarType type;

    protected String gosNomber;
}
