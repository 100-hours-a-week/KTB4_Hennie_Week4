package com.hennie.springdatajpa.domain.user.dto.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoRequestDto {
    @Pattern(regexp = "^\\S+$", message = "닉네임은 띄어쓰기를 사용할 수 없습니다.")
    @Size(max = 10, message = "닉네임은 최대 10자 까지 작성 가능합니다.")
    private String nickname;

    private String profileUrl;
}
