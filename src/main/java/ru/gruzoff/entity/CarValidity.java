package ru.gruzoff.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cars_validity")
@Data
public class CarValidity extends BaseEntity {
    protected boolean isValid;

    protected String reasonOfCrash;

    @OneToOne
    @JoinColumn(name = "car_id")
    protected Car carId;
}
