package com.ferhatbedir.apply_for_a_job.controller;

import com.ferhatbedir.apply_for_a_job.entity.UserInfo;
import com.ferhatbedir.apply_for_a_job.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("applytojob")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUserInfo(@RequestBody @Valid UserInfo userInfo,
                            BindingResult bindingResult,
                            HttpServletResponse httpServletResponse) throws IOException, MessagingException {
        if (bindingResult.hasErrors()) {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Please check parameters.");
        } else {
            userService.addUserInfo(userInfo);
        }
    }
}
