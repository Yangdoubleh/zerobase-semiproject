package com.zerobase.semiproject.mapper;

import com.zerobase.semiproject.dto.UserDto;
import com.zerobase.semiproject.entity.UserEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-09T09:22:06+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity userDtoToEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.userKey( userDto.getUserKey() );
        userEntity.email( userDto.getEmail() );
        userEntity.nickname( userDto.getNickname() );
        userEntity.year( userDto.getYear() );
        userEntity.name( userDto.getName() );
        userEntity.phone( userDto.getPhone() );

        return userEntity.build();
    }

    @Override
    public UserDto userEntityToDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.userKey( userEntity.getUserKey() );
        userDto.email( userEntity.getEmail() );
        userDto.nickname( userEntity.getNickname() );
        userDto.year( userEntity.getYear() );
        userDto.name( userEntity.getName() );
        userDto.phone( userEntity.getPhone() );

        return userDto.build();
    }
}
