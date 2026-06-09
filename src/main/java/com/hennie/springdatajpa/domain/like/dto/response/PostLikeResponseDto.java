package com.hennie.springdatajpa.domain.like.dto.response;

import lombok.Getter;

@Getter
public class PostLikeResponseDto {
    private Long postId;
    private int likeCount;
    private boolean isLiked;

    public PostLikeResponseDto(Long postId, int likeCount, boolean liked) {
        this.postId = postId;
        this.likeCount = likeCount;
        this.isLiked = liked;
    }
}
