package com.chatroom.chatroom.error;

import com.chatroom.chatroom.domain.dto.type.ErrorCode;
import com.chatroom.chatroom.domain.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RestApiException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(RestApiException e) {
        return handleExceptionInternal(e.getErrorCode());
    }

    protected ResponseEntity<ErrorResponse> handleExceptionInternal(ErrorCode e) {
        return ResponseEntity
                .status(e.getStatus().value())
                .body(new ErrorResponse(e));
    }


}
