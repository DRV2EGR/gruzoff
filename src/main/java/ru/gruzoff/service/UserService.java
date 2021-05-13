package ru.gruzoff.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.gruzoff.dto.UserDto;
import ru.gruzoff.entity.Customers;
import ru.gruzoff.entity.Likes;
import ru.gruzoff.entity.Order;
import ru.gruzoff.entity.User;
import ru.gruzoff.exception.ConflictException;
import ru.gruzoff.exception.NotFoundException;
import ru.gruzoff.exception.UserNotFoundExeption;
import ru.gruzoff.payload.BasicPayload;
import ru.gruzoff.payload.UserDtoPayload;
import ru.gruzoff.repository.*;

/**
 * The type User service.
 */
@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderReposiory orderReposiory;

    @Autowired
    private LikesRepository likesRepository;

    /**
     * The B crypt password encoder.
     */
    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Password encoder b crypt password encoder.
     *
     * @return the b crypt password encoder
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    /**
     * Find by username optional.
     *
     * @param username the username
     * @return the optional
     */
    public Optional<User> findByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent())
        log.info("User " + optionalUser.get().toString() + "found by username " + username);
        else log.info("User with username '" + username + "' not found.");
        return userRepository.findByUsername(username);
    }

    /**
     * Find by id optional.
     *
     * @param userId the user id
     * @return the optional
     */
    public Optional<User> findById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent())
            log.info("User " + optionalUser.get().toString() + "found by id " + userId);
        else log.info("User with id '" + userId + "' not found.");
        return userRepository.findById(userId);
    }

    public User createNewUserAndFillBasicFields(BasicPayload basicPayload) {
        User user = new User();

        user.setUsername(basicPayload.getUsername());
        user.setEmail(basicPayload.getEmail());
        user.setFirstName(basicPayload.getFirstName());
        user.setLastName(basicPayload.getLastName());
        user.setPhoneNumber(basicPayload.getPhoneNumber());
        user.setSecondName(basicPayload.getSecondName());

        return user;
    }


    /**
     * Find by email optional.
     *
     * @param email the email
     * @return the optional
     */
    public Optional<User> findByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent())
            log.info("User " + optionalUser.get().toString() + "found by email " + email);
        else log.info("User with email '" + email + "' not found.");
        return userRepository.findByEmail(email);
    }

    public UserDto registerNewCustomer(UserDtoPayload userDtoPayload) {
        User user = createNewUserAndFillBasicFields(userDtoPayload);
        Customers customers = new Customers();

        user.setRole(roleRepository.findById(2L).get());
        String encodedPassword = bCryptPasswordEncoder.encode(userDtoPayload.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);
        customers.setUser(user);

        customerRepository.save(customers);
        return convertUserToUserDto(user);
    }

    public UserDto registerNewDriver(UserDtoPayload userDtoPayload) {
        User user = createNewUserAndFillBasicFields(userDtoPayload);
        Customers customers = new Customers();

        user.setRole(roleRepository.findById(3L).get());
        String encodedPassword = bCryptPasswordEncoder.encode(userDtoPayload.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);
        customers.setUser(user);

        customerRepository.save(customers);
        return convertUserToUserDto(user);
    }

    public UserDto registerNewLoader(UserDtoPayload userDtoPayload) {
        User user = createNewUserAndFillBasicFields(userDtoPayload);
        Customers customers = new Customers();

        user.setRole(roleRepository.findById(4L).get());
        String encodedPassword = bCryptPasswordEncoder.encode(userDtoPayload.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);
        customers.setUser(user);

        customerRepository.save(customers);
        return convertUserToUserDto(user);
    }


    public UserDto convertUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setRole(user.getRole().getName());
        userDto.setSecondName(user.getSecondName());
        userDto.setPhoneNumber(user.getPhoneNumber());

        return userDto;
    }

    public Order getUsersOrderByOrderId(User user, long orderid) {
        Order order = orderReposiory.findByIdAndCustomerId(
                orderid,
                customerRepository.findByUser(user).orElseThrow(
                        () -> new UserNotFoundExeption("")
                )
        ).orElseThrow(
                () -> new NotFoundException("")
        );

        return order;
    }

    public void setLike(User usr_from, long id_to) {
        User usr_to = userRepository.findById(id_to).orElseThrow(
                () -> new UserNotFoundExeption("")
        );

        Likes like = new Likes();
        like.setUser_from(usr_from);
        like.setUser_to(usr_to);

        // SAVE TRANSISTENT
        likesRepository.save(like);

        usr_from.getPuttedLikes().add(like);
        userRepository.save(usr_from);
        usr_to.getRecievedLikes().add(like);
        userRepository.save(usr_to);
    }

    public UserDto changeInfo(User user, UserDtoPayload userDtoPayload) throws NoSuchFieldException, IllegalAccessException {
        System.out.println(userDtoPayload.getClass().getDeclaredFields().length);
        for (Field obj : userDtoPayload.getClass().getDeclaredFields()) {
            Field field = user.getClass().getDeclaredField(obj.getName());
            field.setAccessible(true);
            Field field1 = userDtoPayload.getClass().getDeclaredField(obj.getName());
            field1.setAccessible(true);

            if (field1.get(userDtoPayload) != null) {
                field.set(user, (String) field1.get(userDtoPayload));
            }
        }

        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new ConflictException("Incorrect value");
        }

        return convertUserToUserDto(user);
    }
}
