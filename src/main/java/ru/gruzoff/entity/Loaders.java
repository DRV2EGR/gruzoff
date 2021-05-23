package ru.gruzoff.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Loaders.
 */
@Entity
@Table(name ="loaders")
@Data
@NoArgsConstructor
public class Loaders extends BaseEntity implements Serializable {
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
