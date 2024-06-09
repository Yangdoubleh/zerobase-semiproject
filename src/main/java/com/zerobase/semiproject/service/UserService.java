package com.zerobase.semiproject.service;

import com.zerobase.semiproject.dto.UserDto;
import com.zerobase.semiproject.dto.UserPwdDto;
import com.zerobase.semiproject.entity.UserEntity;
import com.zerobase.semiproject.entity.UserPwdEntity;
import com.zerobase.semiproject.exception.UserException;
import com.zerobase.semiproject.mapper.UserMapper;
import com.zerobase.semiproject.mapper.UserPwdMapper;
import com.zerobase.semiproject.repository.UserPwdRepository;
import com.zerobase.semiproject.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserPwdRepository userPwdRepository;

    @Transactional
    public void save(UserDto userDto) throws UserException, EntityNotFoundException{
        UserEntity userEntity = UserMapper.INSTANCE.userDtoToEntity(userDto);
        userEntity = userRepository.save(userEntity);

        UserPwdDto userPwdDto = userDto.createUserPwdDto(userEntity);
        UserPwdEntity userPwdEntity = UserPwdMapper.Instance.userDtoToEntity(userPwdDto);
        userPwdRepository.save(userPwdEntity);
    }

    public UserDto selectUserByUserKey(Long userKey) {
        return UserMapper.INSTANCE.userEntityToDto(userRepository.getById(userKey));
    }
}
