package com.zerobase.semiproject.mapper;

import com.zerobase.semiproject.dto.UserPwdDto;
import com.zerobase.semiproject.entity.UserPwdEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-09T09:44:38+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class UserPwdMapperImpl implements UserPwdMapper {

    @Override
    public UserPwdEntity userDtoToEntity(UserPwdDto userPwdDto) {
        if ( userPwdDto == null ) {
            return null;
        }

        UserPwdEntity.UserPwdEntityBuilder userPwdEntity = UserPwdEntity.builder();

        userPwdEntity.userKey( userPwdDto.getUserKey() );
        userPwdEntity.pwd( userPwdDto.getPwd() );
        userPwdEntity.changeDt( userPwdDto.getChangeDt() );
        userPwdEntity.userEntity( userPwdDto.getUserEntity() );

        return userPwdEntity.build();
    }

    @Override
    public UserPwdDto userPwdEntityToDto(UserPwdEntity userPwdEntity) {
        if ( userPwdEntity == null ) {
            return null;
        }

        UserPwdDto.UserPwdDtoBuilder userPwdDto = UserPwdDto.builder();

        userPwdDto.userKey( userPwdEntity.getUserKey() );
        userPwdDto.pwd( userPwdEntity.getPwd() );
        userPwdDto.changeDt( userPwdEntity.getChangeDt() );
        userPwdDto.userEntity( userPwdEntity.getUserEntity() );

        return userPwdDto.build();
    }
}
