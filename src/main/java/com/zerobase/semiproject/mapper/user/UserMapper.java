package com.zerobase.semiproject.mapper.user;

import com.zerobase.semiproject.dto.user.UserDto;
import com.zerobase.semiproject.entity.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity userDtoToEntity(UserDto userDto);
    UserDto userEntityToDto(UserEntity userEntity);
}
