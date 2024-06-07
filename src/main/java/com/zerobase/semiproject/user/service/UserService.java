package com.zerobase.semiproject.user.service;

import com.zerobase.semiproject.dto.user.UserDto;
import com.zerobase.semiproject.entity.user.UserEntity;
import com.zerobase.semiproject.mapper.user.UserMapper;
import com.zerobase.semiproject.user.exception.UserException;
import com.zerobase.semiproject.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto save(UserDto userDto) throws UserException, EntityNotFoundException{
        UserEntity userEntity = UserMapper.INSTANCE.userDtoToEntity(userDto);

        return UserMapper.INSTANCE.userEntityToDto(userRepository.save(userEntity));
    }
}
