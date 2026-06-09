package com.hennie.springdatajpa.domain.like.repository;

import com.hennie.springdatajpa.domain.like.entity.PostLike;
import com.hennie.springdatajpa.global.store.InMemoryDataStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InMemoryPostLikeRepository implements PostLikeRepository {

    private final InMemoryDataStore store;

    @Override
    public PostLike save(PostLike postLike) {
        if (postLike.getId() == null) {
            postLike.assignId(store.nextPostLikeId());
        }
        store.getPostLikes().put(postLike.getId(), postLike);
        return postLike;
    }

    @Override
    public boolean existsByPostIdAndUserId(Long postId, Long userId) {
        return store.getPostLikes().values().stream()
                .anyMatch(postLike -> postLike.getPostId().equals(postId)
                        && postLike.getUserId().equals(userId));
    }

    @Override
    public Optional<PostLike> findByPostIdAndUserId(Long postId, Long userId) {
        return store.getPostLikes().values().stream()
                .filter(postLike -> postLike.getPostId().equals(postId)
                        && postLike.getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public long countByPostId(Long postId) {
        return store.getPostLikes().values().stream()
                .filter(postLike -> postLike.getPostId().equals(postId))
                .count();
    }

    @Override
    public void deleteLike(PostLike postLike) {
        store.getPostLikes().remove(postLike.getId());
    }

    @Override
    public void deleteById(Long postId) {
        store.getPostLikes().entrySet()
                .removeIf(entry -> entry.getValue().getPostId().equals(postId));
    }
}
