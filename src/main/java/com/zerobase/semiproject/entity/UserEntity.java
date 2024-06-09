package com.zerobase.semiproject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_USER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @OneToOne(mappedBy = "userEntity")
    @PrimaryKeyJoinColumn
    private UserPwdEntity userPwd;

    @OneToMany(mappedBy = "follower")
    private Set<FollowEntity> followers = new HashSet<>();

    @OneToMany(mappedBy = "followee")
    private Set<FollowEntity> followees = new HashSet<>();

    @Builder
    public UserEntity(long userKey, String email, String nickname, long year, String name, String phone, UserPwdEntity userPwd, Set<FollowEntity> followers, Set<FollowEntity> followees) {
        this.userKey = userKey;
        this.email = email;
        this.nickname = nickname;
        this.year = year;
        this.name = name;
        this.phone = phone;
        this.userPwd = userPwd;
        this.followers = followers;
        this.followees = followees;
    }
}
