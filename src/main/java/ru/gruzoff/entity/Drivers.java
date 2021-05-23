package ru.gruzoff.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Drivers.
 */
@Entity
@Table(name ="drivers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drivers extends BaseEntity implements Serializable {
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * The Cars.
     */
    @ManyToMany
    @JoinColumn(name = "cars", referencedColumnName = "id")
    protected List<Car> cars;

}
