package com.chatroom.chatroom.error;

import com.chatroom.chatroom.domain.dto.type.ErrorCode;
import lombok.Getter;

@Getter
public class RestApiException extends RuntimeException{

    private final ErrorCode errorCode;

    public RestApiException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
