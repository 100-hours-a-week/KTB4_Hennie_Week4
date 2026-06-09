package com.hennie.springdatajpa.domain.comment.entity;

import com.hennie.springdatajpa.domain.post.entity.Post;
import com.hennie.springdatajpa.domain.user.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Reply {
    private Long id;
    private User author;
    private String content;
    private LocalDateTime createdAt;
    private boolean deleted;

    public Reply(Long id, User author, String content, boolean deleted) {
        this.id = id;
        this.author = author;
        this.content = deleted ? "삭제된 댓글입니다" : content;
        this.createdAt = LocalDateTime.now();
        this.deleted = deleted;
    }

    public String getFormattedCreatedAt() {
        return createdAt.format(Post.DATE_TIME_FORMATTER);
    }
}
