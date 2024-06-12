package com.zerobase.semiproject.service;

import com.zerobase.semiproject.dto.JwtDto;
import com.zerobase.semiproject.dto.UserDto;
import com.zerobase.semiproject.dto.UserPwdDto;
import com.zerobase.semiproject.entity.UserEntity;
import com.zerobase.semiproject.entity.UserJwtRefreshEntity;
import com.zerobase.semiproject.entity.UserPwdEntity;
import com.zerobase.semiproject.exception.UserException;
import com.zerobase.semiproject.mapper.UserMapper;
import com.zerobase.semiproject.mapper.UserPwdMapper;
import com.zerobase.semiproject.repository.UserJwtRefreshRepository;
import com.zerobase.semiproject.repository.UserPwdRepository;
import com.zerobase.semiproject.repository.UserRepository;
import com.zerobase.semiproject.utils.CipherUtils;
import com.zerobase.semiproject.utils.JwtUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.zerobase.semiproject.exception.constant.UserExceptionCode.USER_NOT_FOUND;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserPwdRepository userPwdRepository;
    private final UserJwtRefreshRepository userJwtRefreshRepository;

    @Transactional
    public void save(UserDto userDto) throws UserException, EntityNotFoundException{
        UserEntity userEntity = UserMapper.INSTANCE.userDtoToEntity(userDto);
        userEntity = userRepository.save(userEntity);

        UserPwdDto userPwdDto = userDto.createUserPwdDto(userEntity);
        UserPwdEntity userPwdEntity = UserPwdMapper.Instance.userDtoToEntity(userPwdDto);
        userPwdRepository.save(userPwdEntity);
    }

    public UserDto selectUserByUserKey(Long userKey) {
        return UserMapper.INSTANCE.userEntityToDto(userRepository.findById(userKey).orElseThrow(() -> new UserException(USER_NOT_FOUND)));
    }

    public JwtDto loginUser(UserDto userDto) {
        UserEntity userEntity = userRepository.findByNickname(userDto.getNickname())
                                                                      .orElseThrow(() -> new UserException(USER_NOT_FOUND));
        if (!validPwd(userEntity, userDto.getPwd())) {
            throw new UserException(USER_NOT_FOUND);
        }
        JwtDto jwtDto = JwtUtils.createJwtToken(userEntity.getUserKey());

        userJwtRefreshRepository.save(jwtDto.createJwtEntity(userEntity));

        return jwtDto;
    }

    private boolean validPwd(UserEntity userEntity, String pwd) {
        return userEntity.getUserPwd().getPwd().equals(CipherUtils.encryptSHA512(pwd));
    }

    public void logoutUser(String jwtToken) {
        Long userKey = JwtUtils.getUserKey(jwtToken);

        UserJwtRefreshEntity userJwtRefreshEntity = UserJwtRefreshEntity.builder()
                .userKey(userKey)
                .build();

        userJwtRefreshRepository.save(userJwtRefreshEntity);
    }
}
