package com.hennie.springdatajpa.domain.comment.repository;

import com.hennie.springdatajpa.domain.comment.entity.Comment;

import java.util.List;
import java.util.Optional;

// DB 사용 시:
// public interface CommentRepository extends JpaRepository<Comment, Long> {
//     List<Comment> findByPostIdOrderByCreatedAtAsc(Long postId);
//     Optional<Comment> findByIdAndPostId(Long id, Long postId);
//     long countByPostId(Long postId);
//     void deleteByPostId(Long postId);
// }

// DB 없이 Map 기반으로 구현
public interface CommentRepository {
    Comment save(Comment comment);

    Optional<Comment> findByIdAndPostId(Long id, Long postId);

    List<Comment> findByPostIdOrderByCreatedAtAsc(Long postId);

    long countByPostId(Long postId);

    void deleteById(Long postId);
}
