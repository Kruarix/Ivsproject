package com.example.ivsserver.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class login {
    @RequestMapping("/test")

    public String test(){
        return "test";
    }





}
