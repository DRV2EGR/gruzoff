package ru.gruzoff.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Likes.
 */
@Entity
@Table(name ="user_likes")
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public class Likes extends BaseEntity{
    /**
     * The User from.
     */
    @ManyToOne
    @JoinColumn(name = "user_id_from")
    protected User user_from;

    /**
     * The User to.
     */
    @ManyToOne
    @JoinColumn(name = "user_id_to")
    protected User user_to;
}
