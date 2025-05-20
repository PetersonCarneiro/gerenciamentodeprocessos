package com.gerenciamentodeprocessos.dtos;

import com.gerenciamentodeprocessos.domain.user.UserType;

import java.util.UUID;

public record UserResponseDTO(UUID id, String firstName, String lastName, String login, UserType userType) {

}
