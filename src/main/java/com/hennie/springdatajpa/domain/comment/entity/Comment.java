package com.hennie.springdatajpa.domain.comment.entity;

import com.hennie.springdatajpa.domain.post.entity.Post;
import com.hennie.springdatajpa.domain.user.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Comment {
    private Long id;
    private Long postId;
    private User author;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private boolean deleted;
    private List<Reply> replies = new ArrayList<>();

    public Comment(Long postId, User author, String content) {
        this.postId = postId;
        this.author = author;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = this.createdAt;
    }

    public Comment(Long postId, User author, String content, boolean deleted) {
        this.postId = postId;
        this.author = author;
        this.content = deleted ? "삭제된 댓글입니다" : content;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = this.createdAt;
        this.deleted = deleted;
    }

    public void assignId(Long id) {
        if (this.id == null) {
            this.id = id;
        }
    }

    public void update(String content) {
        this.content = content;
        this.modifiedAt = LocalDateTime.now();
    }

    public void delete() {
        this.content = "삭제된 댓글입니다";
        this.deleted = true;
        this.modifiedAt = LocalDateTime.now();
    }

    public void addReply(Reply reply) {
        replies.add(reply);
    }

    public String getFormattedCreatedAt() {
        return createdAt.format(Post.DATE_TIME_FORMATTER);
    }
}
