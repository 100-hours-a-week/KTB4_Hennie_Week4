package com.hennie.springdatajpa.domain.user.entity;

import lombok.Getter;

// DB 사용 시:
// @Entity
@Getter
// @RequiredArgsConstructor
public class User {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "user_id")
    private Long id;

    // @Column(nullable = false, unique = true)
    private String email;
    private String password;

    // @Column(nullable = false, unique = true)
    private String nickname;
    private String profileUrl;

    // @OneToMany(mappedBy = "author")
    // List<Post> posts = new ArrayList<>();

    public User(String email, String password, String nickname, String profileUrl) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profileUrl = profileUrl;
    }

    public void assignId(Long id) {
        if (this.id == null) {
            this.id = id;
        }
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }

    public void changeProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

}
