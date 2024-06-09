package com.zerobase.semiproject.mapper;

import com.zerobase.semiproject.dto.UserPwdDto;
import com.zerobase.semiproject.entity.UserPwdEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserPwdMapper {
    UserPwdMapper Instance = Mappers.getMapper(UserPwdMapper.class);

    UserPwdEntity userDtoToEntity(UserPwdDto userPwdDto);

    UserPwdDto userPwdEntityToDto(UserPwdEntity userPwdEntity);
}
