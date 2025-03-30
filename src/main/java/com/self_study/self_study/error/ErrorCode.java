package com.self_study.self_study.error;


import lombok.Getter;

@Getter
public enum ErrorCode {
    UNCATEGORIZED(9999, "Uncategorized"),
    EMAIL_EXISTED(4001, "Email existed."),
    EMAIL_NOT_FOUND(4002, "Email not found."),
    ;
    private Integer code;
    private String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
