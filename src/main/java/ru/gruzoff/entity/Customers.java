package ru.gruzoff.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="customers")
@Data
@NoArgsConstructor
public class Customers implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
