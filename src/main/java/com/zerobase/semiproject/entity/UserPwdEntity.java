package com.zerobase.semiproject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

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
    @UpdateTimestamp
    private LocalDateTime changeDt;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "USER_KEY")
    private UserEntity userEntity;

    @Builder
    public UserPwdEntity(long userKey, String pwd, LocalDateTime changeDt, UserEntity userEntity) {
        this.userKey = userKey;
        this.pwd = pwd;
        this.changeDt = changeDt;
        this.userEntity = userEntity;
    }
}
