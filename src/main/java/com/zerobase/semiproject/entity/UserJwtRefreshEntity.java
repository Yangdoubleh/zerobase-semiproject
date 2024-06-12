package com.zerobase.semiproject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_USER_JWT_REFRESH")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserJwtRefreshEntity {
    @Id
    @JoinColumn(name = "USER_KEY")
    private long userKey;

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "USER_KEY")
    private UserEntity userEntity;

    @Builder
    public UserJwtRefreshEntity(long userKey, String refreshToken, UserEntity userEntity) {
        this.userKey = userKey;
        this.refreshToken = refreshToken;
        this.userEntity = userEntity;
    }
}
