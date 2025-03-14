package com.gerenciamentodeprocessos.controller;

import com.gerenciamentodeprocessos.dtos.UserRequestDTO;
import com.gerenciamentodeprocessos.dtos.UserResponseDTO;
import com.gerenciamentodeprocessos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponseDTO newUser(@RequestBody UserRequestDTO userRequestDTO){
        return userService.saveUser(userRequestDTO);
    }

    @GetMapping
    public List<UserResponseDTO> listUser(){
        return userService.listAll();
    }

    @GetMapping("/{id}")
    public UserResponseDTO findByUserId(@PathVariable String id){
        return userService.findByIdUser(id);
    }

    @PutMapping("/{id}")
    public UserResponseDTO updateUser(@PathVariable String id, @RequestBody UserRequestDTO userRequestDTO){
        return  userService.updateUser(id, userRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }
}
