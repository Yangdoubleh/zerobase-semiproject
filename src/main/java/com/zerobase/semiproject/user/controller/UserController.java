package com.zerobase.semiproject.user.controller;

import com.zerobase.semiproject.dto.user.UserDto;
import com.zerobase.semiproject.user.exception.UserException;
import com.zerobase.semiproject.user.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/user/{loginId}")
    Mono<ResponseEntity> findUserByLoginId(@PathVariable("loginId") String loginId) {
        Object body;
        try {
            body = userService.findUserByLoginId(loginId);
        } catch (UserException e) {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
        }
        return Mono.just(ResponseEntity.ok(body));
    }

    @PostMapping("/user/createUser")
    Mono<ResponseEntity> createUser(UserDto userDto) {
        Object body;
        try {
            body = userService.save(userDto);
        } catch (UserException e) {
            log.error(e.getMessage());
            return Mono.just(ResponseEntity.status(HttpStatus.CONFLICT).build());
        } catch (EntityNotFoundException e) {
            log.error(e.getMessage());
            return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
        }

        return Mono.just(ResponseEntity.ok(body));
    }
}
