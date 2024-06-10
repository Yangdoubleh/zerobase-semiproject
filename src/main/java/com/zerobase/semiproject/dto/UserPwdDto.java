package com.zerobase.semiproject.dto;

import com.zerobase.semiproject.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserPwdDto {
    public long userKey;
    public String pwd;
    public String changeDt;
    public UserEntity userEntity;

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
