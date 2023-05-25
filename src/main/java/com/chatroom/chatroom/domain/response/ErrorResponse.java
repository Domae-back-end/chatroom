package com.chatroom.chatroom.domain.response;

import com.chatroom.chatroom.domain.dto.type.ErrorCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {

    private final LocalDateTime timestamp = LocalDateTime.now();
    private final int statusCode;
    private final String error;
    private final String message;

    public ErrorResponse(ErrorCode errorCode) {
        this.statusCode = errorCode.getStatus().value();
        this.error = errorCode.getStatus().name();
        this.message = errorCode.getMessage();
    }

}
