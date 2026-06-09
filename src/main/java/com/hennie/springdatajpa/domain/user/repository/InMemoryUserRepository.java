package com.hennie.springdatajpa.domain.user.repository;

import com.hennie.springdatajpa.domain.user.entity.User;
import com.hennie.springdatajpa.global.store.InMemoryDataStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InMemoryUserRepository implements UserRepository {

    private final InMemoryDataStore store;

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.assignId(store.nextUserId());
        }
        store.getUsers().put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.getUsers().get(id));
    }

    @Override
    public boolean existsByEmail(String email) {
        return store.getUsers().values().stream()
                .anyMatch(user -> user.getEmail().equals(email));
    }

    @Override
    public boolean existsByNickname(String nickname) {
        return store.getUsers().values().stream()
                .anyMatch(user -> user.getNickname().equals(nickname));
    }

    @Override
    public void deleteById(Long id) {
        store.getUsers().remove(id);
    }
}
