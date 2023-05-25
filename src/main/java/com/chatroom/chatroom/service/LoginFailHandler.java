package com.chatroom.chatroom.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginFailHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String errorMessage;

        if (exception instanceof BadCredentialsException) {
            errorMessage = "1";
        } else if (exception instanceof InternalAuthenticationServiceException) {
            errorMessage = "2";
        } else if (exception instanceof UsernameNotFoundException) {
            errorMessage = "3";
        } else if (exception instanceof AuthenticationCredentialsNotFoundException) {
            errorMessage = "4";
        } else {
            errorMessage = "error";
        }
        setDefaultFailureUrl("/login?errorMessage=" + errorMessage);

        super.onAuthenticationFailure(request, response, exception);
    }
}
