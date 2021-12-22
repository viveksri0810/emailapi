package com.email.controller;

import com.email.Service.SendEmail;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @PostMapping("/welcome")
    public String welcome(){
        return "hello this is my email api project";
    }

    @PostMapping("/sendEmail")
    public void sendMail(){
        SendEmail.sendEmail();
    }
}
