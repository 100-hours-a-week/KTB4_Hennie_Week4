package com.hennie.springdatajpa.domain.user.dto.response;

import lombok.Getter;
import com.hennie.springdatajpa.domain.user.entity.User;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String email;
    private String nickname;
    private String profileUrl;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.profileUrl = user.getProfileUrl();
    }
}