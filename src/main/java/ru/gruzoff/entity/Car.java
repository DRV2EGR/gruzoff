package ru.gruzoff.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Car.
 */
@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseEntity {
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
    @ManyToOne
    protected CarType type;

    /**
     * The Gos nomber.
     */
    protected String gosNomber;
}
