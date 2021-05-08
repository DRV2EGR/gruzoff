package ru.gruzoff.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.gruzoff.dto.UserDto;
import ru.gruzoff.entity.User;
import ru.gruzoff.payload.BasicPayload;
import ru.gruzoff.repository.RoleRepository;
import ru.gruzoff.repository.UserRepository;

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

    private User createNewUserAndFillBasicFields(BasicPayload basicPayload) {
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
}
