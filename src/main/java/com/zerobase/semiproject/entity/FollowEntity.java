package com.zerobase.semiproject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_FOLLOW")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FollowEntity {

    @Id
    @GeneratedValue
    @Column(name = "FOLLOW_KEY")
    private Long followKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOLLOW_USERID")
    private UserEntity follower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOLLOWING_USERID")
    private UserEntity followee;

    @Builder
    public FollowEntity(Long followKey, UserEntity follower, UserEntity followee) {
        this.followKey = followKey;
        this.follower = follower;
        this.followee = followee;
    }
}
