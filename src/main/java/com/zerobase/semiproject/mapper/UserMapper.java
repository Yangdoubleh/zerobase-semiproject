package com.zerobase.semiproject.mapper;

import com.zerobase.semiproject.utils.CipherUtils;
import com.zerobase.semiproject.dto.UserDto;
import com.zerobase.semiproject.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "email", target = "email", qualifiedByName = "encryptAES256")
    @Mapping(source = "name", target = "name", qualifiedByName = "encryptAES256")
    @Mapping(source = "phone", target = "phone", qualifiedByName = "encryptAES256")
    UserEntity userDtoToEntity(UserDto userDto);

    @Mapping(source = "email", target = "email", qualifiedByName = "decryptAES256")
    @Mapping(source = "name", target = "name", qualifiedByName = "decryptAES256")
    @Mapping(source = "phone", target = "phone", qualifiedByName = "decryptAES256")
    UserDto userEntityToDto(UserEntity userEntity);

    @Named("encryptAES256")
    default String encryptAES256(String string) {
        return CipherUtils.encryptAES256(string);
    }

    @Named("decryptAES256")
    default String decryptAES256(String string) {
        return CipherUtils.decryptAES256(string);
    }
}
