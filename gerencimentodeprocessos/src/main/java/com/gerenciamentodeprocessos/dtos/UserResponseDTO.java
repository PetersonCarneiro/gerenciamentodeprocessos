package com.gerenciamentodeprocessos.dtos;

import com.gerenciamentodeprocessos.domain.user.UserType;

public record UserResponseDTO(String id, String firstName, String lastName, String login,UserType userType) {

}
