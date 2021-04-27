package ru.gruzoff.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type User.
 */
@Entity
@Table(name ="users")
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity{
    /**
     * The First name.
     */
    @Column(name = "first_name")
    protected String firstName;

    /**
     * The Second name.
     */
    @Column(name = "second_name")
    protected String secondName;

    /**
     * The Last name.
     */
    @Column(name = "last_name")
    protected String lastName;

    /**
     * The Username.
     */
    @Column(name = "username")
    protected String username;

    /**
     * The Email.
     */
    @Column(name = "email", nullable = false)
    protected String email;

    /**
     * The Password.
     */
    @Column(name = "password", nullable = false)
    protected String password;

    /**
     * The Phone number.
     */
    @Column(name = "phone_number")
    protected String phoneNumber;

    /**
     * The Activation code.
     */
    @Column(name = "activation_code")
    protected String activationCode;

    /**
     * The Time of account creation.
     */
    @Column(name = "time_of_account_creation")
    protected LocalDateTime timeOfAccountCreation;

    /**
     * The User profile image url.
     */
    @Column(name = "user_profile_image_url", nullable = true)
    protected String userProfileImageUrl;

    /**
     * The Role.
     */
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    protected Role role;

    @ManyToMany
    @JoinColumn(name = "orders", referencedColumnName = "id")
    protected List<Order> orders;


    /**
     * Instantiates a new User.
     *
     * @param id       the id
     * @param username the username
     */
    public User(long id, String username) {
        this.setId(id);
        this.setUsername(username);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
