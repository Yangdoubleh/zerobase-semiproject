package com.zerobase.semiproject.user.service;

import com.zerobase.semiproject.user.dto.UserDto;
import com.zerobase.semiproject.user.entity.User;
import com.zerobase.semiproject.user.exception.UserException;
import com.zerobase.semiproject.user.exception.constant.UserExceptionCode;
import com.zerobase.semiproject.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findUserByLoginId(String loginId) throws UserException, EntityNotFoundException {
        return userRepository.findUserByLoginId(loginId).orElseThrow(
                () -> new UserException(UserExceptionCode.USER_NOT_FOUND)
        );
    }

    public User save(UserDto userDto) throws UserException, EntityNotFoundException{
        String loginId = userDto.getLoginId();
        checkDuplicateLoginId(loginId);
        User user = User.builder()
                .loginId(loginId)
                .build();
        return userRepository.save(user);
    }

    private void checkDuplicateLoginId(String loginId) {
        userRepository.findUserByLoginId(loginId).ifPresent((Exception) -> new UserException(UserExceptionCode.USERID_DUPLICATE));
    }
}
