package com.self_study.self_study.service;

import com.self_study.self_study.dto.request.AuthenticatedRequest;
import com.self_study.self_study.error.ErrorCode;
import com.self_study.self_study.exception.AppException;
import com.self_study.self_study.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticatedService {
    @Autowired
    UserRepository userRepository;
  public boolean authenticate(AuthenticatedRequest request) {
        var user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.EMAIL_NOT_FOUND));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return  passwordEncoder.matches(request.getPassword(), user.getPassword());
    }
}
