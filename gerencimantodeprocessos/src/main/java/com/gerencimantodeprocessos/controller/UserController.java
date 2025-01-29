package com.gerencimantodeprocessos.controller;

import com.gerencimantodeprocessos.dtos.UserDTO;
import com.gerencimantodeprocessos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDTO newUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @GetMapping
    public List<UserDTO> listUser(){
        return userService.listUser();
    }

    @GetMapping("/{id}")
    public Optional<UserDTO> findByUserId(@PathVariable String id){
        return userService.findByIdUser(id);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable String id, @RequestBody UserDTO userDTO){
        return  userService.updateUser(id,userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }

}
