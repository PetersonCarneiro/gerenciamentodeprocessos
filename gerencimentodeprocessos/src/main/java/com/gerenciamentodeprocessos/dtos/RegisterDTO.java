package com.gerenciamentodeprocessos.dtos;

import com.gerenciamentodeprocessos.domain.user.UserType;

public record RegisterDTO(String firstName, String lastName, String login, String password, UserType userType) {
}
