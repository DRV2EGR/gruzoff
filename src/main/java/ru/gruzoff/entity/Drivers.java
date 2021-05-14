package ru.gruzoff.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="drivers")
@Data
@NoArgsConstructor
public class Drivers extends BaseEntity implements Serializable {
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinColumn(name = "cars", referencedColumnName = "id")
    protected List<Car> cars;

}
