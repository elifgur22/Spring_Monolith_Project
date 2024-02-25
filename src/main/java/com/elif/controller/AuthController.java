package com.elif.controller;

import com.elif.dto.request.RegisterRequestDto;
import com.elif.entity.Auth;
import com.elif.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.elif.utility.constants.RestApiUrls.AUTH;
import static com.elif.utility.constants.RestApiUrls.REGISTER;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH)
public class AuthController {
    private final AuthService authService;
    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody @Valid RegisterRequestDto dto) {
        return ResponseEntity.ok(authService.save(dto));
    }
}
