package com.zerobase.semiproject.dto;

import com.zerobase.semiproject.entity.UserEntity;
import com.zerobase.semiproject.entity.UserJwtRefreshEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class JwtDto {
    private String authToken;
    private String refreshToken;

    @Builder
    public JwtDto(String authToken, String refreshToken) {
        this.authToken = authToken;
        this.refreshToken = refreshToken;
    }

    public UserJwtRefreshEntity createJwtEntity(UserEntity userEntity) {
        return UserJwtRefreshEntity.builder()
                            .refreshToken(this.refreshToken)
                            .userEntity(userEntity)
                            .build();
    }
}
