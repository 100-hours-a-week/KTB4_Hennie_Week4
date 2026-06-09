package com.hennie.springdatajpa.domain.user.dto.response;

import lombok.Getter;

@Getter
public class LoginResponseDto {
    private final String accessToken;

    public LoginResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }
}
