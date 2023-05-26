package com.chatroom.chatroom.domain.response;

import lombok.AllArgsConstructor;


public record Response<T>(

        String result_code,
        T result

) {

    public Response(String result_code, T result) {
        this.result_code = result_code;
        this.result = result;
    }

    public static Response<Void> error(String errorCode){
        return new Response<>(errorCode,null);
    }

    public static <T> Response<T> success(T result){
        return new Response<>("Success",result);
    }


}
