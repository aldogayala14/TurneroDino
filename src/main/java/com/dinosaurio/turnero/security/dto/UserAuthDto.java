package com.dinosaurio.turnero.security.dto;

import lombok.Data;

@Data
public class UserAuthDto {
    private String username;
    private String password;
}