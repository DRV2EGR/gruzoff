package ru.gruzoff.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_adresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adress extends BaseEntity {
    protected String country;
    protected String town;
    protected String street;
    protected String houseNomber;
    protected String extraHouseDefinition;

    protected float latitude;
    protected float longitude;

    @Override
    public String toString() {
        return country + ',' + town + ',' + street + ',' + houseNomber + ',' + extraHouseDefinition;
    }
}
