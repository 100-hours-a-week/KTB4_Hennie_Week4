package com.hennie.springdatajpa.domain.user.repository;

import com.hennie.springdatajpa.domain.user.entity.User;

import java.util.Optional;

// DB 사용 시:
// public interface UserRepository extends JpaRepository<User, Long> {
//     boolean existsByEmail(String email);
//     boolean existsByNickname(String nickname);
// }

// DB 없이 Map 기반으로 구현UserRepository
public interface UserRepository {
    User save(User user);

    Optional<User> findById(Long id);

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);

    void deleteById(Long id);
}
