package com.blogApp.controller;

import com.blogApp.payload.ApiResponse;
import com.blogApp.payload.UserDto;
import com.blogApp.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
    {
        UserDto createUserDto=this.userService.createUser(userDto);
        return new ResponseEntity<UserDto>(createUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable Integer userId)
    {
        UserDto updateUser=this.userService.updateUser(userDto,userId);
        return  ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId)
    {
        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Successfully deleted!", true),HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUser()
    {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId)
    {
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }



}
