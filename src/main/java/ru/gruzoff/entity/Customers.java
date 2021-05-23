package ru.gruzoff.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Customers.
 */
@Entity
@Table(name ="customers")
@Data
@NoArgsConstructor
public class Customers extends BaseEntity implements Serializable {
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
