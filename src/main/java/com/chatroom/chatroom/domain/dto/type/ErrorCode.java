package com.chatroom.chatroom.domain.dto.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {


    USER_NOT_FOUND(HttpStatus.UNAUTHORIZED,"계정을 찾을 수 없습니다.");



    private final HttpStatus status;
    private final String message;

}
