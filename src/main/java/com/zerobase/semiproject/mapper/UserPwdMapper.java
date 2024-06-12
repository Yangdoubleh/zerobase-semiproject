package com.zerobase.semiproject.mapper;

import com.zerobase.semiproject.utils.CipherUtils;
import com.zerobase.semiproject.dto.UserPwdDto;
import com.zerobase.semiproject.entity.UserPwdEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserPwdMapper {
    UserPwdMapper Instance = Mappers.getMapper(UserPwdMapper.class);

    @Mapping(source = "pwd", target = "pwd", qualifiedByName = "encryptSHA512")
    UserPwdEntity userDtoToEntity(UserPwdDto userPwdDto);

    UserPwdDto userPwdEntityToDto(UserPwdEntity userPwdEntity);

    @Named("encryptSHA512")
    default String encryptSHA512(String str) {
        return CipherUtils.encryptSHA512(str);
    }
}
