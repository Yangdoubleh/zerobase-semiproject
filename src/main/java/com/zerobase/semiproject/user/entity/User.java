package com.zerobase.semiproject.user.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "TB_USER")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private long userId;

    @Column(nullable = false, unique = true, name = "LOGIN_ID")
    private String loginId;

    @Builder
    public User(long userId, String loginId) {
        this.userId = userId;
        this.loginId = loginId;
    }

    public User() {
    }
}
