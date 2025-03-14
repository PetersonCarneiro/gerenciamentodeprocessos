package com.gerenciamentodeprocessos.domain.user;

public enum UserType {
    COMMUN("admin"),
    ADMIN("user");

    private String type;

    UserType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
