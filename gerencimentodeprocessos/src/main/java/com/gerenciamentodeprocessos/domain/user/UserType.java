package com.gerenciamentodeprocessos.domain.user;

public enum UserType {
    ADMIN("admin"),
    USER("user");

    private String type;

    UserType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
