package com.zerobase.semiproject.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    long userKey;
    String email;
    String nickname;
    long year;
    String name;
    String phone;

    @Builder
    public UserDto(long userKey, String email, String nickname, long year, String name, String phone) {
        this.userKey = userKey;
        this.email = email;
        this.nickname = nickname;
        this.year = year;
        this.name = name;
        this.phone = phone;
    }

    public UserDto() {
    }
}
