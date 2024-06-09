package com.zerobase.semiproject.mapper;

import com.zerobase.semiproject.dto.UserDto;
import com.zerobase.semiproject.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity userDtoToEntity(UserDto userDto);
    UserDto userEntityToDto(UserEntity userEntity);
}
