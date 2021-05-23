package ru.gruzoff.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Comments.
 */
@Entity
@Table(name ="comments")
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Comments extends BaseEntity{
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

    /**
     * The Rating.
     */
    protected int rating;

    /**
     * The Comment text.
     */
    @Column(columnDefinition = "TEXT")
    protected String commentText;

}
