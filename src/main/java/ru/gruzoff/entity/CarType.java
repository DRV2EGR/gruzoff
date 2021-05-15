package ru.gruzoff.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarType extends BaseEntity {
    protected float pricePerHour;
    protected String description;
}
