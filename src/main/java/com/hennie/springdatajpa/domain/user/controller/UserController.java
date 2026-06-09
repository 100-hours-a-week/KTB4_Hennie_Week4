package com.hennie.springdatajpa.domain.user.controller;

import com.hennie.springdatajpa.domain.user.dto.request.UserInfoRequestDto;
import com.hennie.springdatajpa.domain.user.dto.request.UserRequestDto;
import com.hennie.springdatajpa.domain.user.dto.response.UserResponseDto;
import com.hennie.springdatajpa.domain.user.service.UserService;
import com.hennie.springdatajpa.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(@Valid @RequestBody UserRequestDto request) {
        UserResponseDto result = userService.createUser(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "/users/" + result.getId())
                .body(ApiResponse.of("SIGNUP_SUCCESS", result));
    }

    // 회원정보 조회
    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUser(@PathVariable Long userId){
        UserResponseDto result = userService.getUser(userId);
        return ResponseEntity.ok(
                ApiResponse.of("GET_INFO_SUCCESS", result)
        );
    }

    // 회원정보 수정
    @PatchMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserResponseDto>> updateNickname(
            @PathVariable Long userId,
            @Valid @RequestBody UserInfoRequestDto request
    ) {
        UserResponseDto result = userService.updateUser(userId, request);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.of("UPDATE_INFO_SUCCESS", result));
    }

    // 회원 탈퇴
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.of("USER_DELETED", null));
    }
}
