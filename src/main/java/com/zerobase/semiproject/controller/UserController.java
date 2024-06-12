package com.zerobase.semiproject.controller;

import com.zerobase.semiproject.dto.JwtDto;
import com.zerobase.semiproject.dto.UserDto;
import com.zerobase.semiproject.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
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

    @PostMapping("/user/login")
    Mono<ResponseEntity> loginUser(UserDto userDto, HttpServletResponse response) {
        JwtDto jwtDto = userService.loginUser(userDto);
        response.setHeader("ACCESS_TOKEN", jwtDto.getAuthToken());
        response.setHeader("REFRESTH_TOKEN", jwtDto.getRefreshToken());

        return Mono.just(ResponseEntity.ok().build());
    }

    @PostMapping("/user/logout")
    Mono<ResponseEntity> logoutUser(HttpServletRequest request) {
        String jwtToken = request.getHeader("ACCESS_TOKEN");
        userService.logoutUser(jwtToken);

        return Mono.just(ResponseEntity.ok().build());
    }
}
