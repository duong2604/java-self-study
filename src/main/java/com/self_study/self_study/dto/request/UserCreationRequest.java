package com.self_study.self_study.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserCreationRequest {
    String username;
    @Size(min=8,message = "Password must be at least 8 characters :>")
    String password;
    String email;
    LocalDate dob;
}
