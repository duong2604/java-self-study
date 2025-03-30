package com.self_study.self_study.mapper;

import com.self_study.self_study.dto.request.UserCreationRequest;
import com.self_study.self_study.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserCreationRequest request);
}
