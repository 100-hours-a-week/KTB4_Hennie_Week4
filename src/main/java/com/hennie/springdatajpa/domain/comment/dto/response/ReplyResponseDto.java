package com.hennie.springdatajpa.domain.comment.dto.response;

import com.hennie.springdatajpa.domain.comment.entity.Reply;
import lombok.Getter;

@Getter
public class ReplyResponseDto {
    private Long replyId;
    private String nickname;
    private String content;
    private String createdAt;
    private boolean isDeleted;

    public ReplyResponseDto(Reply reply) {
        this.replyId = reply.getId();
        this.nickname = reply.isDeleted() ? null : reply.getAuthor().getNickname();
        this.content = reply.getContent();
        this.createdAt = reply.getFormattedCreatedAt();
        this.isDeleted = reply.isDeleted();
    }
}
