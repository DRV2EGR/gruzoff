package ru.gruzoff.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/api/user/public", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserPublicController {

    @GetMapping("/public_user")
    public void getPublicUserInfo(@RequestParam long id) {

    }
}
