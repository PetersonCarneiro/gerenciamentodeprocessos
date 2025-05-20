package com.gerenciamentodeprocessos.controller;

import com.gerenciamentodeprocessos.domain.user.User;
import com.gerenciamentodeprocessos.domain.user.UserType;
import com.gerenciamentodeprocessos.dtos.AuthenticationDTO;

import com.gerenciamentodeprocessos.dtos.LoginResponseDTO;
import com.gerenciamentodeprocessos.dtos.RegisterDTO;
import com.gerenciamentodeprocessos.infra.security.TokenService;
import com.gerenciamentodeprocessos.repositories.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login (@NotNull @RequestBody AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(),data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User)auth.getPrincipal());

        User user = (User) auth.getPrincipal();

        return  ResponseEntity.ok(new LoginResponseDTO(token,user.getId()));

    }

    @PostMapping("/register")
    public ResponseEntity register ( @RequestBody  RegisterDTO data){
        if(this.repository.findByLogin(data.login())!= null){
            return ResponseEntity.badRequest().build();
        };

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.firstName(),data.lastName(), data.login(), encryptedPassword, data.userType());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
