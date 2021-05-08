package ru.gruzoff.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/api/user/private", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserPrivateController {

    @GetMapping("/orders")
    public void getAllOrders() {

    }

    @PostMapping("/orders")
    public void getFilterredOrders() {

    }

    @GetMapping("/set_like")
    public void setLike(@RequestParam long id_to) {

    }

    @PostMapping("/set_comment")
    public void setComment() {

    }

    @GetMapping("/all_user")
    public void getAllUserInfo(@RequestParam long id) {

    }

    @PutMapping("/user")
    public void changeUserInfo() {

    }

    @DeleteMapping("/user")
    public void deleteUser() {

    }
}
