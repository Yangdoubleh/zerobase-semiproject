package com.zerobase.semiproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_USER_PWD")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserPwdEntity {

    @Id
    @JoinColumn(name = "USER_KEY")
    private long userKey;

    @Column(name = "PWD")
    private String pwd;

    @Column(name = "CHANGE_DT")
    private String changeDt;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "USER_KEY")
    private UserEntity userEntity;

    @Builder
    public UserPwdEntity(long userKey, String pwd, String changeDt, UserEntity userEntity) {
        this.userKey = userKey;
        this.pwd = pwd;
        this.changeDt = changeDt;
        this.userEntity = userEntity;
    }
}
