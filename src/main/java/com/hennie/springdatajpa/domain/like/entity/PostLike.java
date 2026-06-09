package com.hennie.springdatajpa.domain.like.entity;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostLike {
    private Long id;
    private Long postId;
    private Long userId;
    private LocalDateTime createdAt;

    public PostLike(Long postId, Long userId) {
        this.postId = postId;
        this.userId = userId;
        this.createdAt = LocalDateTime.now();
    }

    public void assignId(Long id) {
        if (this.id == null) {
            this.id = id;
        }
    }
}
