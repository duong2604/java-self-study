package com.self_study.self_study.controller;

import com.self_study.self_study.dto.request.UserCreationRequest;
import com.self_study.self_study.dto.request.UserUpdateRequest;
import com.self_study.self_study.dto.response.ApiResponse;
import com.self_study.self_study.entity.User;
import com.self_study.self_study.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public User createNewUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.addNewUser(request);
    }

    @GetMapping
    public ApiResponse<List<User>> getAllUsers() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResult(userService.getUsers());
        return  apiResponse;
    }

    @GetMapping("{userId}")
    public User getUserById(@PathVariable String userId) {
        return userService.findUser(userId);
    }

    @PatchMapping("{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("{userId}")
    public String deleteUser(@PathVariable String userId) {
         return userService.deleteUser(userId);
    }


}
