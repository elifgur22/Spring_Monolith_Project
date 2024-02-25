package com.elif.service;


import com.elif.dto.request.RegisterRequestDto;
import com.elif.entity.Auth;
import com.elif.exception.ErrorType;
import com.elif.exception.HastaneRandevuException;
import com.elif.mapper.AuthMapper;
import com.elif.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public Auth save(RegisterRequestDto dto) {
        Auth auth = AuthMapper.INSTANCE.fromRegisterRequestDtoToAuth(dto);
        Optional<Auth> optionalAuth= authRepository.findOptionalByUsername(auth.getUsername());
        if(optionalAuth.isEmpty()){
            authRepository.save(auth);
            return auth;
        }else {
            throw new HastaneRandevuException(ErrorType.ERROR_DUPLICATE_AUTH);
        }

    }

}
