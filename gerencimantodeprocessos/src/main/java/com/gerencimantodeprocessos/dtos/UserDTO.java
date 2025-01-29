package com.gerencimantodeprocessos.dtos;

import com.gerencimantodeprocessos.domain.user.UserType;

public record UserDTO(String id, String firstName, String lastName, String login, String password, UserType userType) {
}
