package com.zerobase.semiproject.user.controller;

import com.zerobase.semiproject.dto.user.UserDto;
import com.zerobase.semiproject.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/user/createUser")
    Mono<ResponseEntity> createUser(UserDto userDto) {
        UserDto body = userService.save(userDto);

        return Mono.just(ResponseEntity.ok(body));
    }
}
