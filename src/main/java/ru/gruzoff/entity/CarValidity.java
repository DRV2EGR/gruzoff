package ru.gruzoff.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Car validity.
 */
@Entity
@Table(name = "cars_validity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarValidity extends BaseEntity {
    /**
     * The Is valid.
     */
    protected boolean isValid;

    /**
     * The Reason of crash.
     */
    protected String reasonOfCrash;

    /**
     * The Car id.
     */
    @OneToOne
    @JoinColumn(name = "car_id")
    protected Car carId;
}
