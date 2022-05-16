package com.movieaddict.controller;

import com.movieaddict.pojo.ReturnMessage;
import com.movieaddict.pojo.User;
import com.movieaddict.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * #Author :Sino
 * #Date   :2022/5/15 12:31
 * #Describe:
 */
@Controller
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/userLogin")
    @ResponseBody
    public ReturnMessage userLogin(User user, HttpSession session) {
        final boolean loginResult = service.userLogin(user);
        if (loginResult) {
            session.setAttribute(user.getUserName(), UUID.randomUUID().toString().substring(0, 9));
            return ReturnMessage.success();
        } else {
            session.removeAttribute(user.getUserName());
            return ReturnMessage.fail().add("loginFailMessage", "用户名或密码错误");
        }
    }

    @PostMapping("/userRegister")
    @ResponseBody
    public ReturnMessage userRegister(@Valid User user, BindingResult bindingResult) {
        Map<String, Object> messageMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            final List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                messageMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ReturnMessage.fail().add("errorMessage", messageMap);
        } else {
            service.userRegister(user);
            return ReturnMessage.success();
        }
    }

    @GetMapping("/userNameCheck")
    @ResponseBody
    public ReturnMessage userNameCheck(User user) {
        final boolean result = service.userNameCheck(user);
        if(result) {
            return ReturnMessage.success();
        } else {
            return ReturnMessage.fail();
        }
    }
}
