package ru.gruzoff.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Adress.
 */
@Entity
@Table(name = "order_adresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adress extends BaseEntity {
    /**
     * The Country.
     */
    protected String country;
    /**
     * The Town.
     */
    protected String town;
    /**
     * The Street.
     */
    protected String street;
    /**
     * The House nomber.
     */
    protected String houseNomber;
    /**
     * The Extra house definition.
     */
    protected String extraHouseDefinition;

    /**
     * The Latitude.
     */
    protected float latitude;
    /**
     * The Longitude.
     */
    protected float longitude;

    @Override
    public String toString() {
        return country + ',' + town + ',' + street + ',' + houseNomber + ',' + extraHouseDefinition;
    }
}
