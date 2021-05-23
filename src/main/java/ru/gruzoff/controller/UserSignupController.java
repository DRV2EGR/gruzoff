package ru.gruzoff.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gruzoff.dto.UserDto;
import ru.gruzoff.entity.User;
import ru.gruzoff.payload.UserDtoPayload;
import ru.gruzoff.service.UserService;

/**
 * The type User signup controller.
 */
@Controller
@RequestMapping("/v1/api/signup")
public class UserSignupController {
    /**
     * The User service.
     */
    @Autowired
    UserService userService;

    /**
     * Sign up new customer response entity.
     *
     * @param userDtoPayload the user dto payload
     * @return the response entity
     */
    @PostMapping("/customer")
    public ResponseEntity<UserDto> signUpNewCustomer(@RequestBody UserDtoPayload userDtoPayload) {
        UserDto resp = userService.registerNewCustomer(userDtoPayload);
        return ResponseEntity.ok(resp);
    }

    /**
     * Sign up new driver response entity.
     *
     * @param userDtoPayload the user dto payload
     * @return the response entity
     */
    @PostMapping("/driver")
    public ResponseEntity<UserDto> signUpNewDriver(@RequestBody UserDtoPayload userDtoPayload) {
        UserDto resp = userService.registerNewDriver(userDtoPayload);
        return ResponseEntity.ok(resp);
    }

    /**
     * Sign up new loader response entity.
     *
     * @param userDtoPayload the user dto payload
     * @return the response entity
     */
    @PostMapping("/loader")
    public ResponseEntity<UserDto> signUpNewLoader(@RequestBody UserDtoPayload userDtoPayload) {
        UserDto resp = userService.registerNewLoader(userDtoPayload);
        return ResponseEntity.ok(resp);
    }


}
