package com.gerenciamentodeprocessos.service;

import com.gerenciamentodeprocessos.domain.user.User;
import com.gerenciamentodeprocessos.dtos.UserRequestDTO;
import com.gerenciamentodeprocessos.dtos.UserResponseDTO;
import com.gerenciamentodeprocessos.mapper.UserMapper;
import com.gerenciamentodeprocessos.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository repository, UserMapper mapper){
        this.userRepository = repository;
        this.userMapper = mapper;
    }

    //CRUD
    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO){
        User user = userMapper.toEntity(userRequestDTO);
        return userMapper.toDTO(userRepository.save(user));
    }

    public List<UserResponseDTO> listAll(){
        return userRepository.findAll().stream()
                .map(userMapper::toDTO).toList();
    }

    public UserResponseDTO findByIdUser(String id){
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }

    public UserResponseDTO updateUser(String id, UserRequestDTO userRequestDTO){
        User user = userRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));

        user.setFirstName(userRequestDTO.firstName());
        user.setLastName(userRequestDTO.lastName());
        user.setLogin(userRequestDTO.login());
        user.setPassword(userRequestDTO.password());
        user.setUserType(userRequestDTO.userType());

        return userMapper.toDTO(userRepository.save(user));

    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
