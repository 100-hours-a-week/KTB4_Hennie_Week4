package com.hennie.springdatajpa.domain.like.repository;

import com.hennie.springdatajpa.domain.like.entity.PostLike;

import java.util.Optional;

// DB 사용 시:
// public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
//     boolean existsByPostIdAndUserId(Long postId, Long userId);
//     Optional<PostLike> findByPostIdAndUserId(Long postId, Long userId);
//     long countByPostId(Long postId);
//     void deleteByPostId(Long postId);
// }

// DB 없이 Map 기반으로 구현
public interface PostLikeRepository {
    PostLike save(PostLike postLike);

    boolean existsByPostIdAndUserId(Long postId, Long userId);

    Optional<PostLike> findByPostIdAndUserId(Long postId, Long userId);

    long countByPostId(Long postId);

    void deleteLike(PostLike postLike);

    void deleteById(Long postId);
}
