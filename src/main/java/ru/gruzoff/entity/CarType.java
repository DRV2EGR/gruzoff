package ru.gruzoff.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Car type.
 */
@Entity
@Table(name = "car_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarType extends BaseEntity {
    /**
     * The Price per hour.
     */
    protected float pricePerHour;
    /**
     * The Description.
     */
    protected String description;
}
