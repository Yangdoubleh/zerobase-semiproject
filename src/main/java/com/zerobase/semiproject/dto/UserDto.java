package com.zerobase.semiproject.dto;

import com.zerobase.semiproject.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
public class UserDto {

    public long userKey;
    public String email;
    public String nickname;
    public long year;
    public String name;
    public String phone;
    public String pwd;

    @Builder
    public UserDto(long userKey, String email, String nickname, long year, String name, String phone, String pwd) {
        this.userKey = userKey;
        this.email = email;
        this.nickname = nickname;
        this.year = year;
        this.name = name;
        this.phone = phone;
        this.pwd = pwd;
    }

    public UserDto() {
    }

    public UserPwdDto createUserPwdDto(UserEntity userEntity) {
        return UserPwdDto.builder()
                .pwd(this.pwd)
                .userEntity(userEntity)
                .build();
    }

    public void encryptUserDto() {

    }
}
