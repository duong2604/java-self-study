package com.self_study.self_study.service;

import com.self_study.self_study.dto.request.UserCreationRequest;
import com.self_study.self_study.dto.request.UserUpdateRequest;
import com.self_study.self_study.entity.User;
import com.self_study.self_study.error.ErrorCode;
import com.self_study.self_study.exception.AppException;
import com.self_study.self_study.mapper.UserMapper;
import com.self_study.self_study.repository.UserRepository;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addNewUser(UserCreationRequest request) {

        if (userRepository.existsUserByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }
        User user = UserMapper.INSTANCE.toUser(request);
        PasswordEncoder password = new BCryptPasswordEncoder(10);
        user.setPassword(password.encode(request.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User findUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    public User updateUser(String userId, UserUpdateRequest request) {
        User user = findUser(userId);
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }

    public String deleteUser(String userId) {
        userRepository.deleteById(userId);
        return "User Deleted Successfully";
    }


}
