package com.gerenciamentodeprocessos.mapper;

import com.gerenciamentodeprocessos.domain.user.User;
import com.gerenciamentodeprocessos.dtos.UserRequestDTO;
import com.gerenciamentodeprocessos.dtos.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserRequestDTO dto){
        return new User(
                dto.firstName(),
                dto.lastName(),
                dto.login(),
                dto.password(),
                dto.userType()
        );
    }

    public UserResponseDTO toDTO(User user){
        return new UserResponseDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getLogin(),
                user.getUserType()
        );
    }
}
