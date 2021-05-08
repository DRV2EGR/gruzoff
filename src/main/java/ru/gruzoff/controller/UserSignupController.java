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
@RequestMapping("/api/signup")
public class UserSignupController {
    /**
     * The User service.
     */
    @Autowired
    UserService userService;

    @PostMapping("/customer")
    public ResponseEntity<UserDto> signUpNewCustomer(@RequestBody UserDtoPayload userDtoPayload) {
        User newUser = userService.createNewUserAndFillBasicFields(userDtoPayload);

        UserDto resp = userService.registerNewCustomer(newUser);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/driver")
    public ResponseEntity<UserDto> signUpNewDriver(@RequestBody UserDtoPayload userDtoPayload) {
        User newUser = userService.createNewUserAndFillBasicFields(userDtoPayload);

        UserDto resp = userService.registerNewDriver(newUser);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/loader")
    public ResponseEntity<UserDto> signUpNewLoader(@RequestBody UserDtoPayload userDtoPayload) {
        User newUser = userService.createNewUserAndFillBasicFields(userDtoPayload);

        UserDto resp = userService.registerNewLoader(newUser);
        return ResponseEntity.ok(resp);
    }



    //  TODO:
//    @PostMapping("/admin")

}
