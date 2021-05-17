package ru.gruzoff.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="comments")
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Comments extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "user_id_from")
    protected User user_from;

    @ManyToOne
    @JoinColumn(name = "user_id_to")
    protected User user_to;

    protected int rating;

    @Column(columnDefinition = "TEXT")
    protected String commentText;

}
