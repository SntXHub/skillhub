package com.skillhub.skillhub.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String name;
    private String lastName;
    private String email;
    private String password;
}
