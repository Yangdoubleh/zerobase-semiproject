package com.zerobase.semiproject.dto;

import com.zerobase.semiproject.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPwdDto {
    long userKey;
    String pwd;
    String changeDt;
    UserEntity userEntity;

    @Builder
    public UserPwdDto(long userKey, String pwd, String changeDt, UserEntity userEntity) {
        this.userKey = userKey;
        this.pwd = pwd;
        this.changeDt = changeDt;
        this.userEntity = userEntity;
    }

    public UserPwdDto() {
    }
}
