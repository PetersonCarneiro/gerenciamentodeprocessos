package com.gerencimentodeprocessos.dtos;

import com.gerencimentodeprocessos.domain.user.UserType;

public record UserDTO(String id, String firstName, String lastName, String login, String password, UserType userType) {
}
