package org.example.boot.validation.controller;

import org.example.boot.validation.exception.CustomIllegalException;
import org.example.boot.validation.model.User;
import org.example.boot.validation.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dragon
 * @date 2021/11/20
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) throws CustomIllegalException {
       return userService.validateAndSave(user);
    }
}
