package com.hennie.springdatajpa.domain.comment.repository;

import com.hennie.springdatajpa.domain.comment.entity.Comment;
import com.hennie.springdatajpa.global.store.InMemoryDataStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InMemoryCommentRepository implements CommentRepository {

    private final InMemoryDataStore store;

    @Override
    public Comment save(Comment comment) {
        if (comment.getId() == null) {
            comment.assignId(store.nextCommentId());
        }
        store.getComments().put(comment.getId(), comment);
        return comment;
    }

    @Override
    public Optional<Comment> findByIdAndPostId(Long id, Long postId) {
        Comment comment = store.getComments().get(id);
        if (comment == null || !comment.getPostId().equals(postId)) {
            return Optional.empty();
        }
        return Optional.of(comment);
    }

    @Override
    public List<Comment> findByPostIdOrderByCreatedAtAsc(Long postId) {
        return store.getComments().values().stream()
                .filter(comment -> comment.getPostId().equals(postId))
                .sorted(Comparator.comparing(Comment::getCreatedAt))
                .toList();
    }

    @Override
    public long countByPostId(Long postId) {
        return store.getComments().values().stream()
                .filter(comment -> comment.getPostId().equals(postId))
                .count();
    }

    @Override
    public void deleteById(Long postId) {
        store.getComments().entrySet()
                .removeIf(entry -> entry.getValue().getPostId().equals(postId));
    }
}
