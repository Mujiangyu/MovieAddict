package com.movieaddict.controller;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * #Author :Sino
 * #Date   :2022/5/16 12:26
 * #Describe:
 */
public class UserInteceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if(uri.toLowerCase().contains("index") || uri.toLowerCase().contains("main")) {
            final HttpSession session = request.getSession();
            if(session.getAttributeNames().hasMoreElements()) {
                return true;
            } else {
                response.sendRedirect(request.getContextPath() + "/");
                return false;
            }
        }
        return true;
    }
}
