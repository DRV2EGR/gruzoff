package ru.gruzoff.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gruzoff.dto.LikeDto;
import ru.gruzoff.dto.UserPublicDto;
import ru.gruzoff.entity.Likes;
import ru.gruzoff.service.ClassToDtoService;
import ru.gruzoff.service.UserService;

/**
 * The type User public controller.
 */
@RestController
@RequestMapping(value = "/v1/api/user/public", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserPublicController {
    /**
     * The User service.
     */
    @Autowired
    UserService userService;

    /**
     * The Class to dto service.
     */
    @Autowired
    ClassToDtoService classToDtoService;

    /**
     * Gets public user info by id.
     *
     * @param id the id
     * @return the public user info by id
     */
    @GetMapping("/user_by_id")
    public ResponseEntity<UserPublicDto> getPublicUserInfoById(@RequestParam long id) {
        return ResponseEntity.ok(
                classToDtoService.convertUserToUserPublicDto(
                    userService.findUserById(id)
                )
        );
    }

    /**
     * Gets public user info by username.
     *
     * @param username the username
     * @return the public user info by username
     */
    @GetMapping("/user_by_username")
    public ResponseEntity<UserPublicDto> getPublicUserInfoByUsername(@RequestParam String username) {
        return ResponseEntity.ok(
                classToDtoService.convertUserToUserPublicDto(
                        userService.findUserByUsername(username)
                )
        );
    }

    /**
     * Gets user recieved likes.
     *
     * @param id the id
     * @return the user recieved likes
     */
    @GetMapping("/get_recieved_likes_by_id")
    public ResponseEntity<List<LikeDto>> getUserRecievedLikes(@RequestParam long id) {
        List<LikeDto> lstLikes = new ArrayList<>();
        for (Likes like : userService.findUserById(id).getRecievedLikes())
            lstLikes.add(new LikeDto(
                    userService.convertUserToUserDto(like.getUser_from()),
                    userService.convertUserToUserDto(like.getUser_to())
            ));
        return ResponseEntity.ok(lstLikes);
    }
}
