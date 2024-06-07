package com.zerobase.semiproject.entity.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "TB_USER")
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_KEY")
    private long userKey;

    @Column(name="EMAIL")
    private String email;

    @Column(name="NICKNAME", unique = true)
    private String nickname;

    @Column(name="YEAR")
    private long year;

    @Column(name="NAME")
    private String name;

    @Column(name="PHONE")
    private String phone;

    public UserEntity() {
    }

    @Builder
    public UserEntity(long userKey, String email, String nickname, long year, String name, String phone) {
        this.userKey = userKey;
        this.email = email;
        this.nickname = nickname;
        this.year = year;
        this.name = name;
        this.phone = phone;
    }
}
