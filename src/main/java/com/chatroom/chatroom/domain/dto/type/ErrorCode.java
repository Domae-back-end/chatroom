package com.chatroom.chatroom.domain.dto.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    //JWT
    WRONG_JWT_TOKEN(HttpStatus.UNAUTHORIZED, "토큰정보가 잘못되었습니다."),
    FINISH_JWT_TOKEN(HttpStatus.UNAUTHORIZED,"만료된 토큰 정보입니다."),
    UNSUPPORTED_JWT_TOKEN(HttpStatus.UNAUTHORIZED,"지원되지 않는 JWT 토큰입니다."),
    CLAIMS_NOT_JWT_TOKEN(HttpStatus.UNAUTHORIZED,"JWT 클레임 문자열이 null"),
    //Login
    USER_NOT_FOUND(HttpStatus.UNAUTHORIZED,"계정을 찾을 수 없습니다.");



    private final HttpStatus status;
    private final String message;

}
