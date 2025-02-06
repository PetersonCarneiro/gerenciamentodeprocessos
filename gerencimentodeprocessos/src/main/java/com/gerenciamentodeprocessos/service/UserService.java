package com.gerenciamentodeprocessos.service;

import com.gerenciamentodeprocessos.domain.user.User;
import com.gerenciamentodeprocessos.dtos.UserDTO;
import com.gerenciamentodeprocessos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //CRUD

    public UserDTO saveUser(UserDTO userDTO){
        User user = new User(userDTO);
        User newUser = userRepository.save(user);
        return new UserDTO(
                newUser.getId(),
                newUser.getFirstName(),
                newUser.getLastName(),
                newUser.getLogin(),
                newUser.getPassword(),
                newUser.getUserType()
        );
    }

    public List<UserDTO> listUser(){
        return userRepository.findAll().stream().map(user ->
                new UserDTO(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getLogin(),
                        user.getPassword(),
                        user.getUserType()
                )
        ).toList();
    }

    public Optional<UserDTO> findByIdUser(String id){
        return userRepository.findById(id).map(user ->
                new UserDTO(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getLogin(),
                        user.getPassword(),
                        user.getUserType())
        );
    }

    public UserDTO updateUser(String id, UserDTO userDTO){
        return userRepository.findById(id).map(user -> {
            user.setFirstName(userDTO.firstName());
            user.setLastName(userDTO.lastName());
            user.setLogin(userDTO.login());
            user.setPassword(userDTO.password());
            user.setUserType(userDTO.userType());
            User updateUser = userRepository.save(user);
            return new UserDTO(
                    updateUser.getId(),
                    updateUser.getFirstName(),
                    updateUser.getLastName(),
                    updateUser.getLogin(),
                    updateUser.getPassword(),
                    updateUser.getUserType()
            );
        }).orElseThrow(()-> new RuntimeException("User not found"));
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);

    }

    //Regras de negocio


}
