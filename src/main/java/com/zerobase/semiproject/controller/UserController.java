package com.zerobase.semiproject.controller;

import com.zerobase.semiproject.dto.UserDto;
import com.zerobase.semiproject.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    Mono<ResponseEntity> createUser(UserDto userDto) {
        userService.save(userDto);

        return Mono.just(ResponseEntity.ok().build());
    }

    @GetMapping("/user/{userKey}")
    Mono<ResponseEntity> selectUser(@PathVariable("userKey") Long userKey) {
        return Mono.just(ResponseEntity.ok(userService.selectUserByUserKey(userKey)));
    }
}
