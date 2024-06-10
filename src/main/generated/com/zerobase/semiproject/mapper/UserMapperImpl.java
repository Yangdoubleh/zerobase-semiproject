package com.zerobase.semiproject.mapper;

import com.zerobase.semiproject.dto.UserDto;
import com.zerobase.semiproject.entity.UserEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-10T09:21:28+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity userDtoToEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.email( encryptAES256( userDto.getEmail() ) );
        userEntity.name( encryptAES256( userDto.getName() ) );
        userEntity.phone( encryptAES256( userDto.getPhone() ) );
        userEntity.userKey( userDto.getUserKey() );
        userEntity.nickname( userDto.getNickname() );
        userEntity.year( userDto.getYear() );

        return userEntity.build();
    }

    @Override
    public UserDto userEntityToDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.email( decryptAES256( userEntity.getEmail() ) );
        userDto.name( decryptAES256( userEntity.getName() ) );
        userDto.phone( decryptAES256( userEntity.getPhone() ) );
        userDto.userKey( userEntity.getUserKey() );
        userDto.nickname( userEntity.getNickname() );
        userDto.year( userEntity.getYear() );

        return userDto.build();
    }
}
