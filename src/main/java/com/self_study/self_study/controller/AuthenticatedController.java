package com.self_study.self_study.controller;

import com.self_study.self_study.dto.request.AuthenticatedRequest;
import com.self_study.self_study.dto.response.ApiResponse;
import com.self_study.self_study.dto.response.AuthenticatedResponse;
import com.self_study.self_study.service.AuthenticatedService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticatedController {
    @Autowired
    AuthenticatedService authenticatedService;

    @PostMapping("/log-in")
    public ApiResponse<AuthenticatedResponse> authenticate(@RequestBody AuthenticatedRequest request){
        boolean result = authenticatedService.authenticate(request);
        return ApiResponse.<AuthenticatedResponse>builder().result(
                    AuthenticatedResponse.builder()
                            .authenticated(result)
                            .build()
                )
                .build();
    }

}
